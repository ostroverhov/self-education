package project.steps;

import framework.utils.RegexpHandler;
import framework.utils.XmlPlaceholderApi;
import framework.utils.XmlUtils;
import org.testng.Assert;
import project.models.Book;
import project.models.Catalog;
import project.models.ResponseFromApi;
import project.projectutils.SelectionUtils;

public class StepsApi {

    private static final String patternGetIdBook = "bk([\\d]{3})";
    private static final int ok = 200;

    public static Catalog getAllBook() throws Throwable {
        ResponseFromApi responseFromApi = XmlPlaceholderApi.executeGetRequest();
        assertStatusCode(responseFromApi, ok);
        Catalog catalog = XmlUtils.getCatalog(responseFromApi.getBody());
        assertOrderArrayBooks(catalog);
        return catalog;
    }

    public static void compareMaxMinPrice(Catalog catalog) {
        assertNameAndDescriptionBooks(SelectionUtils.getMaxFromList(catalog), SelectionUtils.getMinFromList(catalog));
    }

    private static void assertOrderArrayBooks(Catalog catalog) {
        for (int i = 0; i < catalog.getBooks().size() - 1; i++) {
            Assert.assertTrue(getIdBookFromArray(catalog, i + 1) > getIdBookFromArray(catalog, i), "Post number " + getIdBookFromArray(catalog, i) + " not match");
        }
    }

    private static int getIdBookFromArray(Catalog catalog, int numberBook) {
        return RegexpHandler.getNumbers(patternGetIdBook, catalog.getBooks().get(numberBook).getId());
    }

    private static void assertStatusCode(ResponseFromApi responseFromApi, int statusCode) {
        Assert.assertEquals(responseFromApi.getStatusCode(), statusCode, "Status code not match");
    }

    private static void assertNameAndDescriptionBooks(Book maxPrice, Book minPrice) {
        Assert.assertNotEquals(maxPrice.getTitle(), minPrice.getTitle(), "Title not equals");
        Assert.assertNotEquals(maxPrice.getDescription(), minPrice.getDescription(), "Description not equals");
    }
}
