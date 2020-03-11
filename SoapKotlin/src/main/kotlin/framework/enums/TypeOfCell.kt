package framework.enums

enum class TypeOfCell(typeOfCellDb: String?) {

    INT("int"),
    NCHAR("nchar"),
    NUMERIC("numeric");

    val typeCell: String? = typeOfCellDb
}