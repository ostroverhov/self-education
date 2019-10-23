package project.projectutils;

import aquality.selenium.logger.Logger;
import project.models.Book;
import project.models.Catalog;

public class SelectionUtils {

    private static final Logger logger = Logger.getInstance();

    public static Book getMaxFromList(Catalog catalog) {
        logger.info("Get book with max price");
        Double max = Double.MIN_VALUE;
        Book bookWithMaxPrice = catalog.getBooks().get(0);
        for (Book i : catalog.getBooks()) {
            if (max < i.getPrice()) {
                max = i.getPrice();
                bookWithMaxPrice = i;
            }
        }
        return bookWithMaxPrice;
    }

    public static Book getMinFromList(Catalog catalog) {
        logger.info("Get book with min price");
        Double min = Double.MAX_VALUE;
        Book bookWithMinPrice = catalog.getBooks().get(0);
        for (Book i : catalog.getBooks()) {
            if (min > i.getPrice()) {
                min = i.getPrice();
                bookWithMinPrice = i;
            }
        }
        return bookWithMinPrice;
    }
}
