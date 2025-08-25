# Expense Tracker Application

A simple console-based expense tracking application built with Java and Maven. This application allows users to manage their expenses through an interactive command-line interface.

## 🚀 Features

- **Add Expenses**: Create new expenses with description and amount
- **View Expenses**: Display all current expenses in a formatted list
- **Edit Expenses**: Modify existing expense descriptions and amounts
- **Delete Expenses**: Remove expenses from the tracking list
- **Interactive Menu**: User-friendly console interface
- **Unique IDs**: Each expense gets a unique UUID identifier
- **Data Validation**: Basic input validation for amounts
- **Authentication**: Terminal-based login/sign up with BCrypt password hashing
- **Per-user data**: Each user has their own isolated list of expenses
- **Logout**: Switch accounts without restarting the app

## 🛠️ Tech Stack

- **Language**: Java 17
- **Build Tool**: Maven 3.6+
- **Dependencies**: 
  - Java Standard Library
  - BCrypt (`org.mindrot:jbcrypt:0.4`) for password hashing
  - Maven plugins for compilation and execution
- **Architecture**: Console-based application with in-memory data storage
- **Data Storage**: In-memory per-user `Map<String, List<Expense>>` (data persists only during runtime)

## 📁 Project Structure

```
ExpenseTracker/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               ├── example/
│               │   └── ExpenseTrackerApplication.java    # Main application class
│               └── expensetracker/
│                   └── model/
│                       └── Expense.java                  # Expense data model
│                   └── model/
│                       └── User.java                     # User model (username + password hash)
│                   └── service/
│                       └── AuthService.java              # Signup/Login using BCrypt
├── target/                                              # Compiled classes and JAR files
│   ├── classes/                                        # Compiled Java classes
│   └── ExpenseTracker-0.0.1-SNAPSHOT.jar              # Executable JAR file
├── pom.xml                                             # Maven configuration file
└── README.md                                           # Project documentation
```

## 🔧 Prerequisites

Before running this project, ensure you have the following installed:

### Java 17 or Higher
```bash
# Check Java version
java -version
```

**Download Java:**
- [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
- [OpenJDK](https://adoptium.net/)
- [Amazon Corretto](https://aws.amazon.com/corretto/)

### Maven 3.6 or Higher
```bash
# Check Maven version
mvn -version
```

**Download Maven:**
- [Apache Maven](https://maven.apache.org/download.cgi)

### Environment Setup (Windows)

1. **Set JAVA_HOME:**
   ```
   Variable name: JAVA_HOME
   Variable value: C:\Program Files\Java\jdk-17
   ```

2. **Set MAVEN_HOME:**
   ```
   Variable name: MAVEN_HOME
   Variable value: C:\Program Files\Apache\maven
   ```

3. **Add to PATH:**
   ```
   %JAVA_HOME%\bin
   %MAVEN_HOME%\bin
   ```

## 🚀 How to Run

### Method 1: Using Maven (Recommended)

1. **Navigate to project directory:**
   ```bash
   cd ExpenseTracker
   ```

2. **Run the application:**
   ```bash
   mvn exec:java
   ```

### Method 2: Using JAR File

1. **Build the JAR file:**
   ```bash
   mvn package
   ```

2. **Run the JAR file:**
   ```bash
   java -jar target/ExpenseTracker-0.0.1-SNAPSHOT.jar
   ```

### Method 3: Manual Compilation

1. **Compile the project:**
   ```bash
   mvn compile
   ```

2. **Run the compiled classes:**
   ```bash
   java -cp target/classes com.example.ExpenseTrackerApplication
   ```

## 📋 Configuration Commands

### Maven Commands

```bash
# Clean and compile
mvn clean compile

# Run tests (if any)
mvn test

# Package the application
mvn package

# Install to local repository
mvn install

# Clean target directory
mvn clean

# Run with exec plugin
mvn exec:java

# Show dependency tree
mvn dependency:tree
```

### Java Commands

```bash
# Check Java version
java -version

# Check Java compiler version
javac -version

# Run JAR file
java -jar target/ExpenseTracker-0.0.1-SNAPSHOT.jar

# Run with specific classpath
java -cp target/classes com.example.ExpenseTrackerApplication
```

## 🎯 How to Use the Application

### Starting the Application

1. Run one of the commands above
2. You'll see the authentication menu first:

```
Authentication Menu:
1. Login
2. Sign up
3. Exit
Choose an option:
```

### Login or Sign up

- Choose `2` to sign up (pick a unique username and password). Passwords are stored as BCrypt hashes in memory.
- Choose `1` to log in with your credentials.

### Adding an Expense

1. After login, you'll see the expense menu. Choose option `1`.
2. Enter description (e.g., "Groceries")
3. Enter amount (e.g., `50.00`)
4. Expense will be added with a unique ID

### Viewing Expenses

1. Choose option `2` (shows only the logged-in user's expenses)
2. All expenses will be displayed in format:
   ```
   1. [uuid] Description - Amount
   ```

### Editing an Expense

1. Choose option `3`
2. View the list of expenses
3. Enter the expense number to edit
4. Enter new description (or press Enter to keep current)
5. Enter new amount (or press Enter to keep current)

### Deleting an Expense

1. Choose option `4`
2. View the list of expenses
3. Enter the expense number to delete
4. Expense will be removed from the list

### Logout or Exit

1. Choose `5` to log out and return to the authentication menu
2. Choose `6` to exit the application

## 🔍 Code Structure Explanation

### Main Application Class (`ExpenseTrackerApplication.java`)

```java
// Key components:
- Scanner scanner: Handles user input
- Map<String, List<Expense>> usernameToExpenses: In-memory per-user storage
- main() method: Application entry point
- Authentication menu (login/sign up) followed by expense menu
```

**Key Methods:**
- `showAuthMenu(...)`: Handles login/sign up/exit
- `getUserExpenses()`: Returns the expense list for the current user
- `addExpense()`, `viewExpenses()`, `editExpense()`, `deleteExpense()`

### Expense Model (`Expense.java`)

```java
// Data structure:
- String id: Unique identifier (UUID)
- String description: Expense description
- Double amount: Expense amount
```

**Features:**
- Default constructor
- Parameterized constructor
- Getter and setter methods
- Simple data model

### User Model (`User.java`)

```java
// Data structure:
- String username: Unique username
- String passwordHash: BCrypt hash of the user's password
```

### Auth Service (`AuthService.java`)

```java
- signUp(username, password): Hashes password and registers a new user
- login(username, password): Verifies password against stored BCrypt hash
```

## ⚙️ Maven Configuration (`pom.xml`)

### Key Configuration Elements:

```xml
<!-- Project metadata -->
<groupId>com.example</groupId>
<artifactId>ExpenseTracker</artifactId>
<version>0.0.1-SNAPSHOT</version>

<!-- Java version -->
<maven.compiler.source>17</maven.compiler.source>
<maven.compiler.target>17</maven.compiler.target>

<!-- Plugins -->
- maven-compiler-plugin: Compiles Java code
- maven-jar-plugin: Creates executable JAR
- exec-maven-plugin: Runs the application
 
<!-- Dependencies -->
- org.mindrot:jbcrypt:0.4 for password hashing
```

## 🔧 Troubleshooting

### Common Issues and Solutions

1. **"Java not found" error:**
   ```bash
   # Check Java installation
   java -version
   # If not found, install Java 17+ and set JAVA_HOME
   ```

2. **"Maven not found" error:**
   ```bash
   # Check Maven installation
   mvn -version
   # If not found, install Maven and set MAVEN_HOME
   ```

3. **Compilation errors:**
   ```bash
   # Clean and recompile
   mvn clean compile
   ```

4. **JAR file not executable:**
   ```bash
   # Rebuild the JAR
   mvn clean package
   ```

5. **Permission denied errors:**
   ```bash
   # On Windows, run as administrator
   # On Linux/Mac, check file permissions
   ```

### Environment Issues

1. **VS Code terminal issues:**
   - Restart VS Code after setting environment variables
   - Open new terminal in VS Code

2. **Path issues:**
   - Ensure Java and Maven are in your system PATH
   - Restart terminal after changing environment variables

## 📊 Data Storage

- **Storage Type**: In-memory (ArrayList)
- **Persistence**: None (data lost on application exit)
- **Data Format**: Java objects with UUID identifiers
- **Limitations**: No database or file storage

## 🔄 Development Workflow

1. **Make changes** to Java files
2. **Compile** with `mvn compile`
3. **Test** with `mvn exec:java`
4. **Package** with `mvn package`
5. **Deploy** by distributing the JAR file

## 📝 Future Enhancements

Potential improvements for the application:

- [ ] File-based data persistence
- [ ] Database integration (SQLite, MySQL)
- [ ] Date/time tracking for expenses
- [ ] Category-based expense organization
- [ ] Export functionality (CSV, PDF)
- [ ] Budget tracking and alerts
- [ ] Web-based interface
- [ ] Mobile application

## 🤝 Contributing

To contribute to this project:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 📞 Support

If you encounter any issues:

1. Check the troubleshooting section above
2. Verify your Java and Maven installations
3. Ensure you're in the correct directory
4. Check the console output for error messages

---

**Happy Expense Tracking! 💰**
