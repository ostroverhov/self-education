package framework.utils;

import java.util.List;

public class Discount {
    public static int indexMimDiscountGame(List<Integer> elements) {
        int index = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(index) < elements.get(i)) {
                index = i;
            }
        }
        return index;
    }

    public static int indexMinDiscountGame(List<Integer> elements) {
        int index = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(index) > elements.get(i)) {
                index = i;
            }
        }
        return index;
    }

    public static int getNumberDiscount(String discount) {
        return Integer.parseInt(discount.split("%")[0].split("-")[1]);
    }
}
