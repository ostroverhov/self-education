class SearchLastChange {

    static getListLastModifiedFiles(pathToDir, String extension, timeRange) {
        def dir = new File(pathToDir)
        def listFiles = []
        dir.eachFile { file ->
            if (file.getName().contains(extension)) {
                listFiles << file
            }
        }
        listFiles.sort { a, b -> b.lastModified() <=> a.lastModified() }
        def lastModifiedFile = listFiles[0]
        listFiles.each { file ->
            if (lastModifiedFile.lastModified() - timeRange <= file.lastModified())
                println(file)
        }
    }
}
