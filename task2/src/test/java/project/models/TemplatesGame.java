package project.models;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class TemplatesGame {

    private LinkedHashSet<Field> fields = new LinkedHashSet<>();
    private int col;
    private int row;

    public LinkedHashSet<Field> generateCombinationFieldsTemplate() {
        firstQueueAttepts();
        secondQueueAttempts();
        thirdQueueAttempts();
        return fields;
    }

    private void firstQueueAttepts() {
        for (row = 7; row <= 10; row++) {
            col = row - 6;
            fields.add(new Field(row, col));
        }
        for (row = 3; row <= 10; row++) {
            col = row - 2;
            fields.add(new Field(row, col));
        }
        for (row = 1; row <= 8; row++) {
            col = row + 2;
            fields.add(new Field(row, col));
        }
        for (row = 1; row <= 4; row++) {
            col = row + 6;
            fields.add(new Field(row, col));
        }
    }

    private void secondQueueAttempts() {
        for (row = 1; row <= 2; row++) {
            col = row + 8;
            fields.add(new Field(row, col));
        }
        for (row = 1; row <= 6; row++) {
            col = row + 4;
            fields.add(new Field(row, col));
        }
        for (row = 1; row <= 10; row++) {
            col = row;
            fields.add(new Field(row, col));
        }
        for (row = 5; row <= 10; row++) {
            col = row - 4;
            fields.add(new Field(row, col));
        }
        for (row = 9; row <= 10; row++) {
            col = row - 8;
            fields.add(new Field(row, col));
        }
    }

    private void thirdQueueAttempts() {
        HashSet<Field> randomFields = new HashSet();
        for (row = 1; row <= 10; row++) {
            for (col = 1; col <= 10; col++) {
                randomFields.add(new Field(row, col));
            }
        }
        fields.addAll(randomFields);
    }

    public LinkedHashSet<Field> killShipTemplate(int row, int col) {
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
