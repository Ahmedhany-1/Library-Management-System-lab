import java.util.Arrays;

public class LibrarySystem {
    private int totalBooks; // number of books in system
    private int totalUsers; // number of users in system
    private Book[] books;
    private User[] users;

    // Done
    public LibrarySystem() {
        totalBooks = totalUsers = 0;
        books = new Book[50]; // Assuming maximum 50 books
        users = new User[50]; // Assuming maximum 50 users
    }

    // Done
    int getTotalUsers() {
        return totalUsers;
    }
    
    // Done
    int getUsersLength() {
        return users.length; // back for length(50)
    }

    // Done
    int getTotalBooks() {
        return totalBooks;
    }

    // Done
    int getBooksLength() {
        return books.length;
    }

    // Done
    public void addBook(String name , int id) {
        books[totalBooks++] = new Book(id, name);
    }

    // Done
    public void addUser(String name, int id) {
        users[totalUsers++] = new User(name, id);
    }

    // Done
    public String printLibraryById() {

        // Sort books by id
        Arrays.sort(books, 0, totalBooks, (a, b) -> a.getId() - b.getId());

        StringBuilder result = new StringBuilder();
        if (totalBooks == 0)
            result.append("No books in library...!\n");

        else {
            result.append("======= Library Book sorted by id ==========\n");
            for (int i = 0; i < totalBooks; ++i) {
                result.append("Name = ")
                        .append(books[i].getName())
                        .append("\nId = ")
                        .append(books[i].getId())
                        .append("\n");
            }
            result.append("==========================================\n");
        }
        return result.toString();
    }

    // Done
    public String printLibraryByName() {
        // Sort books by name
        Arrays.sort(books, 0, totalBooks, (a, b) -> a.getName().compareTo(b.getName()));

        StringBuilder result = new StringBuilder();
        if (totalBooks == 0)
            result.append("No books in library...!\n");
        else {
            result.append("======= Library Book sorted by name ==========\n");
            for (int i = 0; i < totalBooks; ++i) {
                result.append("Name = ")
                        .append(books[i].getName())
                        .append("\nId = ")
                        .append(books[i].getId())
                        .append("\n");
            }

            result.append("==========================================\n");
        }
        return result.toString();

    }

    // Done
    public String printUsers() {
        StringBuilder result = new StringBuilder();
        if (totalUsers == 0)
            result.append("No users found...!");

        else {
            result.append("======= Users in library (name,id) ==========\n");
            for (int i = 0; i < totalUsers; ++i) {
                result.append("Name = :")
                      .append(users[i].getName())
                      .append("\nId = :").append(users[i].getId())
                      .append("\n");
            }
            result.append("==========================================\n");
        }
        return result.toString();
    }
  
    // Done
    public int findBookIdxByName(String name) {
        for (int i = 0; i < totalBooks; ++i) {
            if (name.equalsIgnoreCase(books[i].getName()))
                return i;
        }
        return -1;
    }

    // Done 
    public int findUserIdxByName(String name) {
        for (int i = 0; i < totalUsers; ++i) {
            if (name.equalsIgnoreCase(users[i].getName()))
                return i;
        }
        return -1;
    }

    // Done  
    public String userBorrowBook(String userName, int userId, String bookName) {
        StringBuilder result = new StringBuilder();

        int bookIdx = findBookIdxByName(bookName);   // book founded ? (idx) : -1
        int userIndex = findUserIdxByName(userName); // user founded ? (idx) : -1
       

        if (bookIdx == -1) // no founded
            result.append("Invalid book name...!");

        else if (userIndex == -1) // no founded
            result.append("Invalid user name or user ID...!");

        else if (!books[bookIdx].borrow()) // can take ? 1 : 0
            result.append("No more copies available right now...!");

        else {
            int bookId = books[bookIdx].getId();
            users[userIndex].borrow(bookId);
            result.append("Successfully borrowed the book...");
        }
        result.append("\n==========================================\n");
        return result.toString();
    }

    public String userReturnBook(String userName, String bookName) {
        StringBuilder result = new StringBuilder();

        int UserIdx = findUserIdxByName(userName);
        int BookIdx = findBookIdxByName(bookName);
        int bookId = books[BookIdx].getId(); 
        
        if (UserIdx == -1)
            result.append("Invalid user name. Try again...!");
        
        else if (BookIdx == -1)
            result.append("Invalid book name. Try again...!");
        
        else if (!(users[UserIdx].isBorrowed(bookId)))
            result.append("User not borrowed this book...!");
        else {
            books[UserIdx].returnCopy();
            users[BookIdx].returnCopy(bookId);
            result.append("The book is returned Successfully..!");
        }
        result.append("\n==========================================\n");
        return result.toString();
    }

    //Done
    public String printWhoBorrowedBookByName(String bookName) {
        StringBuilder result = new StringBuilder();

        int bookIdx = findBookIdxByName(bookName);
        
        if (bookIdx == -1)
            result.append("Invalid book name...!\n");

        else if (books[bookIdx].getTotalBorrowed() == 0)
            result.append("No borrowed copies...!\n");

        else {
            int bookId = books[bookIdx].getId(); 
            result.append("\nthe user is :\n");
            result.append("..............................................\n");
            for (int i = 0; i < totalUsers; ++i) {
                if (users[i].isBorrowed(bookId))
                    result.append("Name: ").append(users[i].getName()).append("\n");
            }
            result.append("==========================================\n");
        }
        return result.toString();
    }

}
