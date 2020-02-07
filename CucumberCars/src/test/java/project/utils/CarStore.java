package project.utils;

import framework.utils.JsonUtils;
import project.models.Car;

import java.util.HashMap;
import java.util.Map;

public class CarStore {

    private static String pathToJsonStorage = "src/test/resources/json/";
    private static Map<String, String> storageCars = new HashMap<>();

    public static void putCarInStorage(String nameCar, Car car) {
        String pathToJsonCar = String.format("%s%s.json", pathToJsonStorage, nameCar);
        JsonUtils.writeObjectToJson(pathToJsonCar, car);
        storageCars.put(nameCar, pathToJsonCar);
    }

    public static Car getCarFromStorage(String nameCar) {
        return JsonUtils.getObjectFromJson(storageCars.get(nameCar), Car.class);
    }

    public static void putJsonCarInStorage(String nameCar) {
        storageCars.put(nameCar, String.format("%s%s.json", pathToJsonStorage, nameCar));
    }
}
