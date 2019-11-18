class WorkWithFile {
    static def defaultNumber = 10

    static executeWorkWithFile(pathToFile) {
        workWithFile(pathToFile, defaultNumber)
    }

    static executeWorkWithFile(pathToFile, numberString) {
        workWithFile(pathToFile, numberString)
    }

    static workWithFile(pathToFile, numberString) {
        File startFile = new File(pathToFile)
        def lines = startFile.readLines()
        if (lines.size() > numberString) {
            def resultLines = []
            for (int i = 0; i < numberString; i++) {
                def lineForNewFile = lines[new Random().nextInt(lines.size())]
                resultLines.add(lineForNewFile)
                lines.remove(lineForNewFile)
            }
            def newFilePath = pathToFile.replace(pathToFile[pathToFile.lastIndexOf(".")], "_res01.")
            File newFile = new File(newFilePath)
            writeListToFile(newFile, resultLines)
            writeListToFile(startFile, lines)
            return newFilePath
        } else throw new Exception("less string than need")
    }

    static writeListToFile(File file, def list) {
        file.delete()
        file.createNewFile()
        list.each { line ->
            file << line + "\n"
        }
    }
}