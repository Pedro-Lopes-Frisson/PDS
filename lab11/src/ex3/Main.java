package ex3;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java EBook", 2011, "Xinderia");
        Book b2 = new Book("TicTac aa", 1919, "Onichwa");
        Book b3 = new Book("A Procura da Luz", 2017, "Some one sa");
        Library l = new Library();
        l.addBook(b1);
        l.addBook(b2);
        l.addBook(b3);

        l.manage();

    }
}
