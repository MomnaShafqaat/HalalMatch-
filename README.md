# HalalMatch

## Overview
HalalMatch is a Java-based desktop application developed as a second-semester Object-Oriented Programming (OOP) project. It is designed as a matchmaking platform that allows users to create and manage profiles, search for matches, and exchange information. The project demonstrates the application of OOP principles such as inheritance, polymorphism, and encapsulation.

## Features
- User registration and login system  
- Profile creation with personal and preference details  
- Search and filter functionality for finding matches  
- File-based data storage using text files (no external database)  
- CRUD operations for profiles  
- Simple JavaFX-based user interface  

## Tech Stack
- *Frontend:* JavaFX  
- *Backend:* Core Java (OOP concepts)  
- *Database:* File handling (text-based storage)  
- *IDE:* IntelliJ IDEA / NetBeans  

## Architecture
The project follows a modular structure separating GUI, logic, and data management.  

- *GUI Layer:* JavaFX scenes for user interface  
- *Logic Layer:* Java classes implementing matchmaking and validation logic  
- *Data Layer:* File reading and writing for persistent storage  

## Folder Structure

HalalMatch/
│
├── src/
│   ├── controllers/       # JavaFX controllers for each scene
│   ├── models/            # Core classes (User, Match, etc.)
│   ├── utils/             # File handling, validation helpers
│   └── Main.java          # Application entry point
│
├── data/
│   └── users.txt          # Stores user information
│
├── resources/
│   └── fxml/              # JavaFX UI files
│
└── README.md


## OOP Concepts Applied
- *Encapsulation:* Private fields with getters and setters  
- *Inheritance:* Shared functionality among different user types  
- *Polymorphism:* Overridden methods for dynamic matchmaking  
- *Abstraction:* Interface-driven design for data and logic separation  

## Future Enhancements
- Migrate from file-based storage to a database (MySQL or MongoDB)  
- Implement chat functionality between users  
- Add profile image uploads  

## Team Members
- Momna Shafqaat  
- [Add teammate names if applicable]  

## Course Information
- *Course:* Object-Oriented Programming (OOP)  
- *Institution:* COMSATS University Lahore  
- *Semester:* 2nd Semester  
- *Year:* 2023
