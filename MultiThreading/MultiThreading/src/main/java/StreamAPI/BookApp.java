package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class BookApp {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Being And Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on the Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));

        //Exercise_1:select all the book where the title is made up of exactly 2 words.
        books.stream().filter(b -> b.getTitle().split(" ").length ==2).collect(Collectors.toList())
                .forEach(b -> System.out.println(b));

        //external iteration (collection)

    }
}
