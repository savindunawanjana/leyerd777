# Gym Management System

A robust, enterprise-grade **Gym Management System** built using **Java SE** and structured following the strict principles of **Layered Architecture**. This system handles day-to-day gym operations including member registration, staff management, payment tracking, and workout scheduling.

---

## 🛠️ Tech Stack & Patterns
* **Language:** Java SE (JDK 11 or higher)
* **Database:** MySQL
* **Architecture:** Layered Architecture (Separation of Concerns)
* **Design Patterns:** DAO (Data Access Object) Pattern, Singleton Pattern (for Database Connection), Factory Pattern

---

## 🏛️ Architectural Overview

This project is built using **Layered Architecture** to achieve high maintainability, scalability, and loose coupling. The system is split into distinct layers where each layer has a single responsibility:

* **UI / Controller Layer:** Manages user interactions, captures inputs, and triggers corresponding actions.
* **BO (Business Object) Layer:** The core brain of the system. It contains all business logic and rules, acting as a secure bridge between the UI and the data tier.
* **DAO (Data Access Object) Layer:** Handles direct communication with the MySQL database. It encapsulates raw SQL queries (`INSERT`, `UPDATE`, `DELETE`, `SELECT`).
* **DTO (Data Transfer Object) & Entity:** * **DTOs** transport data securely between the UI and BO layers.
  * **Entities** represent the database tables and map directly to the database rows.

---

## 📂 Project Directory Structure

Below is the directory tree mapping out the structure of the `demo76promax` package as seen in the source files:

```text
edu.lk.ijse.projectgym.demo76promax
│
├── AppInitialaiser.java       # Main Entry Point of the Application
│
├── bo                         # Business Object Layer (Interfaces & Implementations)
│   ├── Custom                 
│   │   ├── impl               # Concrete Business Logic Implementations
│   │   │   ├── CleanerDeleteBOImpl.java
│   │   │   ├── CleanerSaveBOImpl.java
│   │   │   ├── CustomerManageBOImpl.java
│   │   │   └── [Other BO Implementations...]
│   │   └── [BO Custom Interfaces]
│   └── SuperBO.java
│
├── Controller                 # Handles GUI Events & Directs Input
├── dao                        # Data Access Object Layer (CRUD Operations)
├── Dbconnection               # Handles MySQL Database Connectivity (Singleton)
├── Dtos                       # Data Transfer Objects (Data Holders)
├── entity                     # Database Relational Entities
├── Modal                      # Core Data Models
└── Util                       # Utilities, Constants, and Common Helpers




