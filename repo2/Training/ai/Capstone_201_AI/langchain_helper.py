import os
from langchain.llms import GooglePalm
from langchain.utilities import SQLDatabase
from langchain_experimental.sql import SQLDatabaseChain
from langchain.prompts import SemanticSimilarityExampleSelector
from langchain.embeddings import HuggingFaceEmbeddings
from langchain.vectorstores import Chroma
from langchain.prompts import FewShotPromptTemplate
from langchain.chains.sql_database.prompt import PROMPT_SUFFIX
from langchain.prompts.prompt import PromptTemplate
from few_shots import few_shots
from dotenv import load_dotenv

load_dotenv()  # Load environment variables (including Google API key)

def get_few_shot_db_chain():
    db_user = "root"
    db_password = "root"
    db_host = "localhost"
    db_name = "atliq_tshirts"

    db = SQLDatabase.from_uri(f"mysql+pymysql://{db_user}:{db_password}@{db_host}/{db_name}", sample_rows_in_table_info=3)
    llm = GooglePalm(google_api_key=os.getenv("GOOGLE_API_KEY"), temperature=0.1)

    embeddings = HuggingFaceEmbeddings(model_name="sentence-transformers/all-MiniLM-L6-v2")
    to_vectorize = [" ".join(example.values()) for example in few_shots]
    vectorstore = Chroma.from_texts(to_vectorize, embeddings, metadatas=few_shots)
    example_selector = SemanticSimilarityExampleSelector(vectorstore=vectorstore, k=2)

    example_prompt = PromptTemplate(
        input_variables=["Question", "SQLQuery", "SQLResult", "Answer"],
        template="\nQuestion: {Question}\nSQLQuery: {SQLQuery}\nSQLResult: {SQLResult}\nAnswer: {Answer}",
    )

    few_shot_prompt = FewShotPromptTemplate(
        example_selector=example_selector,
        example_prompt=example_prompt,
        prefix="You are a MySQL expert. Given a question, first create a valid SQL query, then return the answer.",
        suffix=PROMPT_SUFFIX,
        input_variables=["input", "table_info", "top_k"]
    )

    chain = SQLDatabaseChain.from_llm(llm, db, verbose=True, prompt=few_shot_prompt)
    return chain
