package main;

import java.io.IOException;
import java.util.*;

import main.veiculos.comercio.VeiculosDisponiveis;
import main.veiculos.ModeloVeiculo;
import main.veiculos.Veiculo;

public class Sistema {

    private static Map<String, Veiculo> vehiclesOnStore = new HashMap<>();
    private static List<ModeloVeiculo> vehiclesModel = new ArrayList<>();

    //So acessos estaticos ao sistema. (poderia ser tambem ou um singleton)
    private Sistema() {
    }


    /**
     * Adiciona um novo modelo de veiculo pelo usuario
     */
    public static ModeloVeiculo addNewVehicleModel() {
        ModeloVeiculo novoModelo = new ModeloVeiculo();

        novoModelo
                .setNome(novoModelo.getByConsoleNome())
                .setCilindradas(novoModelo.getByConsoleCilindradas())
                .setNumeroDeMarchas(novoModelo.getByConsoleNumeroDeMarchas())
                .setQuantiadePortas(novoModelo.getByConsoleQuantiadePortas());

        vehiclesModel.add(novoModelo);

        System.out.println("Modelo " + novoModelo.getNome() + " adicionado com sucesso");
        return novoModelo;
    }

    public static void listModelsToUser() {
        if (vehiclesModel.isEmpty()) {
            return;
        }

        vehiclesModel.forEach(modeloVeiculo -> {
            showModelToUser(modeloVeiculo);
            System.out.println("===================================");
        });
    }

    public static void showModelToUser(ModeloVeiculo modelo) {
        String message = String.format(
                "Modelo %s, com %d portas, %d marchas e %d cilindradas",
                modelo.getNome(),
                modelo.getQuantiadePortas(),
                modelo.getNumeroDeMarchas(),
                modelo.getCilindradas()
        );
        System.out.println(message);
    }

    public static void listVehiclesToUser() {
        if (vehiclesOnStore.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Veiculo> entry : vehiclesOnStore.entrySet()) {
            showVehicleToUser(entry.getValue());
            System.out.println("===================================");
        }
    }

    public static void showVehicleToUser(Veiculo veiculo) {
        String message = String.format(
                "%s - Modelo %s ano %d, da marca %s, placa %s, quilometragem %d, custando %d",
                veiculo.getClass().getSimpleName(),
                veiculo.getModelo().getNome(),
                veiculo.getAnoFabricacao().get(Calendar.YEAR),
                veiculo.getMarca(),
                veiculo.getNumeroPlaca(),
                veiculo.getQuilometragem(),
                veiculo.getValorDoVeiculo()
        );
        System.out.println(message);
    }

    public static ModeloVeiculo getModelByUser() {
        if (vehiclesModel.isEmpty()) {
            System.out.println("Nao foi encontrado um modelo, cadastre um novo.");
            return addNewVehicleModel();
        }

        listModelsToUser();

        System.out.print("Digite o numero do modelo:");

        int modelNumber = Utils.assureChoice(1, vehiclesModel.size());

        ModeloVeiculo chosen = vehiclesModel.get(modelNumber - 1);

        System.out.println("Modelo escolhido: " + chosen.getNome());

        return chosen;
    }


    /**
     * Adiciona um novo veiculo
     */
    public static void addNewVehicle() {
        Utils.clearConsole();

        Veiculo newModel;
        VeiculosDisponiveis[] avaliableOptions = VeiculosDisponiveis.values();

        System.out.println("Qual o tipo do veiculo? ");

        //Printa os tipos disponiveis
        int count = -1;
        while (count++ < avaliableOptions.length - 1) {
            System.out.println(count + 1 + " - " + VeiculosDisponiveis.values()[count]);
        }

        //assegura que a escolha esta no numero certo
        int choice = Utils.assureChoice(1, avaliableOptions.length);

        try {
            newModel = avaliableOptions[choice - 1].getInstance();

            newModel
                    .setNumeroPlaca(newModel.getByConsoleNumeroPlaca())
                    .setValorDoVeiculo(newModel.getByConsoleValorDoVeiculo())
                    .setQuilometragem(newModel.getByConsoleQuilometragem())
                    .setMarca(newModel.getByConsoleMarca())
                    .setModelo(getModelByUser());

            //Adiciona o veiculo na lista de veiculos
            vehiclesOnStore.put(newModel.getNumeroPlaca(), newModel);
            System.out.println("Veiculo adicionado com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar o veiculo");
        }
    }

    public static void sellVehicle() {

    }
}
