package framework.utils

import framework.logger.Logger

class Reader {
    static pathToConfig = "/home/ITRANSITION.CORP/v.ostroverhov/Documents/gittask5/task15_framework_Groovy/src/test/resources/config.properties"
    //не работает относительный путь

    static def getParameter(def parameter) {
        Properties property = new Properties()
        try {
            property.load(new FileInputStream(pathToConfig))
        } catch (IOException e) {
            Logger.warn("Couldn't get parameter")
            throw new IOException("Couldn't get parameter")
        }
        property.getProperty(parameter)
    }
}
