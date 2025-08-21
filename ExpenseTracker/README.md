# Expense Tracker

A beginner-friendly Expense Tracking management system using Java, Spring Boot, MongoDB, and Thymeleaf.

## Features

- Add Expense
- Edit Expense
- Delete Expense
- View Expenses

## Technologies Used

- Java 17
- Spring Boot
- MongoDB (cloud)
- Thymeleaf (for UI)
- Maven (for build and dependency management)

## Prerequisites

Before you start, make sure you have the following installed:

1. **Java 17 or newer**
   - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [AdoptOpenJDK](https://adoptium.net/).
   - After installation, verify with:
     ```
     java -version
     ```

2. **Maven**
   - Download from [Maven official site](https://maven.apache.org/download.cgi).
   - After installation, verify with:
     ```
     mvn -version
     ```

3. **Git** (optional, for cloning the project)
   - Download from [Git official site](https://git-scm.com/downloads).

## How to Configure Maven After Downloading

1. **Extract the Maven zip file**  
   - Download the "Binary zip archive" from the Maven website.
   - Extract it to a folder, for example: `C:\Program Files\Apache\Maven`.

2. **Set the Environment Variables**
   - Open System Properties → Advanced → Environment Variables.
   - Under "System variables", click "New" and add:
     - Variable name: `MAVEN_HOME`
     - Variable value: Path to your Maven folder (e.g., `C:\Program Files\Apache\Maven\apache-maven-3.x.x`)
   - Find the `Path` variable, click "Edit", and add:
     - `C:\Program Files\Apache\Maven\apache-maven-3.x.x\bin`

3. **Verify Installation**
   - Open a new command prompt and run:
     ```
     mvn -version
     ```
   - You should see Maven version information.

## How to Run

1. Open a terminal (VS Code terminal, Command Prompt, or PowerShell).
2. Navigate to your project directory:
   ```
   cd C:\Users\Lenovo\Desktop\ExpenseTracker
   ```
3. Run the Spring Boot application using Maven:
   ```
   mvn spring-boot:run
   ```
4. Open your browser and go to:
   ```
   http://localhost:8080/expenses
   ```
   You will see the Expense Tracker UI.

## Running Maven in VS Code

If you see `mvn: command not found` in VS Code terminal but it works in your desktop command prompt, it means VS Code is not using the correct environment variables.

**How to fix:**
1. Close all VS Code windows.
2. Restart your computer (this reloads environment variables for all apps).
3. Open VS Code again and use a new terminal.
4. Run:
   ```
   mvn -version
   ```
   You should now see Maven version info.

If it still doesn't work, check that your `Path` variable includes the Maven `bin` folder and that you are opening a new terminal in VS Code after setting environment variables.

**Tip:** Always open a new VS Code terminal after changing environment variables.

To run your project in VS Code terminal:
```
mvn spring-boot:run
```

## Where to Run `mvn spring-boot:run`

You can run the `mvn spring-boot:run` command in:

- **VS Code Terminal:**  
  Open VS Code, go to the menu `Terminal` → `New Terminal`, make sure you are in your project folder, then run:
  ```
  mvn spring-boot:run
  ```

- **Windows Command Prompt:**  
  Open Command Prompt, navigate to your project folder, then run:
  ```
  mvn spring-boot:run
  ```

- **Windows PowerShell:**  
  Open PowerShell, navigate to your project folder, then run:
  ```
  mvn spring-boot:run
  ```

Just make sure Maven is configured and recognized in the terminal you use.

## Project Structure

- `src/main/java` - Java source code
- `src/main/resources/templates` - Thymeleaf HTML templates (UI)
- `src/main/resources/application.properties` - Database and app configuration
- `pom.xml` - Maven dependencies and build configuration

## Troubleshooting

- If you get a "Java not found" error, check your Java installation and environment variables.
- If you get a "Maven not found" error, check your Maven installation and environment variables.
- If the app doesn't start, check for error messages in the terminal and ensure your internet connection is active (for MongoDB cloud).
- If you see a "Whitelabel Error Page" with "404 Not Found" when opening [http://localhost:8080](http://localhost:8080), it means there is no default page mapped at `/`.
- To view your expenses, go to [http://localhost:8080/expenses](http://localhost:8080/expenses).
- If you still see the error at `/expenses`, check that your controller and templates are set up correctly:
  - Make sure `ExpenseController` is annotated with `@Controller` and mapped to `/expenses`.
  - Make sure you have a template named `expenses.html` in `src/main/resources/templates`.

## Useful Links

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
- [Maven Documentation](https://maven.apache.org/guides/index.html)

---

**Enjoy tracking your expenses!**
  - Make sure you have a template named `expenses.html` in `src/main/resources/templates`.

## Useful Links

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
- [Maven Documentation](https://maven.apache.org/guides/index.html)

---

**Enjoy tracking your expenses!**
