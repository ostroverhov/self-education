import utils.JsonUtils
import utils.Logger

class WorkWithFile {
    static def defaultNumber = 10
    static def partNewNameFile = "_res01."

    static selectStringFromFileToAnother(pathToFile, numberString = defaultNumber) {
        Logger.info("select string from file to another file")
        File startFile = new File(pathToFile)
        def books = JsonUtils.jsonToBooks(pathToFile)
        if (books.size() > numberString) {
            def resultBooks = []
            for (int i = 0; i < numberString; i++) {
                def lineForNewFile = books[new Random().nextInt(books.size())]
                resultBooks.add(lineForNewFile)
                books.remove(lineForNewFile)
            }
            def newFilePath = pathToFile.replace(pathToFile[pathToFile.lastIndexOf(".")], partNewNameFile)
            File newFile = new File(newFilePath)
            JsonUtils.writeListToFile(newFile, resultBooks)
            JsonUtils.writeListToFile(startFile, books)
            return newFilePath
        } else {
            Logger.warn("couldn't select string")
            throw new Exception("less string than need")
        }
    }
}