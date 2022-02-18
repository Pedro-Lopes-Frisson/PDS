package ex3;

public class Book {
    private State s;
    private static int currISBN = 0;
    private int ISBN;
    private int year;
    private String author;
    private String title;

    public Book(String title, int year, String author) {
        s = new Inventory();
        this.title = title;
        this.year = year;
        this.author = author;
        ISBN = ++currISBN;
    }

    public void setState(State s) {
        this.s = s;
    }

    public void register() {
        this.s.register(this);
    }

    public void reserve() {
        this.s.reserve(this);
    }

    public void cancelReserve() {
        this.s.cancelReserve(this);
    }

    public void giveBack() {
        this.s.giveBack(this);
    }

    public void take() {
        this.s.take(this);
    }

    public String toString() {
        return String.format("Book: %-5d %-20s %-20s %-15s", ISBN, title, author,
                "[" + s.getClass().getSimpleName() + "]");
    }
}
