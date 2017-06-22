package main;

import main.veiculos.Marca;
import main.veiculos.Veiculo;
import main.veiculos.comercio.VeiculosDisponiveis;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Singleton do sistema, onde é feito o gerenciamento dos veiculos
 *
 * @author Gabriel Rohden e Pedro Burguesan
 */
public class Sistema {
    private static Map<String, Veiculo> vehiclesOnStore = new LinkedHashMap<>();

    private Sistema() {
    }

    /**
     * Lista um map de veiculos para o usuario com contador
     */
    public static void listVehiclesToUser(Map<String, Veiculo> vehiclesList) {
        if (vehiclesList.isEmpty()) {
            System.out.println("Não foram achados os veiculos pelo criterio do filtro");
        } else {
            Object[] veiculos = vehiclesList.values().toArray();
            for (int i = 0; i < veiculos.length; i++) {
                showVehicleToUser((Veiculo) veiculos[i], i + 1);
            }
        }
        Utils.waitForAnyKey();
    }

    /**
     * Lista um veiculo para o usuario
     *
     * @param veiculo Veiculo para retirar as informações
     * @param count   contador para mostrar na frente (nullavel)
     */
    public static void showVehicleToUser(Veiculo veiculo, Integer count) {
        if (count != null) {
            System.out.println(count + " " + veiculo.toString());
        } else {
            System.out.println(veiculo.toString());
        }
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
                    .setAnoFabricacao(newModel.getByConsoleAnoFabricacao())
                    .setQuilometragem(newModel.getByConsoleQuilometragem())
                    .setMarca(newModel.getByConsoleMarca())
                    .setCilindradas(newModel.getByConsoleCilindradas())
                    .setNumeroDeMarchas(newModel.getByConsoleNumeroDeMarchas())
                    .setQuantiadePortas(newModel.getByConsoleQuantiadePortas());

            //Adiciona o veiculo na lista de veiculos
            vehiclesOnStore.put(newModel.getNumeroPlaca(), newModel);
            System.out.println("Veiculo adicionado com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar o veiculo.");
        }
    }

    /**
     * Vende um veiculo (caso haja na loja) pedindo a placa para o usuario.
     */
    public static void sellVehicle() {
        if (vehiclesOnStore.size() < 1) {
            System.out.println("Não ha veiculos na loja.");
            Utils.waitForAnyKey();
            return;
        }

        //showNotSoldVehicles();

        Veiculo veiculo = getVehicleByPlate();

        if (veiculo != null) {
            veiculo.vender();
            System.out.println("Veiculo vendido com sucesso.");
        } else {
            System.out.println("A placa informada não existe no sistema.");
        }

        Utils.waitForAnyKey();
    }

    /**
     * Pega um veiculo por placa (pode retornar null!)
     */
    public static Veiculo getVehicleByPlate() {
        System.out.print("Informe a placa do veiculo:");
        return vehiclesOnStore.get(Utils.getReader().next());
    }

    /**
     * Mostra os detalhes de um veiculo pegando uma placa informada por usuario
     */
    public static void showVehicleDetails() {
        Veiculo v = getVehicleByPlate();

        if (v != null) {
            System.out.println(v.toString());
        } else {
            System.out.println("A placa informada não existe no sistema.");
        }

        Utils.waitForAnyKey();
    }


    /**
     * Filtra os veiculos não vendidos
     *
     * @return um map de veiculos com a key sendo a placa
     */
    public static Map<String, Veiculo> filterNotSoldVehicles() {
        return vehiclesOnStore
                .entrySet()
                .stream()
                .filter(map -> !map.getValue().estaVendido())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Filtra os veiculos por ano
     *
     * @param year ano de fabricacao para o filtro
     * @return um map de veiculos com a key sendo a placa
     */
    public static Map<String, Veiculo> filterByYear(int year) {
        return vehiclesOnStore
                .entrySet()
                .stream()
                .filter(map -> map.getValue().getAnoFabricacao().get(Calendar.YEAR) == year)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

//    public void filterByModel() {
//        return vehiclesOnStore
//                .entrySet()
//                .stream()
//                .filter(map -> map.getValue().getQuilometragem() == quilometragem)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//    }


    /**
     * Filtra os veiculos por marca
     *
     * @param marca marca para o filtro
     * @return um map de veiculos com a key sendo a placa
     */
    public static Map<String, Veiculo> filterByMarca(Marca marca) {
        return vehiclesOnStore
                .entrySet()
                .stream()
                .filter(map -> map.getValue().getMarca() == marca)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }


    /**
     * Filtra os veiculos por quilometragem
     *
     * @param quilometragem quilometragem
     * @return um map de veiculos com a key sendo a placa
     */
    public static Map<String, Veiculo> filterByQuilometragem(long quilometragem) {
        return vehiclesOnStore
                .entrySet()
                .stream()
                .filter(map -> map.getValue().getQuilometragem() == quilometragem)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
