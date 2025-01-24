package home;

public class BookMgr {

	Book[] booklist;


	public BookMgr(Book[] booklist) {
		this.booklist = booklist;
	}
	
	public void printBooklist(){
		for (int i = 0; i < booklist.length; i++) {
			System.out.println(booklist[i].getTitle());
		}
	}
	
	public void printTotalPrice(){
		int total = 0;
		for (int i = 0; i < booklist.length; i++) {
			total += booklist[i].getPrice();
		}
	}
}
