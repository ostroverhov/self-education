package utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import models.Book

class JsonUtils {
    static ArrayList<Book> jsonToBooks(def pathToJson) {
        println(new File(pathToJson).text)
        new Gson().fromJson(new File(pathToJson).text, new TypeToken<List<Book>>() {
        }.getType())
    }

    static writeListToFile(File file, def list) {
        file.delete()
        file.createNewFile()
        file.write(new Gson().toJson(list))
    }
}
