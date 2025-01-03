# GenAl Capst - Ed-Tech Q&A System

This project is an AI-powered question-answering system built using Langchain and Gemini for an e-learning platform. It helps students get answers to FAQs in real-time, reducing the workload on instructors.

## Installation
1. Install dependencies: `pip install -r requirements.txt`
2. Acquire a Google API key and set it in the `.env` file.

## Usage
1. Run the Streamlit app: `streamlit run main.py`
2. The app will open in your browser. Click on "Create Knowledgebase" to initialize the FAQ data.

## Files
- `main.py`: Streamlit app for the user interface.
- `langchain_helper.py`: Helper functions to manage the knowledge base and Langchain pipeline.
- `ed-tech_faqs.csv`: Data file containing FAQ questions and answers.
- `.env`: Environment file to store sensitive API keys.

## Bonus Features (Optional)
Feel free to extend the functionality of this project to make it more robust, secure, and capable of handling advanced use cases such as:
- Authentication for users (students/instructors)
- Real-time updates to the knowledge base
- Advanced NLP models for improved response accuracy
