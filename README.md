# School Library Management System

A desktop library management application built with **Java Swing**, developed as a Computer Science & Engineering project at Jyothi Engineering College. It lets a librarian manage books and members and keep track of borrowing and returning.

## Features

- **Dashboard:** live counts of total books, total members, available books and total transactions
- **Books:** view the catalogue, add new books, borrow a book, return a book
- **Members:** view all members and add new ones (Student, Faculty or Staff)
- **Transactions:** a full history of every borrow and return, with date
- **Validation:** checks for empty fields, unknown book or member IDs, books that are already borrowed, and returns of books that were never borrowed

## Tech Stack

- Java (core language, OOP)
- Java Swing (GUI)
- Java Collections Framework (`ArrayList` for in-memory storage)
- Java Time API (`LocalDate`)

No external libraries are needed.

## Project Structure

```
SchoolLibrary/
├── src/
│   ├── Book.java                    # Book entity (ID, title, author, category, status)
│   ├── Member.java                  # Member entity (ID, name, email, role)
│   ├── Transaction.java             # Borrow/return record (ID, book, member, type, date)
│   └── LibraryManagementSystem.java # Main window and application logic
├── .gitignore
└── README.md
```

## Getting Started

### Requirements

- JDK 8 or newer ([download here](https://adoptium.net/))

To check that Java is installed, run:

```
javac -version
```

### Run the project

```bash
git clone https://github.com/Arun5916/schoolLibrary.git
cd schoolLibrary/src
javac *.java
java LibraryManagementSystem
```

The application window opens with sample books and members already loaded.

## How to Use

1. **Borrow a book:** open the **Books** tab, click **Borrow Book**, then enter a Book ID (for example `B001`) and a Member ID (for example `M001`).
2. **Return a book:** click **Return Book** and enter the Book ID.
3. **Add a book or member:** use the **Add Book** or **Add Member** buttons on their tabs.
4. **Check history:** open the **Transactions** tab.

## Screenshots

<!-- Add a screenshot of the app here, for example:
![Dashboard](screenshots/dashboard.png) -->

## Limitations

- Data is stored in memory only, so everything resets when the application is closed.
- There are no due dates, fines or overdue tracking yet.
- Books and members cannot be edited or deleted after they are added.

## Future Improvements

- Save data permanently using a database (JDBC with MySQL or SQLite) or files
- Due dates and overdue book detection
- Search and filter for books and members
- Edit and delete options
- Prevent duplicate book and member IDs

## Group Members

- Arshad Mohammad B
- Arungopal R
- Adithyan KM

## License

This project was created for educational purposes.