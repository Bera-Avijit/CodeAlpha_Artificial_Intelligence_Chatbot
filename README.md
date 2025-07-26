# Infino: AI Chatbot Web Application

> **Infino** is a next-generation AI chatbot that delivers seamless, context-aware conversations by integrating Google’s Gemini API into a modern React interface backed by a Spring Boot server. Whether you’re seeking information, companionship, or a developer-friendly template for AI integration, Infino offers a versatile and customizable foundation for chat-driven applications.

---

## 📌 Key Features & Capabilities

- 🤖 **AI-Powered Dialogue**  
  Infino leverages the Gemini API to generate dynamic, contextually relevant bot responses. Every user input is sent securely to the backend where the prompt is constructed, enriched with session history, and dispatched to Gemini for intelligent output.

- 🌗 **Adaptive Themes**  
  Easily switch between Dark Mode and Light Mode to suit your preferences or environmental lighting. The theme choice persists across sessions to ensure a consistent user experience.

- 💬 **Session-Based Chat Management**  
  - Create, rename, and navigate multiple chat sessions via a sidebar menu.  
  - Each session is identified by a unique Session ID, preserving message context and allowing users to revisit past conversations.

- 🗑️ **Granular Message Deletion**  
  Delete individual messages or entire sessions directly from the UI. Users can prune unnecessary or sensitive data on demand, enhancing privacy and control.

- 🔄 **Real-Time Interaction**  
  Send messages and receive bot replies in real time without page reloads. Automatic scrolling keeps the latest messages in view, while a loader icon indicates processing status.

- 📦 **Markdown & Rich Content**  
  Supports Markdown formatting in bot responses, enabling code snippets, links, lists, and more for a richer conversational experience.

- 🔒 **Security & Configuration**  
  - All API keys and sensitive settings are stored in configuration files, with no hard-coded secrets.  
  - CORS is configured to restrict access to authorized origins, maintaining backend integrity.

---

## 🛠️ Technology Stack

| Layer       | Technologies & Libraries                                    |
| ----------- | ----------------------------------------------------------- |
| **Backend** | Java 17, Spring Boot, Spring Web MVC, Maven                 |
| **API**     | RESTful endpoints, Axios                                    |
| **AI**      | Google Gemini API                                           |
| **Frontend**| React (Vite), React-Bootstrap, Bootstrap 5, HTML/CSS/JS     |
| **Storage** | In-memory repository (extendable to PostgreSQL, MongoDB)    |

---
