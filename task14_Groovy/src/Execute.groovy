def pathToDir = "/home/ITRANSITION.CORP/v.ostroverhov/Downloads"
def extension = "docx"
def timeRange = 100000
def numberString = 3
def pathToFile = "doc1.txt"

SearchLastChange.getListLastModifiedFiles(pathToDir, extension, timeRange)
ListDiff.difList()
WorkWithFile.executeWorkWithFile(pathToFile, numberString)