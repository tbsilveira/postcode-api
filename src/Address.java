public record Address (String cep, String logradouro, String complemento,
                       String bairro, String localidade, String uf) {

    @Override
    public String toString() {
        return "\n*** Full address ***" +
                "\nPost Code: " + cep +
                "\nStreet/Av: " + logradouro +
                "\nComplement: " + complemento +
                "\nNeighborhood: " + bairro +
                "\nCity: " + localidade +
                "\nState: " + uf;
    }
}
