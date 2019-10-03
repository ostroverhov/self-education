package framework.elements;

import aquality.selenium.logger.Logger;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliElement {

    private static final Logger logger = Logger.getInstance();
    private static final float similarity = 0.7f;

    private static Pattern getPattern(String pathToImage) {
        return new Pattern(pathToImage).similar(similarity);
    }

    public static void dragAndDrop(String pathToImage, String pathPlaceToMove) {
        logger.info("Drag image");
        try {
            Screen screen = new Screen();
            screen.dragDrop(getPattern(pathToImage), getPattern(pathPlaceToMove));
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public static void clickImage(String pathToImage) {
        logger.info("Click image");
        try {
            new Screen().click(getPattern(pathToImage));
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public static boolean isPresent(String pathToImage) {
        logger.info("Check image");
        return new Screen().exists(getPattern(pathToImage)) != null;
    }
}
