package day13.exam2;

import java.util.ArrayList;

public class BookMgr {
    public ArrayList<Book> booklist;
    int sum;

    public BookMgr(){
        booklist = new ArrayList<>();
        sum = 0;
    }

    public void printBookList(){
        System.out.println("===  책 목록 ===");
        for (Book book : booklist) {
            System.out.println(book.getTitle());
        }

    }

    public void printTotalPrice(){

        for (Book book : booklist) {
            sum += book.getPrice();
        }

        System.out.println();
        System.out.println();
        System.out.println("=== 책 가격의 총합 ===");
        System.out.println("전체 책 가격의 합 : " + sum);

    }
}
