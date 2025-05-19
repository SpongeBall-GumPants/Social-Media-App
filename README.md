## Social Media App

A Java Swing–based social media prototype demonstrating OOP principles and design patterns.

---

### Table of Contents

- [Overview](#overview)
    
- [Features](#features)
    
- [Design Patterns](#design-patterns)
    
- [Getting Started](#getting-started)
    
- [Architecture](#architecture)
    
- [Testing](#testing)
    
- [Contributing](#contributing)
    
- [License](#license)
    

---

## Overview

This is a simple in-memory social network where users can register, log in, post content to their wall, and manage friend/family/group relationships via a Swing GUI. Behind the scenes, it leverages a variety of design patterns to keep the code organized, extensible, and decoupled.

---

## Features

- **User Management:** Register, log in, and log out.
    
- **Relationships:** Create and browse Friends, Families, and Groups.
    
- **Posting:** Write, view, and iterate through posts on your own or another’s wall.
    
- **In-Memory Database:** A singleton store holds all data for the session.
    
- **Command‐Driven UI:** Buttons invoke standalone Command objects for actions.
    

---

## Design Patterns

- **Singleton** – `Database` ensures a single in-memory data store across the application.
    
- **Factory** – `Factory`, `FamilyFactory`, `GroupFactory`, etc., create domain objects based on type.
    
- **Adapter** – `AListToDLMAdapter` and `ObsToDLMAdapter` adapt between Java collections and Swing models.
    
- **Iterator** – `Aggregate`/`Iterator` interfaces with implementations like `ContentIterator`, `GroupIterator`, etc., for uniform traversal.
    
- **Command** – `Command` abstract class, `ButtonInvoker` (the invoker), and concrete commands (`LogInCommand`, `RegisterCommand`, etc.) decouple UI events from business logic.
    
- **Observer** – `Subject` and `Observer` interfaces enable view components to react to model changes (e.g., new posts).
    

---


## Getting Started

**Prerequisites:**

- Java SE 11+
    
- An IDE or editor (e.g., IntelliJ IDEA, Eclipse)
    

**Build & Run:**
`# From the project root: javac src/*.java java -cp src Main`

> The application opens a Swing login window; follow on-screen prompts to explore posting and relationships.

---

## Architecture

1. **Entry Point (`Main.java`):** Initializes the `LoginPage` via a `LogInCommand`.
    
2. **Data Layer:**
    
    - `Database` (Singleton) holds lists of `User`, `Group`, `Family`, and `Post` objects [GitHub](https://github.com/SpongeBall-GumPants/Social-Media-App/commit/0fe8e87c346afe7b022e64793610f54474f13220).
        
    - CRUD operations and searches use the **Iterator** pattern for uniform traversal.
        
3. **Business Logic:**
    
    - Factories generate new domain objects without exposing constructors directly.
        
    - The **Command** pattern centralizes user-triggered actions, each command receiving a `Receiver` to perform its task.
        
    - The **Observer** pattern lets UI components subscribe to model changes (e.g., when a new post is added).
        
4. **Presentation Layer:**
    
    - Basic Swing forms (.form + corresponding .java) handle user input.
        
    - **Adapters** translate between Swing models (e.g., `DefaultListModel`) and the app’s internal `ArrayList` structures.
        

---

## Testing

JUnit tests cover core functionality:

- **`DatabaseTest.java`** – CRUD and search operations in the Singleton store.
    
- **`UserTest.java`** – User authentication and profile logic.
    
- **`ReceiverTest.java`** – Ensures Command receivers execute correctly. [GitHub](https://github.com/SpongeBall-GumPants/Social-Media-App/commit/0fe8e87c346afe7b022e64793610f54474f13220)
    

Run tests with your IDE’s JUnit runner or via command line:

`# Example using junit-platform-console (configured separately) java -jar junit-platform-console-standalone.jar \   --class-path src:tests \   --scan-class-path`

---

## Contributing

1. Fork the repo
    
2. Create a feature branch (`git checkout -b feature/MyFeature`)
    
3. Commit your changes with clear messages
    
4. Open a pull request for review
    

Please adhere to the existing code style and add tests for new functionality.

---

## License

This project is released under the **MIT License**. Feel free to use and modify it as you see fit.
