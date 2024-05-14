// ahmed 2022 {play , c++}
public class User {
    private String name;
    private int id;
    private int[] borrowedBooksIds;
    private int max_book_limit;

    public User(){
        name = "";
        max_book_limit = 0;
        id = -1;
    }

    public User(String name , int id) {
       this.name = name;
       this.id = id;
       borrowedBooksIds = new int[10]; // Assuming maximum 10 borrowed books
    }

    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }

    public void borrow(int bookId) {
        borrowedBooksIds[max_book_limit++] = bookId;
    }

    public void returnCopy(int bookId) { 
        for (int i = 0; i < max_book_limit; ++i) {
            if (borrowedBooksIds[i] == bookId) {
                for (int j = i + 1; j < max_book_limit; ++j) //shiftright
                    borrowedBooksIds[j - 1] = borrowedBooksIds[j];
                --max_book_limit;
                break;
            }
        }
    }

    public boolean isBorrowed(int bookId) {
        for (int i = 0; i < max_book_limit; ++i) {
            if (bookId == borrowedBooksIds[i])
                return true;
        }
        return false;
    }
    
}
