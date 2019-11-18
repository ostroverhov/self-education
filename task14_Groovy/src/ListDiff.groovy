class ListDiff {

    static def col1 = ["Alex", "Dima", "Kate", "Galina", "Ivan"]
    static def col2 = ["Dima", "Ivan", "Kate"]

    static difList() {
        for (name in col2) {
            col1.remove(name)
        }
        println(col1)
    }
}
