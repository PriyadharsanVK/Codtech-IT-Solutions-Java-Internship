<h1 align="center">🌐 REST API Client — Java Application</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-11%2B-orange?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-Build%20Tool-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
  <img src="https://img.shields.io/badge/Gson-2.10.1-4285F4?style=for-the-badge&logo=google&logoColor=white"/>
  <img src="https://img.shields.io/badge/API-JSONPlaceholder-brightgreen?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Internship-Task%202-blueviolet?style=for-the-badge"/>
</p>

<p align="center">
  A Java console application that consumes a public REST API, parses JSON responses, <br/>
  and displays structured user data with search, filter, and file export features.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Status-Complete-success?style=flat-square"/>
  <img src="https://img.shields.io/badge/License-MIT-blue?style=flat-square"/>
  <img src="https://img.shields.io/badge/Platform-Windows%20%7C%20Mac%20%7C%20Linux-lightgrey?style=flat-square"/>
</p>

---

## 📋 Table of Contents

- [About the Project](#-about-the-project)
- [Features](#-features)
- [Project Structure](#-project-structure)
- [Technologies Used](#-technologies-used)
- [Prerequisites](#-prerequisites)
- [How to Run](#-how-to-run)
- [Menu Options](#-menu-options)
- [Sample Output](#-sample-output)
- [Output Files](#-output-files)
- [API Reference](#-api-reference)
- [Error Handling](#-error-handling)
- [Author](#-author)

---

## 📌 About the Project

This project was built as **Internship Task 2 — REST API Client in Java**.

The application connects to [JSONPlaceholder](https://jsonplaceholder.typicode.com/users),
a free public REST API, fetches 10 user records in JSON format, parses the response
using the **Gson** library, and presents the data through an interactive console menu.

Users can search by name, filter by city, display all records, and export data
to both `.txt` and `.json` files — all from a clean, color-coded, menu-driven interface.

---

## ✨ Features

| Feature | Description |
|---|---|
| 📡 **Live API Fetch** | Connects to a real REST API using `HttpURLConnection` |
| 🔍 **Search by Name** | Filter users by partial or full name |
| 🏙️ **Filter by City** | Filter users by city name |
| 📄 **Save to TXT** | Export all data to a timestamped `.txt` file |
| 🗂️ **Save to JSON** | Export all data to a pretty-printed `.json` file |
| 🎨 **Colored Console** | Color-coded output using ANSI escape codes |
| ⚠️ **Error Handling** | Handles network failures, timeouts, and bad responses |
| 📋 **Interactive Menu** | Simple numbered menu for easy navigation |

---

## 📁 Project Structure

```
RestApiClient/
│
├── src/
│   └── main/
│       └── java/
│           ├── Main.java          ← Main app: HTTP request, menu, display, file saving
│           └── User.java          ← Model class: maps JSON fields to Java object
│
├── pom.xml                        ← Maven config with Gson dependency
├── README.md                      ← Project documentation (you are here)
│
└── (generated at runtime)
    ├── users_<timestamp>.txt      ← TXT export file
    └── users_<timestamp>.json     ← JSON export file
```

---

## 🛠️ Technologies Used

| Technology | Purpose | Version |
|---|---|---|
| **Java** | Core programming language | 11+ |
| **Maven** | Dependency & build management | 3.x |
| **Gson** | JSON parsing library by Google | 2.10.1 |
| **HttpURLConnection** | Java built-in HTTP client | Built-in |
| **JSONPlaceholder** | Free public REST API for testing | — |

---

## ✅ Prerequisites

Before running this project, make sure you have the following installed:

- ☑️ **Java JDK 11 or higher** → [Download JDK](https://www.oracle.com/java/technologies/downloads/)
- ☑️ **IntelliJ IDEA** (recommended IDE) → [Download IntelliJ](https://www.jetbrains.com/idea/)
- ☑️ **Maven** (bundled with IntelliJ — no separate install needed)
- ☑️ **Active internet connection** (required to fetch API data)

---

## 🚀 How to Run

### ▶️ Option 1 — Run in IntelliJ IDEA (Recommended)

```
1. Clone or download this repository
2. Open IntelliJ IDEA
3. Click  File → Open → Select the project folder
4. Wait for Maven to load dependencies (pom.xml is auto-detected)
5. Open  src/main/java/Main.java
6. Right-click → Run 'Main.main()'
7. Interact with the console menu
```

### ▶️ Option 2 — Run via Terminal / Command Line

```bash
# Step 1: Clone the repository
git clone https://github.com/PriyadharsanVK/RestApiClient.git

# Step 2: Navigate into the project
cd RestApiClient

# Step 3: Build with Maven
mvn compile

# Step 4: Run the application
mvn exec:java -Dexec.mainClass="Main"
```

### ▶️ Option 3 — Run as a JAR file

```bash
# Package the project
mvn package

# Run the JAR
java -jar target/RestApiClient-1.0-SNAPSHOT.jar
```

---

## 📂 Menu Options

Once the app starts and successfully connects to the API, you'll see this menu:

```
┌─────────────── MENU ───────────────┐
│  1. Display All Users               │
│  2. Search by Name                  │
│  3. Filter by City                  │
│  4. Save to TXT File                │
│  5. Save to JSON File               │
│  6. Exit                            │
└─────────────────────────────────────┘
```

| Option | Action |
|---|---|
| **1** | Displays all 10 users fetched from the API in a structured format |
| **2** | Prompts for a name keyword — shows all matching users |
| **3** | Prompts for a city keyword — shows all users from that city |
| **4** | Saves all user data to a timestamped `.txt` file |
| **5** | Saves all user data to a pretty-printed `.json` file |
| **6** | Exits the application cleanly |

---

## 🖥️ Sample Output

**On startup:**
```
╔══════════════════════════════════════════╗
║        REST API CLIENT - JAVA APP        ║
║     Internship Task 2 | JSONPlaceholder  ║
╚══════════════════════════════════════════╝

Connecting to API...
Response Code: 200
✔ Successfully fetched 10 users!
```

**Displaying users (Option 1):**
```
══════════════════════════════════════════
           USER DATA FROM API             
══════════════════════════════════════════
  ID      : 1
  Name    : Leanne Graham
  Email   : Sincere@april.biz
  Phone   : 1-770-736-8031 x56442
  City    : Gwenborough
  Website : hildegard.org
  ──────────────────────────────────────
  ID      : 2
  Name    : Ervin Howell
  Email   : Shanna@melissa.tv
  Phone   : 010-692-6593 x09125
  City    : Wisokyburgh
  Website : anastasia.net
  ──────────────────────────────────────

  Total records: 10
```

**Searching by name (Option 2):**
```
Enter name to search: Clem

  ID      : 3
  Name    : Clementine Bauch
  Email   : Nathan@yesenia.net
  ...
```

**Saving to file (Option 4 or 5):**
```
✔ Data saved to: users_2024-06-15_10-30-45.txt
  (Check your project root folder)
```

---

## 📤 Output Files

When you choose **Save to TXT (4)** or **Save to JSON (5)**, files are saved in the
**project root folder** with a timestamp in the filename:

```
users_2024-06-15_10-30-45.txt
users_2024-06-15_10-30-45.json
```

**Sample `.txt` output:**
```
========================================
        REST API CLIENT - USER DATA     
  Generated: 2024-06-15_10-30-45
========================================

ID      : 1
Name    : Leanne Graham
Email   : Sincere@april.biz
Phone   : 1-770-736-8031 x56442
City    : Gwenborough
Website : hildegard.org
----------------------------------------

Total Records: 10
```

**Sample `.json` output:**
```json
[
  {
    "id": 1,
    "name": "Leanne Graham",
    "email": "Sincere@april.biz",
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "address": {
      "city": "Gwenborough"
    }
  },
  {
    "id": 2,
    "name": "Ervin Howell",
    "email": "Shanna@melissa.tv",
    "phone": "010-692-6593 x09125",
    "website": "anastasia.net",
    "address": {
      "city": "Wisokyburgh"
    }
  }
]
```

---

## 📡 API Reference

| Property | Value |
|---|---|
| **API Name** | JSONPlaceholder |
| **Base URL** | `https://jsonplaceholder.typicode.com` |
| **Endpoint Used** | `/users` |
| **Full URL** | `https://jsonplaceholder.typicode.com/users` |
| **HTTP Method** | `GET` |
| **Authentication** | Not required |
| **Response Format** | JSON Array |
| **Records Returned** | 10 user objects |

**JSON fields used from the API response:**

```json
{
  "id": 1,
  "name": "Leanne Graham",
  "email": "Sincere@april.biz",
  "phone": "1-770-736-8031",
  "website": "hildegard.org",
  "address": {
    "city": "Gwenborough"
  }
}
```

---

## ⚠️ Error Handling

The application gracefully handles the following error scenarios:

| Scenario | How It's Handled |
|---|---|
| No internet connection | Exception caught, descriptive error message shown |
| API returns non-200 status | Status code checked, error reported to user |
| Connection timeout | 5-second timeout set on both connect and read |
| File write failure | `IOException` caught, error message displayed |
| Invalid menu input | "Invalid choice" shown, menu re-displayed |
| Empty search results | "No users found" message shown with the search term |

---

## 👨‍💻 Author

- PRIYADHARSAN V K
- 🏢 Internship Task 2 — REST API Client in Java
- 🌐 GitHub: [@PriyadharsanVK](https://github.com/PriyadharsanVK)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

<p align="center">Built with ❤️ using Java & Gson | Internship Task 2</p>