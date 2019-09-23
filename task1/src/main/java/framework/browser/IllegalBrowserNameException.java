package framework.browser;

public class IllegalBrowserNameException extends IllegalArgumentException {

    public IllegalBrowserNameException() {
        System.out.println("Select browser chrome / firefox");
    }
}
