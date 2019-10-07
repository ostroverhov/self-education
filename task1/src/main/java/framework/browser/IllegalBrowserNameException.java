package framework.browser;

import framework.utils.MyLogger;

class IllegalBrowserNameException extends IllegalArgumentException {

    IllegalBrowserNameException() {
        MyLogger.warn("Select browser chrome / firefox");
    }
}
