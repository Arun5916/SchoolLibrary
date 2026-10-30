<div align="center">



<img src="https://capsule-render.vercel.app/api?type=waving\&color=gradient\&customColorList=6,11,20\&height=200\&section=header\&text=School%20Library\&fontSize=52\&fontColor=ffffff\&animation=fadeIn\&fontAlignY=36\&desc=Management%20System\&descAlignY=58\&descSize=22" alt="School Library header"/>



<a href="https://git.io/typing-svg">

&#x20; <img src="https://readme-typing-svg.demolab.com?font=Fira+Code\&weight=600\&size=20\&pause=1000\&color=2E86C1\&center=true\&vCenter=true\&width=600\&lines=Built+with+Java+Swing;Manage+Books+%26+Members;Track+Every+Borrow+and+Return;Live+Dashboard+Statistics" alt="Typing animation"/>

</a>



<br/>



!\[Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)

!\[Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue?style=for-the-badge)

!\[Storage](https://img.shields.io/badge/Storage-In--Memory-lightgrey?style=for-the-badge)

!\[Status](https://img.shields.io/badge/Status-Working%20Prototype-brightgreen?style=for-the-badge)

!\[College](https://img.shields.io/badge/Jyothi%20Engineering%20College-CSE-red?style=for-the-badge)



</div>



\---



\## 📖 About



A desktop library management application built with \*\*Java Swing\*\* as a Computer Science \& Engineering project at \*\*Jyothi Engineering College\*\*. It helps a librarian manage books and members and keep a record of every borrow and return.



\---



\## ✨ Features



| Tab | What you can do |

|---|---|

| 📊 \*\*Dashboard\*\* | See total books, total members, available books and total transactions, updated live |

| 📚 \*\*Books\*\* | View the catalogue, add books, borrow a book, return a book |

| 👥 \*\*Members\*\* | View all members, add new members (Student, Faculty or Staff) |

| 🔁 \*\*Transactions\*\* | Full history of every borrow and return with its date |



\*\*Built-in checks:\*\*



\- ✅ Empty fields are rejected

\- ✅ Unknown book or member IDs are caught

\- ✅ A book that is already borrowed cannot be borrowed again

\- ✅ A book that is not borrowed cannot be returned



\---



\## 🔄 How Borrowing Works



```mermaid

flowchart TD

&#x20;   A(\[Click Borrow Book]) --> B\[Enter Book ID and Member ID]

&#x20;   B --> C{Book exists?}

&#x20;   C -- No --> X1\[Error: Book not found]

&#x20;   C -- Yes --> D{Member exists?}

&#x20;   D -- No --> X2\[Error: Member not found]

&#x20;   D -- Yes --> E{Book available?}

&#x20;   E -- No --> X3\[Error: Already borrowed]

&#x20;   E -- Yes --> F\[Status set to Borrowed]

&#x20;   F --> G\[Transaction saved with today's date]

&#x20;   G --> H(\[Tables and dashboard refresh])

```



\---



\## 🛠️ Tech Stack



| Technology | Purpose |

|---|---|

| ☕ Java | Core language and OOP design |

| 🖼️ Java Swing | Windows, tabs, tables, dialogs, buttons |

| 📦 `ArrayList` | In-memory storage for books, members and transactions |

| 📅 `LocalDate` | Date stamps on transactions |



No external libraries are needed.



\---



\## 📁 Project Structure



| File | Role |

|---|---|

| `Book.java` | Book entity: ID, title, author, category, status |

| `Member.java` | Member entity: ID, name, email, role |

| `Transaction.java` | Borrow or return record: ID, book, member, type, date |

| `LibraryManagementSystem.java` | Main window, tabs and application logic |



```

SchoolLibrary/

├── src/

│   ├── Book.java

│   ├── Member.java

│   ├── Transaction.java

│   └── LibraryManagementSystem.java

├── .gitignore

└── README.md

```



\---



\## 🚀 Getting Started



\*\*Requirement:\*\* JDK 8 or newer (\[download](https://adoptium.net/)). Check with `javac -version`.



```bash

git clone https://github.com/Arun5916/schoolLibrary.git

cd schoolLibrary/src

javac \*.java

java LibraryManagementSystem

```



The app opens with sample data already loaded.



<details>

<summary><b>🧪 Sample data to try (click to expand)</b></summary>



<br/>



\*\*Books\*\*



| ID | Title | Author | Category |

|---|---|---|---|

| B001 | To Kill a Mockingbird | Harper Lee | Fiction |

| B002 | 1984 | George Orwell | Fiction |

| B003 | Pride and Prejudice | Jane Austen | Classic |

| B004 | The Great Gatsby | F. Scott Fitzgerald | Classic |

| B005 | Harry Potter and the Sorcerer's Stone | J.K. Rowling | Fantasy |

| B006 | The Hobbit | J.R.R. Tolkien | Fantasy |

| B007 | The Catcher in the Rye | J.D. Salinger | Fiction |

| B008 | The Lord of the Rings | J.R.R. Tolkien | Fantasy |

| B009 | The Alchemist | Paulo Coelho | Fiction |

| B010 | Jane Eyre | Charlotte Bronte | Classic |



\*\*Members\*\*



| ID | Name | Role |

|---|---|---|

| M001 | Sarah Johnson | Student |

| M002 | Michael Chen | Student |

| M003 | Emily Williams | Faculty |

| M004 | David Martinez | Student |

| M005 | Lisa Anderson | Staff |



</details>



\---



\## 🎮 Quick Demo



1\. Open the \*\*Books\*\* tab and click \*\*Borrow Book\*\*

2\. Enter Book ID `B001` and Member ID `M001`

3\. Watch the \*\*Available Books\*\* count drop on the Dashboard

4\. Click \*\*Return Book\*\* and enter `B001`

5\. Open the \*\*Transactions\*\* tab to see both records



\---



\## 📸 Screenshots



<!-- Record the app with ScreenToGif (free, Windows), save it in a screenshots folder, then use:

<div align="center">

&#x20; <img src="screenshots/demo.gif" width="800" alt="App demo"/>

</div>

\-->



\---



\## ⚠️ Limitations and 🔮 Future Plans



| Current limitation | Planned improvement |

|---|---|

| Data resets when the app closes | Save data with a database (JDBC with MySQL or SQLite) or files |

| No due dates, fines or overdue tracking | Due dates and overdue book detection |

| No search or filter | Search and filter for books and members |

| Records cannot be edited or deleted | Edit and delete options |

| Duplicate IDs are not blocked | ID uniqueness checks |



\---



\## 👨‍💻 Team



| Name | Role |

|---|---|

| Arshad Mohammad B | Group member |

| Arungopal R | Group member |

| Adithyan KM | Group member |



\---



<div align="center">



Made with ☕ at \*\*Jyothi Engineering College\*\*, Department of Computer Science \& Engineering



<img src="https://capsule-render.vercel.app/api?type=waving\&color=gradient\&customColorList=6,11,20\&height=100\&section=footer" alt="footer"/>



</div>

