import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibrarySystemGUI extends JFrame {
    private LibrarySystem librarySystem;
    private JTextField userInputField;

    public LibrarySystemGUI() {
        librarySystem = new LibrarySystem();

        // Set up the frame of Gui
        setTitle("Library System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JTextArea outputTextArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        JPanel menuPanel = new JPanel(new GridLayout(9, 0));
        userInputField = new JTextField(20); 

        JButton addBookButton = new JButton("Add Book"); // Done
        JButton addUserButton = new JButton("Add User"); // Done
        JButton printLibraryByIdButton = new JButton("Print Library by ID"); // Done
        JButton printLibraryByNameButton = new JButton("Print Library by Name"); // Done
        JButton printUsersButton = new JButton("Print Users"); // Done
        JButton printBorrowersButton = new JButton("Print Who Borrowed Book By Name"); // Done
        JButton searchBooksButton = new JButton("Search Books"); // Done
        JButton borrowBookButton = new JButton("Borrow Book"); // Done
        JButton returnBookButton = new JButton("Return Book"); // Done

        // font and color of output txt area
        Font outputfont = new Font(" ", Font.PLAIN, 20);
        outputTextArea.setBackground(Color.lightGray);
        outputTextArea.setForeground(Color.black);
        outputTextArea.setFont(outputfont);
     
        // font and color of button
        addBookButton.setBackground(Color.lightGray);
        addBookButton.setForeground(Color.black);
        addUserButton.setBackground(Color.lightGray);
        addUserButton.setForeground(Color.BLACK);
        printLibraryByIdButton.setBackground(Color.lightGray);
        printLibraryByIdButton.setForeground(Color.BLACK);
        printLibraryByNameButton.setBackground(Color.lightGray);
        printLibraryByNameButton.setForeground(Color.BLACK);
        printUsersButton.setBackground(Color.lightGray);
        printUsersButton.setForeground(Color.BLACK);
        printBorrowersButton.setBackground(Color.lightGray);
        printBorrowersButton.setForeground(Color.BLACK);
        searchBooksButton.setBackground(Color.lightGray);
        searchBooksButton.setForeground(Color.BLACK);
        borrowBookButton.setBackground(Color.lightGray);
        borrowBookButton.setForeground(Color.BLACK);
        returnBookButton.setBackground(Color.lightGray);
        returnBookButton.setForeground(Color.BLACK);

        // Add buttons to menu panel
        menuPanel.add(addBookButton);
        menuPanel.add(addUserButton);
        menuPanel.add(searchBooksButton);
        menuPanel.add(printUsersButton);
        menuPanel.add(printLibraryByIdButton);
        menuPanel.add(printLibraryByNameButton);
        menuPanel.add(borrowBookButton);
        menuPanel.add(returnBookButton);
        menuPanel.add(printBorrowersButton);

        // Done
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter book name:");
                String idString = JOptionPane.showInputDialog("Enter book id:");

                //convert string to int
                int id = Integer.parseInt(idString);

                if (librarySystem.getTotalBooks() < librarySystem.getBooksLength()) {
                    librarySystem.addBook(name, id);
                    outputTextArea.append("Book added.\n");
                } else {
                    outputTextArea.append("Maximum books limit reached.");
                }
            }
        });     

        // Done
        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                String name = JOptionPane.showInputDialog("Enter user name:");
                String idString = JOptionPane.showInputDialog("Enter user id:");
               
                int id = Integer.parseInt(idString);
                if (librarySystem.getTotalUsers() < librarySystem.getUsersLength()) {
                    librarySystem.addUser(name, id);
                    outputTextArea.append("User added.\n");
                } else
                    outputTextArea.append("Maximum users limit reached.");
            }
        });

        // Done
        printLibraryByIdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = librarySystem.printLibraryById();
                outputTextArea.append(result);
            }
        });

        // Done
        printLibraryByNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = librarySystem.printLibraryByName();
                outputTextArea.append(result);
            }
        });

        // Done
        printUsersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = librarySystem.printUsers();
                outputTextArea.append(result);
            }
        });

        // Done
        borrowBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = JOptionPane.showInputDialog("Enter user name:");
                String userId = JOptionPane.showInputDialog("Enter user id:");
                String bookName = JOptionPane.showInputDialog("Enter book name:");

                int id = Integer.parseInt(userId);

                String result = librarySystem.userBorrowBook(userName, id, bookName);
                outputTextArea.append(result);
            }
        });

        // Done 
        printBorrowersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog("Enter Book name:");

                String result = librarySystem.printWhoBorrowedBookByName(bookName);
                outputTextArea.append(result);
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = JOptionPane.showInputDialog("Enter user name:");
                String bookName = JOptionPane.showInputDialog("Enter book name:");

                String result = librarySystem.userReturnBook(userName, bookName);
                outputTextArea.append(result);
            }
        });

        searchBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt user to enter book name and id
                String name = JOptionPane.showInputDialog("Enter book name:");

                if (librarySystem.findBookIdxByName(name) != -1) {
                    outputTextArea.append("Book Founded.\n");
                } else {
                    outputTextArea.append("Book Not Founded.\n");
                }
            }
        });

        // Set layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.WEST);

        // Display the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        LibrarySystemGUI librarySystemGUI = new LibrarySystemGUI();
    }
}
