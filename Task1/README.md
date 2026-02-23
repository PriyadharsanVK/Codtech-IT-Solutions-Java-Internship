# File Handling Utility (Java)

A **menu-driven File Handling Utility** developed in **Java** that demonstrates core file operations such as reading, writing, modifying, and deleting text files.

This project was created as part of a **Java Programming Internship Task** to demonstrate practical knowledge of Java File Handling and clean code structure.

---

## Features

* Automatic file creation if the file does not exist
* Write text into a file
* Read text from a file
* Modify file content (Append mode)
* Delete file option
* Menu-driven console interface
* Exception handling
* Uses **BufferedReader** and **BufferedWriter**
* Uses **try-with-resources** for automatic file closing

---

## Technologies Used

* Java
* File Handling API
* BufferedReader
* BufferedWriter
* FileReader
* FileWriter
* Scanner
* Try-With-Resources

---

## Project Structure

```
Codetech IT Solutions Java Internship/
│
├── Task1/
│   ├── src/
│   │   ├── Main.java
│   │   ├── WriteFile.java
│   │   ├── ReadFile.java
│   │   └── ModifyFile.java
│   │
│   ├── Notepad.txt
│   ├── .gitignore
│   └── Task1.iml
│
├── LICENSE.txt
```

---

## File Description

### Main.java

* Contains the main program
* Displays menu options
* Takes user input
* Controls file operations

### WriteFile.java

* Writes text into the file
* Overwrites existing content
* Uses BufferedWriter

### ReadFile.java

* Reads file content
* Displays text in console
* Uses BufferedReader

### ModifyFile.java

* Appends text into the file
* Uses BufferedWriter in append mode

### Notepad.txt

* Sample text file used for file operations

---

## How to Run the Program

### Step 1: Navigate to src folder

```
cd Task1/src
```

### Step 2: Compile

```
javac Main.java WriteFile.java ReadFile.java ModifyFile.java
```

### Step 3: Run

```
java Main
```

---

## Program Menu

```
****** File Handling Utility ******

1. Write to File
2. Read File
3. Modify a File
4. Delete File
5. Exit
```

---

## Example Execution

```
File Created : Notepad.txt

****** File Handling Utility ******

1.Write to File
2.Read File
3.Modify a File
4.Delete File
5.Exit

Enter your Choice : 1

Enter the Text to Write in the File :
Hello World

File Written Successfully
```

---

## Concepts Demonstrated

* Java File Handling
* Object-Oriented Programming
* Exception Handling
* Try-With-Resources
* Buffered Streams
* User Input Handling
* Menu Driven Programs

---

## Learning Outcomes

* Understanding file operations in Java
* Writing modular Java programs
* Handling runtime exceptions
* Working with buffered streams
* Designing structured programs

---

## Internship Task

**Task:** File Handling Utility
**Objective:** Create a Java program to read, write, and modify text files with clear documentation.

---

## Future Improvements

Possible enhancements:

* Replace text in file
* Search text in file
* Support multiple files
* GUI version
* Logging support

---

## Author

**Priyadharsan V K**

Java Developer | Backend Enthusiast

---

## License

This project is for educational and internship purposes.
