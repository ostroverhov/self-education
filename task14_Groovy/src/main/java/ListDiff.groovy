import utils.Logger

class ListDiff {
    static getDiffList(def col1, def col2) {
        Logger.info("get diff between list")
        def resultCol = col1
        for (name in col2) {
            resultCol.remove(name)
        }
        println(resultCol)
    }
}
