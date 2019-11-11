package project.steps;

import framework.utils.RegexpHandler;
import framework.utils.XmlUtils;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import project.models.Book;
import project.models.Catalog;
import project.models.ResponseFromApi;
import project.projectutils.SelectionUtils;
import project.projectutils.XmlPlaceholderApi;

public class StepsApi {

    private static final String patternGetIdBook = "bk([\\d]{3})";
    private static final int ok = 200;

    public static Catalog getAllBook() throws Throwable {
        ResponseFromApi responseFromApi = XmlPlaceholderApi.executeGetRequest();
        assertStatusCode(responseFromApi, ok);
        String responseBody = responseFromApi.getBody();
        Assert.assertTrue(XmlUtils.validateXmlResponse(responseBody), "Response not validate as XML");
        Catalog catalog = (Catalog) XmlUtils.getObjectFromResponse(responseBody);
        assertOrderArrayBooks(catalog);
        return catalog;
    }

    public static void compareMaxMinPrice(Catalog catalog) {
        assertNameAndDescriptionBooks(SelectionUtils.getMaxFromList(catalog), SelectionUtils.getMinFromList(catalog));
    }

    private static void assertOrderArrayBooks(Catalog catalog) {
        for (int i = 0; i < catalog.getBooks().size() - 1; i++) {
            int idBookFromArray = getIdBookFromArray(catalog, i);
            Assert.assertTrue(getIdBookFromArray(catalog, i + 1) > idBookFromArray, String.format("Post number %s not match", idBookFromArray));
        }
    }

    private static int getIdBookFromArray(Catalog catalog, int numberBook) {
        return RegexpHandler.getNumbers(patternGetIdBook, catalog.getBooks().get(numberBook).getId());
    }

    private static void assertStatusCode(ResponseFromApi responseFromApi, int statusCode) {
        Assert.assertEquals(responseFromApi.getStatusCode(), statusCode, "Status code not match");
    }

    private static void assertNameAndDescriptionBooks(Book maxPrice, Book minPrice) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(maxPrice.getTitle(), minPrice.getTitle(), "Title not equals");
        softAssert.assertNotEquals(maxPrice.getDescription(), minPrice.getDescription(), "Description not equals");
        softAssert.assertAll();
    }
}
