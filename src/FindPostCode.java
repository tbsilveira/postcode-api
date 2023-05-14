import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FindPostCode {
    public Address findAddress (String postCodeInput) {

        URI url = URI.create("https://viacep.com.br/ws/" + postCodeInput + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Address.class);
        } catch (Exception e) {
            throw new RuntimeException("Invalid PostCode [ " + postCodeInput + " ]: cannot possible to find the address with this input");
        }
    }
}
