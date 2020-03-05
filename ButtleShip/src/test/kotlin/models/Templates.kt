package models

class Templates {

    fun generateCombinationFieldsTemplate(): LinkedHashSet<Field?>? {
        val fields = LinkedHashSet<Field?>()
        addDiagonal(7, 1, fields)
        addDiagonal(3, 1, fields)
        addDiagonal(1, 3, fields)
        addDiagonal(1, 7, fields)
        addDiagonal(1, 9, fields)
        addDiagonal(1, 5, fields)
        addDiagonal(1, 1, fields)
        addDiagonal(5, 1, fields)
        addDiagonal(9, 1, fields)
        addRandomFields(fields)
        return fields
    }

    private fun addDiagonal(startRow: Int, startCol: Int, fields: LinkedHashSet<Field?>) {
        var row = startRow
        var col = startCol
        while (row <= 10) {
            if (col <= 10) {
                fields.add(Field(row, col))
            }
            row++
            col++
        }
    }

    private fun addRandomFields(fields: LinkedHashSet<Field?>) {
        val randomFields: HashSet<Field?> = HashSet()
        for (row in 1..10) {
            for (col in 1..10) {
                randomFields.add(Field(row, col))
            }
        }
        fields.addAll(randomFields)
    }

    fun killShipTemplate(field: Field): LinkedHashSet<Field>? = with(LinkedHashSet<Field>()) {
        val row = field.row
        val col = field.col
        if (row + 1 <= 10) {
            this.add(Field(row + 1, col))
        }
        if (row - 1 >= 1) {
            this.add(Field(row - 1, col))
        }
        if (col + 1 <= 10) {
            this.add(Field(row, col + 1))
        }
        if (col - 1 >= 1) {
            this.add(Field(row, col - 1))
        }
        return this
    }
}