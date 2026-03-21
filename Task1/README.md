# 🗂️ File Handling Utility — Java

> A clean, modular, and well-structured console application that demonstrates **professional-grade Java File I/O operations** through a user-friendly menu-driven interface.

---

## 📌 Overview

The **File Handling Utility** is a Java-based console application built to showcase the practical application of Java's File Handling API. Designed with simplicity, modularity, and clean code principles in mind, this project demonstrates how real-world file operations — creation, reading, writing, modification, and deletion — can be implemented in a structured and maintainable manner.

This project was developed as part of the **Codetech IT Solutions Java Programming Internship (Task 1)**, representing a hands-on approach to understanding file I/O in Java.

---

## ✨ Features

| Feature | Description |
|---|---|
| 📄 Auto File Creation | Automatically creates the file if it doesn't already exist |
| ✏️ Write to File | Overwrites file with new user-provided content |
| 📖 Read from File | Displays file content directly on the console |
| 🔄 Modify / Append | Appends new content to the existing file |
| 🗑️ Delete File | Safely removes the file from the filesystem |
| 🧭 Menu-Driven UI | Intuitive numbered menu for effortless navigation |
| 🛡️ Exception Handling | Graceful error handling for all file operations |
| ⚙️ Buffered Streams | Uses `BufferedReader` & `BufferedWriter` for efficient I/O |
| 🔒 Try-With-Resources | Ensures automatic and safe resource management |

---

## 🛠️ Technologies & Concepts

- **Language:** Java (SE)
- **I/O APIs:** `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`
- **Input Handling:** `Scanner`
- **Resource Management:** Try-With-Resources
- **Design Pattern:** Object-Oriented Programming (OOP), Modular Architecture

---

## 📁 Project Structure

```
Codetech IT Solutions Java Internship/
│
├── Task1/
│   ├── src/
│   │   ├── Main.java          # Entry point — menu logic & user interaction
│   │   ├── WriteFile.java     # Handles file write operations (overwrite mode)
│   │   ├── ReadFile.java      # Handles file read and display operations
│   │   └── ModifyFile.java    # Handles file append operations
│   │
│   ├── Notepad.txt            # Target text file for all operations
│   ├── .gitignore
│   └── Task1.iml
│
├── LICENSE.txt
└── README.md
```

---

## 📂 Module Breakdown

### `Main.java`
The central controller of the application. Displays the menu, accepts user input, and delegates operations to the appropriate handler classes. Keeps the program flow clean and easy to follow.

### `WriteFile.java`
Handles writing operations using `BufferedWriter`. Overwrites any existing file content with newly provided input — ideal for fresh writes.

### `ReadFile.java`
Handles reading operations using `BufferedReader`. Iterates through each line and prints it to the console, making file content immediately accessible.

### `ModifyFile.java`
Handles append operations by opening the file in append mode using `BufferedWriter`. Preserves existing content while adding new data at the end.

### `Notepad.txt`
The default target file for all read/write/modify/delete operations — created automatically at runtime if not present.

---

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or above
- A terminal / command prompt

### Step 1 — Navigate to the source directory
```bash
cd Task1/src
```

### Step 2 — Compile the source files
```bash
javac Main.java WriteFile.java ReadFile.java ModifyFile.java
```

### Step 3 — Run the application
```bash
java Main
```

---

## 🖥️ Application Menu

```
****** File Handling Utility ******

1. Write to File
2. Read File
3. Modify a File
4. Delete File
5. Exit
```

---

## 📋 Sample Execution

```
File Created : Notepad.txt

****** File Handling Utility ******

1. Write to File
2. Read File
3. Modify a File
4. Delete File
5. Exit

Enter your Choice : 1

Enter the Text to Write in the File :
Hello, World!

File Written Successfully.
```

---

## 🧠 Key Concepts Demonstrated

- **Java File Handling** — Practical usage of core Java I/O classes
- **Object-Oriented Design** — Separate classes for each responsibility
- **Exception Handling** — Robust try-catch blocks prevent crashes
- **Try-With-Resources** — Clean, leak-free resource management
- **Buffered I/O Streams** — Efficient reading and writing via buffering
- **User Input Handling** — `Scanner`-based interactive console input
- **Menu-Driven Architecture** — Structured, scalable program flow

---

## 📈 Learning Outcomes

Through building this project, the following skills were developed and strengthened:

- Implementing file read, write, and append operations in Java
- Designing modular programs with well-separated concerns
- Managing runtime exceptions to ensure program stability
- Understanding the performance benefits of buffered I/O streams
- Writing clean, maintainable, and well-documented Java code

---

## 🔮 Future Enhancements

This project has a solid foundation with room to grow:

- [ ] **Find & Replace** — Search for specific text and replace it in-place
- [ ] **Text Search** — Keyword-based search within file content
- [ ] **Multi-File Support** — Manage and switch between multiple files
- [ ] **GUI Interface** — JavaFX or Swing-based graphical interface
- [ ] **Logging System** — Track all file operations with timestamps
- [ ] **File Encryption** — Basic read/write with encrypted storage

---

## 👨‍💻 Author

**Priyadharsan V K**
Java Developer | Backend Enthusiast

> *"This project reflects not just a technical exercise, but a commitment to writing clean, purposeful, and professional code from day one."*

---

## 📜 License

This project was developed for **educational and internship purposes** under the Codetech IT Solutions Java Internship Program.

---

> ⭐ *If you found this project helpful or insightful, consider giving it a star — it goes a long way!*