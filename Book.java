public class Book {
    private int id;
    private String name;
    private int totalQuantity; //number of instance of book 
    private int totalBorrowed;

    public Book() {
        totalQuantity = totalBorrowed = 0;
        id = -1;
        name = "";
    } 

    public Book(int id,String name) {
        this.totalQuantity = totalQuantity + 1 ;
        this.id = id;
        this.name = name;
    }

         
    public String getName(){
       return name;
    }
  
    public int getId(){
        return id;
    }
    
    public int getTotalQuantity(){
        return totalQuantity;
    }  
   
    public int getTotalBorrowed(){
        return totalBorrowed;
    }

    public boolean borrow() {
        if (totalQuantity - totalBorrowed == 0)
            return false;
        ++totalBorrowed;
        return true;
    }

    public void returnCopy() {
        if(totalBorrowed > 0)
            --totalBorrowed;
    }

}
