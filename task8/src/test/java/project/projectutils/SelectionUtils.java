package project.projectutils;

import aquality.selenium.logger.Logger;
import project.models.Book;
import project.models.Catalog;

import java.util.List;

public class SelectionUtils {

    private static final Logger logger = Logger.getInstance();

    public static Book getMaxFromList(Catalog catalog) {
        logger.info("Get book with max price");
        double max = Double.MIN_VALUE;
        List<Book> books = getBooks(catalog);
        Book bookWithMaxPrice = books.get(0);
        for (Book i : books) {
            double price = getPrice(i);
            if (max < price) {
                max = price;
                bookWithMaxPrice = i;
            }
        }
        return bookWithMaxPrice;
    }

    public static Book getMinFromList(Catalog catalog) {
        logger.info("Get book with min price");
        double min = Double.MAX_VALUE;
        List<Book> books = getBooks(catalog);
        Book bookWithMinPrice = books.get(0);
        for (Book i : books) {
            double price = getPrice(i);
            if (min > price) {
                min = price;
                bookWithMinPrice = i;
            }
        }
        return bookWithMinPrice;
    }

    private static List<Book> getBooks(Catalog catalog) {
        return catalog.getBooks();
    }

    private static Double getPrice(Book book) {
        return book.getPrice();
    }
}
