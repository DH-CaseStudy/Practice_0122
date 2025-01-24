package day13.class실습;



public class BookMgr{
    private Book[] booklist;

    public BookMgr(Book[] booklist) {
        this.booklist = booklist;
    }

    public void printBooklist() {

        for (Book book : booklist) {
            System.out.println(book.getTitle());
        }
    }

    public void printTotalPrice() {
        int tot = 0;
        for (Book book : booklist) {
            tot += book.getPrice();
        }
        System.out.println(tot);
    }
}