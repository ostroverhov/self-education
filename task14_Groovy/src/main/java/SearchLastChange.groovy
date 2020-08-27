import utils.Logger

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributeView

class SearchLastChange {
    static getListLastModifiedFiles(pathToDir, String extension, timeRange) {
        Logger.info("get list last modified files")
        def dir = new File(pathToDir)
        def listFiles = []
        dir.eachFile { file ->
            if (file.getName().contains(extension)) {
                listFiles << file
            }
        }
        listFiles.sort { a, b -> getTimeCreationFile(b) <=> getTimeCreationFile(a) }
        File lastModifiedFile = listFiles[0]
        listFiles.each { file ->
            if (getTimeCreationFile(lastModifiedFile) - timeRange <= getTimeCreationFile(file)) {
                println(file)
            }
        }
    }

    private static getTimeCreationFile(File file) {
        Logger.info("get time creation file")
        Path path = Paths.get(file.getAbsolutePath())
        Files.getFileAttributeView(path, BasicFileAttributeView.class).readAttributes().creationTime().toMillis()
    }
}
