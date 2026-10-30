import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LibraryManagementSystem extends JFrame {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Transaction> transactions;
    
    private JLabel totalBooksLabel;
    private JLabel totalMembersLabel;
    private JLabel totalTransactionsLabel;
    private JLabel availableBooksLabel;
    
    private DefaultTableModel bookTableModel;
    private DefaultTableModel memberTableModel;
    private DefaultTableModel transactionTableModel;
    
    private int transactionCounter = 1;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        transactions = new ArrayList<>();
        
        initializeData();
        
        setTitle("Jyothi Engineering College - Library Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Dashboard", createDashboardPanel());
        tabbedPane.addTab("Books", createBooksPanel());
        tabbedPane.addTab("Members", createMembersPanel());
        tabbedPane.addTab("Transactions", createTransactionsPanel());
        
        add(tabbedPane);
        setVisible(true);
    }

    private void initializeData() {
        books.add(new Book("B001", "To Kill a Mockingbird", "Harper Lee", "Fiction"));
        books.add(new Book("B002", "1984", "George Orwell", "Fiction"));
        books.add(new Book("B003", "Pride and Prejudice", "Jane Austen", "Classic"));
        books.add(new Book("B004", "The Great Gatsby", "F. Scott Fitzgerald", "Classic"));
        books.add(new Book("B005", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy"));
        books.add(new Book("B006", "The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        books.add(new Book("B007", "The Catcher in the Rye", "J.D. Salinger", "Fiction"));
        books.add(new Book("B008", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy"));
        books.add(new Book("B009", "The Alchemist", "Paulo Coelho", "Fiction"));
        books.add(new Book("B010", "Jane Eyre", "Charlotte Bronte", "Classic"));
        
        members.add(new Member("M001", "Sarah Johnson", "sarah.j@jec.ac.in", "Student"));
        members.add(new Member("M002", "Michael Chen", "michael.c@jec.ac.in", "Student"));
        members.add(new Member("M003", "Emily Williams", "emily.w@jec.ac.in", "Faculty"));
        members.add(new Member("M004", "David Martinez", "david.m@jec.ac.in", "Student"));
        members.add(new Member("M005", "Lisa Anderson", "lisa.a@jec.ac.in", "Staff"));
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel("Library Dashboard", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel statsPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        totalBooksLabel = createStatLabel("Total Books", String.valueOf(books.size()));
        totalMembersLabel = createStatLabel("Total Members", String.valueOf(members.size()));
        totalTransactionsLabel = createStatLabel("Total Transactions", String.valueOf(transactions.size()));
        availableBooksLabel = createStatLabel("Available Books", String.valueOf(countAvailableBooks()));
        
        statsPanel.add(totalBooksLabel);
        statsPanel.add(totalMembersLabel);
        statsPanel.add(availableBooksLabel);
        statsPanel.add(totalTransactionsLabel);
        
        panel.add(statsPanel, BorderLayout.CENTER);
        
        return panel;
    }

    private JLabel createStatLabel(String title, String value) {
        JPanel statPanel = new JPanel();
        statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.Y_AXIS));
        statPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        statPanel.setBackground(new Color(240, 240, 240));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        statPanel.add(Box.createVerticalGlue());
        statPanel.add(titleLabel);
        statPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        statPanel.add(valueLabel);
        statPanel.add(Box.createVerticalGlue());
        
        JLabel containerLabel = new JLabel();
        containerLabel.setLayout(new BorderLayout());
        containerLabel.add(statPanel);
        
        return containerLabel;
    }

    private int countAvailableBooks() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    private JPanel createBooksPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        String[] columnNames = {"Book ID", "Title", "Author", "Category", "Status"};
        bookTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable bookTable = new JTable(bookTableModel);
        bookTable.setRowHeight(25);
        refreshBookTable();
        
        JScrollPane scrollPane = new JScrollPane(bookTable);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Book");
        JButton borrowButton = new JButton("Borrow Book");
        JButton returnButton = new JButton("Return Book");
        JButton refreshButton = new JButton("Refresh");
        
        addButton.addActionListener(e -> addBook());
        borrowButton.addActionListener(e -> borrowBook());
        returnButton.addActionListener(e -> returnBook());
        refreshButton.addActionListener(e -> refreshBookTable());
        
        buttonPanel.add(addButton);
        buttonPanel.add(borrowButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(refreshButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }

    private JPanel createMembersPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        String[] columnNames = {"Member ID", "Name", "Email", "Role"};
        memberTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable memberTable = new JTable(memberTableModel);
        memberTable.setRowHeight(25);
        refreshMemberTable();
        
        JScrollPane scrollPane = new JScrollPane(memberTable);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Member");
        JButton refreshButton = new JButton("Refresh");
        
        addButton.addActionListener(e -> addMember());
        refreshButton.addActionListener(e -> refreshMemberTable());
        
        buttonPanel.add(addButton);
        buttonPanel.add(refreshButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }

    private JPanel createTransactionsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        String[] columnNames = {"Transaction ID", "Book ID", "Member ID", "Type", "Date"};
        transactionTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable transactionTable = new JTable(transactionTableModel);
        transactionTable.setRowHeight(25);
        refreshTransactionTable();
        
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshTransactionTable());
        buttonPanel.add(refreshButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }

    private void addBook() {
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField categoryField = new JTextField();
        
        Object[] message = {
            "Book ID:", idField,
            "Title:", titleField,
            "Author:", authorField,
            "Category:", categoryField
        };
        
        int option = JOptionPane.showConfirmDialog(this, message, "Add Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String id = idField.getText().trim();
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String category = categoryField.getText().trim();
            
            if (id.isEmpty() || title.isEmpty() || author.isEmpty() || category.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            books.add(new Book(id, title, author, category));
            refreshBookTable();
            updateDashboard();
            JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addMember() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        String[] roles = {"Student", "Faculty", "Staff"};
        JComboBox<String> roleCombo = new JComboBox<>(roles);
        
        Object[] message = {
            "Member ID:", idField,
            "Name:", nameField,
            "Email:", emailField,
            "Role:", roleCombo
        };
        
        int option = JOptionPane.showConfirmDialog(this, message, "Add Member", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String role = (String) roleCombo.getSelectedItem();
            
            if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            members.add(new Member(id, name, email, role));
            refreshMemberTable();
            updateDashboard();
            JOptionPane.showMessageDialog(this, "Member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void borrowBook() {
        JTextField bookIdField = new JTextField();
        JTextField memberIdField = new JTextField();
        
        Object[] message = {
            "Book ID:", bookIdField,
            "Member ID:", memberIdField
        };
        
        int option = JOptionPane.showConfirmDialog(this, message, "Borrow Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String bookId = bookIdField.getText().trim();
            String memberId = memberIdField.getText().trim();
            
            Book book = findBookById(bookId);
            Member member = findMemberById(memberId);
            
            if (book == null) {
                JOptionPane.showMessageDialog(this, "Book not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (member == null) {
                JOptionPane.showMessageDialog(this, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!book.isAvailable()) {
                JOptionPane.showMessageDialog(this, "Book is already borrowed!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            book.setStatus("Borrowed");
            Transaction transaction = new Transaction("T" + String.format("%03d", transactionCounter++), 
                    bookId, memberId, "Borrow", LocalDate.now());
            transactions.add(transaction);
            
            refreshBookTable();
            refreshTransactionTable();
            updateDashboard();
            JOptionPane.showMessageDialog(this, "Book borrowed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void returnBook() {
        String bookId = JOptionPane.showInputDialog(this, "Enter Book ID to return:");
        
        if (bookId == null || bookId.trim().isEmpty()) {
            return;
        }
        
        Book book = findBookById(bookId.trim());
        
        if (book == null) {
            JOptionPane.showMessageDialog(this, "Book not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (book.isAvailable()) {
            JOptionPane.showMessageDialog(this, "Book is not borrowed!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        book.setStatus("Available");
        
        String memberId = "";
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            if (t.getBookId().equals(bookId) && t.getType().equals("Borrow")) {
                memberId = t.getMemberId();
                break;
            }
        }
        
        Transaction transaction = new Transaction("T" + String.format("%03d", transactionCounter++), 
                bookId, memberId, "Return", LocalDate.now());
        transactions.add(transaction);
        
        refreshBookTable();
        refreshTransactionTable();
        updateDashboard();
        JOptionPane.showMessageDialog(this, "Book returned successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    private Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    private void refreshBookTable() {
        bookTableModel.setRowCount(0);
        for (Book book : books) {
            bookTableModel.addRow(new Object[]{
                book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getStatus()
            });
        }
    }

    private void refreshMemberTable() {
        memberTableModel.setRowCount(0);
        for (Member member : members) {
            memberTableModel.addRow(new Object[]{
                member.getId(), member.getName(), member.getEmail(), member.getRole()
            });
        }
    }

    private void refreshTransactionTable() {
        transactionTableModel.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (Transaction transaction : transactions) {
            transactionTableModel.addRow(new Object[]{
                transaction.getId(), transaction.getBookId(), transaction.getMemberId(), 
                transaction.getType(), transaction.getDate().format(formatter)
            });
        }
    }

    private void updateDashboard() {
        ((JLabel)((JPanel)totalBooksLabel.getComponent(0)).getComponent(3)).setText(String.valueOf(books.size()));
        ((JLabel)((JPanel)totalMembersLabel.getComponent(0)).getComponent(3)).setText(String.valueOf(members.size()));
        ((JLabel)((JPanel)totalTransactionsLabel.getComponent(0)).getComponent(3)).setText(String.valueOf(transactions.size()));
        ((JLabel)((JPanel)availableBooksLabel.getComponent(0)).getComponent(3)).setText(String.valueOf(countAvailableBooks()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new LibraryManagementSystem();
        });
    }
}
