# Import necessary libraries
import streamlit as st
from langchain_helper import get_few_shot_db_chain

# Streamlit App Title
st.title("Global T-Shirts: Database Q&A 🧥")

# Input field for user question
question = st.text_input("Ask your question:")

# Process the question and return the answer
if question:
    chain = get_few_shot_db_chain()  # Get the Langchain chain
    response = chain.run(question)   # Run the chain with the question

    # Display the answer
    st.header("Answer")
    st.write(response)
