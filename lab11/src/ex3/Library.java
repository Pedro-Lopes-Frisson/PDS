package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void manage() {
        Scanner sc = new Scanner(System.in);
        boolean errorFlag = false;
        do {
            if (!errorFlag) {
                System.out.println("*** Library ***");
                for (Book b : books)
                    System.out.println(b);
                System.out.println(
                        ">> <livro>, <operacao: (1)registar; (2)requisitar; (3)devolver; (4)reservar; (5)cancelar \n");

            }
            System.out.print(">> ");
            errorFlag = false;

            String line = sc.nextLine();
            if (!line.contains(",")) {
                System.err.println("Oops something went wrong !\n");
                continue;
            }

            int book = Integer.parseInt(line.split(",")[0]) - 1;
            int op = Integer.parseInt(line.split(",")[1]);
            switch (op) {
            case 1:
                try {
                    books.get(book).register();
                } catch (Exception e) {
                    errorFlag = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            case 2:
                try {
                    books.get(book).take();
                } catch (Exception e) {
                    errorFlag = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;

            case 3:
                try {
                    books.get(book).giveBack();
                } catch (Exception e) {
                    errorFlag = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;

            case 4:
                try {
                    books.get(book).reserve();
                } catch (Exception e) {
                    errorFlag = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;

            case 5:
                try {
                    books.get(book).cancelReserve();
                } catch (Exception e) {
                    errorFlag = true;
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            }
        } while (true);

    }
}
