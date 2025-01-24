package day13.exam2;

public class Prob02 {
    public static void main(String[] args) {
        BookMgr bookMgr = new BookMgr();

        bookMgr.booklist.add(0, new Book("Java Program", 26400));
        bookMgr.booklist.add(1, new Book("JSP Program", 26400));
        bookMgr.booklist.add(2, new Book("SQL Fundamentals", 26400));
        bookMgr.booklist.add(3, new Book("JDBC Program", 26400));
        bookMgr.booklist.add(4, new Book("EJB Program", 26400));

        bookMgr.printBookList();
        bookMgr.printTotalPrice();
    }
}
