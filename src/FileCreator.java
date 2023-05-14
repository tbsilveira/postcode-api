import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {

    public void jsonCreator(Address address) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter writeFile = new FileWriter(address.cep() + ".json");
        writeFile.write(gson.toJson(address));
        writeFile.close();
    }
}
