import streamlit as st
from langchain_helper import get_qa_chain, create_vector_db

# Streamlit app title
st.title("Ed-Tech Q&A")

# Button to create the knowledge base
btn = st.button("Create Knowledgebase")
if btn:
    with st.spinner("Creating Knowledgebase..."):
        create_vector_db()
    st.success("Knowledgebase created successfully!")

# Text input for user query
question = st.text_input("Ask a question:")

if question:
    chain = get_qa_chain()
    try:
        response = chain(question)
        st.header("Answer")
        st.write(response.get("result", "I don't know."))
    except Exception as e:
        st.write(f"Sorry, I couldn't find an answer to your question. Error: {e}")
