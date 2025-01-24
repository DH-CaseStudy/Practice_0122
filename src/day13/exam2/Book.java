package day13.exam2;

public class Book {
    private String title;
    private int price;

    public Book(String _title, int _price) {
        this.title = _title;
        this.price = _price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

