package framework.browser

class IllegalBrowserNameExceptions : IllegalArgumentException() {
    init {
        println("Select browser chrome / firefox")
    }
}