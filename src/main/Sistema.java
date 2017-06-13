package main;

import main.veiculos.ModeloVeiculo;
import main.veiculos.Veiculo;
import main.veiculos.comercio.VeiculosDisponiveis;

import java.util.*;

/**
 * Singleton do sistema, onde é feito o gerenciamento dos veiculos
 */
public class Sistema {
    private static Map<String, Veiculo> vehiclesOnStore = new LinkedHashMap<>();
    private static List<ModeloVeiculo> vehiclesModel = new ArrayList<>();

    private Sistema() {}


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

    /**
     * Lista os modelos de veiculos com contador para o usuario
     */
    public static void listModelsToUser() {
        if (vehiclesModel.isEmpty()) {
            return;
        }

        int count = 1;
        for (ModeloVeiculo aVehiclesModel : vehiclesModel) {
            System.out.print(count);
            showModelToUser(aVehiclesModel);

        }
    }

    /**
     * Mostra um modelo para o usuario
     */
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

    /** Lista os veiculos para o usuario com contador*/
    public static void listVehiclesToUser() {
        if (vehiclesOnStore.isEmpty()) {
            return;
        }

//        TODO
        for (int i=0; i < vehiclesOnStore.size(); i++) {
            //showVehicleToUser(vehiclesOnStore);
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
        System.out.print("Informe a placa do veiculo:");
        String str = Utils.getReader().next();

        try{

        } catch (Exception e){

        }

        vehiclesOnStore.get("");

    }
}
