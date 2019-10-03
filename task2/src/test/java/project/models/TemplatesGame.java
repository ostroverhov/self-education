package project.models;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class TemplatesGame {

    public LinkedHashSet<Field> generateCombinationFieldsTemplate() {
        LinkedHashSet<Field> fields = new LinkedHashSet<>();
        addDiagonal(7, 1, fields);
        addDiagonal(3, 1, fields);
        addDiagonal(1, 3, fields);
        addDiagonal(1, 7, fields);
        addDiagonal(1, 9, fields);
        addDiagonal(1, 5, fields);
        addDiagonal(1, 1, fields);
        addDiagonal(5, 1, fields);
        addDiagonal(9, 1, fields);
        addRandomFields(fields);
        return fields;
    }

    private void addDiagonal(int startRow, int startCol, LinkedHashSet<Field> fields) {
        for (int row = startRow, col = startCol; row <= 10; row++, col++) {
            if (col <= 10) {
                fields.add(new Field(row, col));
            }
        }
    }

    private void addRandomFields(LinkedHashSet<Field> fields) {
        HashSet<Field> randomFields = new HashSet();
        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                randomFields.add(new Field(row, col));
            }
        }
        fields.addAll(randomFields);
    }

    public LinkedHashSet<Field> killShipTemplate(Field field) {
        LinkedHashSet<Field> fields = new LinkedHashSet<>();
        int row = field.getRow();
        int col = field.getCol();
        if (row + 1 <= 10) {
            fields.add(new Field(row + 1, col));
        }
        if (row - 1 >= 1) {
            fields.add(new Field(row - 1, col));
        }
        if (col + 1 <= 10) {
            fields.add(new Field(row, col + 1));
        }
        if (col - 1 >= 1) {
            fields.add(new Field(row, col - 1));
        }
        return fields;
    }
}
