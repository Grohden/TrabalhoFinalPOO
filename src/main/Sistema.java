package main;

import main.veiculos.Veiculo;
import main.veiculos.comercio.VeiculosDisponiveis;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Singleton do sistema, onde é feito o gerenciamento dos veiculos
 * @author Gabriel Rohden e Pedro Burguesan
 */
public class Sistema {
    private static Map<String, Veiculo> vehiclesOnStore = new LinkedHashMap<>();

    private Sistema() {}


	/**
	 * Lista os veiculos na loja para o usuario com contador
	 */
	public static void listVehiclesOnStoreToUser()
	{
		if (vehiclesOnStore.size() < 1)
		{
			System.out.println("Não há veiculos na loja.");
		}
		else
		{
			listVehiclesToUser(vehiclesOnStore);
		}
		
		Utils.waitForAnyKey();
	}
	
	/**
	 * Lista um map de veiculos para o usuario com contador
	 */
	public static void listVehiclesToUser(Map<String, Veiculo> vehiclesList)
	{
		if (vehiclesList.isEmpty()) {
			return;
		}
		
		Object[] veiculos = vehiclesList.values().toArray();
		for (int i = 0; i < veiculos.length; i++)
		{
			showVehicleToUser((Veiculo) veiculos[i], i + 1);
		}
	}
	
	/**
	 * Lista um veiculo para o usuario
	 *
	 * @param veiculo Veiculo para retirar as informações
	 * @param count contador para mostrar na frente (nullavel)
	 */
	public static void showVehicleToUser(Veiculo veiculo, Integer count) {
		if (count != null)
		{
            System.out.println(count + " " + veiculo.toString());
        }
		else
		{
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
		
	    } catch (Exception e)
	    {
		    e.printStackTrace();
		    System.out.println("Erro ao adicionar o veiculo.");
	    }
    }

    /**
     * Vende um veiculo (caso haja na loja) pedindo a placa para o usuario.
     */
    public static void sellVehicle()
	{
		if (vehiclesOnStore.size() < 1)
		{
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
     * Mostra os veiculos nào vendidos ao usuario (caso haja algum na loja)
     */
    public static void showNotSoldVehicles() {
        //FIXME: REDUZIR A COMPLEXIDADE DE RETURNS DISSO!
        if (vehiclesOnStore.isEmpty()) {
            System.out.println("Não há veiculos na loja.");
            Utils.waitForAnyKey();
            return;
        }

        Object[] notSoldVehicles =
                vehiclesOnStore
                        .entrySet()
                        .stream()
                        .filter(map -> !map.getValue().estaVendido())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                        .values()
                        .toArray();

        if (notSoldVehicles.length < 1) {
            System.out.println("Todos os veiculos da loja ja foram vendidos");
            Utils.waitForAnyKey();
            return;
        }

        for (int i = 0; i < notSoldVehicles.length; i++) {
            showVehicleToUser((Veiculo) notSoldVehicles[i], i + 1);
        }
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
}
