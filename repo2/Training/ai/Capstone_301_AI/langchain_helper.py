from langchain.vectorstores import FAISS
from langchain.llms import GooglePalm
from langchain.document_loaders.csv_loader import CSVLoader
from langchain.embeddings import HuggingFaceInstructEmbeddings
from langchain.prompts import PromptTemplate
from langchain.chains import RetrievalQA
import os
from dotenv import load_dotenv

# Load environment variables
load_dotenv()

# Create Google Palm LLM model
llm = GooglePalm(google_api_key=os.environ["GOOGLE_API_KEY"], temperature=0.1)

# Initialize Hugging Face embeddings
instructor_embeddings = HuggingFaceInstructEmbeddings(model_name="hkunlp/instructor-large")

# Path to save the vector database
vectordb_file_path = "faiss_index"

def create_vector_db():
    """Create the vector database from the FAQ CSV file."""
    # Load FAQ data from CSV
    loader = CSVLoader(file_path='ed-tech_faqs.csv')
    data = loader.load()

    # Create a FAISS instance for vector database
    vectordb = FAISS.from_documents(documents=data, embedding=instructor_embeddings)

    # Save the FAISS vector database locally
    vectordb.save_local(vectordb_file_path)
    print("Knowledgebase created successfully!")

def get_qa_chain():
    """Set up the Langchain Q&A chain using the vector database."""
    # Load the FAISS vector database from the local folder
    vectordb = FAISS.load_local(vectordb_file_path, instructor_embeddings)

    # Create a retriever to query the vector database
    retriever = vectordb.as_retriever(score_threshold=0.7)

    # Define a prompt template for generating answers
    prompt_template = """
    Given the following context and a question, generate an answer based on this context only.
    If the answer is not found in the context, kindly state "I don't know." Don't try to make up an answer.

    CONTEXT: {context}

    QUESTION: {question}
    """

    PROMPT = PromptTemplate(
        template=prompt_template, input_variables=["context", "question"]
    )

    # Set up the RetrievalQA chain
    chain = RetrievalQA.from_chain_type(
        llm=llm,
        chain_type="stuff",
        retriever=retriever,
        return_source_documents=True,
        chain_type_kwargs={"prompt": PROMPT}
    )

    return chain

if __name__ == "__main__":
    create_vector_db()
    chain = get_qa_chain()
    print(chain("Do you have javascript course?"))
