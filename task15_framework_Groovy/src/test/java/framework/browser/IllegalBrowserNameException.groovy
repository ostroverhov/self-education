package framework.browser

class IllegalBrowserNameException extends IllegalArgumentException {
    IllegalBrowserNameException() {
        println("Select browser chrome/firefox")
    }
}
