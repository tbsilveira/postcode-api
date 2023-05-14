import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        FindPostCode findPostCode = new FindPostCode();

        System.out.println("\nPlease, enter a POSTCODE to find the full address:");
        var cepInput = input.nextLine();
        String complement = "";
        String regexCep = "^[0-9]{5}-[0-9]{3}$";

        try {
            Address address = findPostCode.findAddress(cepInput);
            if(address.cep().matches(regexCep)) {
                System.out.println("""
                        \nGreat! It's a valid Post Code!
                        Please, inform the address complements (number, door, floor, etc)...""");
                complement = input.nextLine();
            }
            Address newAddress = new Address(address.cep(), address.logradouro(), complement, address.bairro(), address.localidade(), address.uf());

            System.out.println(newAddress);
            FileCreator creator = new FileCreator();
            creator.jsonCreator(newAddress);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Closing application...");
        }
    }
}

