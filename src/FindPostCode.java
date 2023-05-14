import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class FindPostCode {
    public Address findAddress (String cep) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter a POSTCODE to find the full address:");
        String cepInput = input.nextLine();

        URI url = URI.create("https://viacep.com.br/ws/" + cepInput + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Invalid input: cannot possible to find the address with this input");
        }

        return new Gson().fromJson(response.body(), Address.class);
    }

}
