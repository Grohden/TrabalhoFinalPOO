package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import main.veiculos.ModeloVeiculo;
import main.veiculos.Veiculo;
import main.veiculos.comercio.VeiculosDisponiveis;

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
     * Lista todos os modelos de veiculos cadastrados na memoria
     * com contador para o usuario
     */
    public static void listModelsToUser() {
        if (vehiclesModel.isEmpty()) {
            return;
        }
	
	    for (int i = 0; i < vehiclesModel.size(); i++)
	    {
		    showModelToUser(vehiclesModel.get(i), i + 1);
	    }
    }
	
	/**
	 * Mostra um modelo para o usuario sem contador
	 *
	 * @param modelo Modelo para retirar as informações
	 */
	public static void showModelToUser(ModeloVeiculo modelo)
	{
		showModelToUser(modelo, null);
	}
	
	/**
     * Mostra um modelo para o usuario
     * @param modelo Modelo para retirar as informações
     * @param count contador para mostrar como label, se for null não é mostrado.
     */
    public static void showModelToUser(ModeloVeiculo modelo, Integer count) {
        String message = String.format(
                "Modelo %s, com %d portas, %d marchas e %d cilindradas",
                modelo.getNome(),
                modelo.getQuantiadePortas(),
                modelo.getNumeroDeMarchas(),
                modelo.getCilindradas()
        );
	
	    if (count != null)
	    {
		    System.out.println(count + " - " + message);
	    }
	    else
	    {
		    System.out.println(message);
	    }
    }
	
	/**
	 * Lista os veiculos na loja para o usuario com contador
	 */
	public static void listVehiclesOnStoreToUser()
	{
		listVehiclesToUser(vehiclesOnStore);
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
		
		if (count != null)
		{
			System.out.println(count + " " + message);
		}
		else
		{
			System.out.println(message);
		}
	}
	
	/**
	 * Pega uma instancia de modelo de veiculo por console
	 * Se a instancia não existir na lista de modelos, adicionar pelo usuario
	 */
	public static ModeloVeiculo getModelByUser()
	{
		if (vehiclesModel.isEmpty())
		{
			System.out.println("Nao foi encontrado um modelo de veiculo, cadastre um novo.");
			return addNewVehicleModel();
		}
		
		System.out.println("Escolha o modelo do veiculo:");
		listModelsToUser();
		System.out.println(vehiclesModel.size() + 1 + " - Adicionar um novo modelo");
		
		int modelNumber = Utils.assureChoice(1, vehiclesModel.size() + 1);
		ModeloVeiculo chosen;
		
		//Se escolheu adicionar
		if (modelNumber == vehiclesModel.size() + 1)
		{
			chosen = addNewVehicleModel();
		}
		else
		{
			chosen = vehiclesModel.get(modelNumber - 1);
		}
		
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
			    .setAnoFabricacao(newModel.getByConsoleAnoFabricacao())
			    .setQuilometragem(newModel.getByConsoleQuilometragem())
			    .setMarca(newModel.getByConsoleMarca())
			    .setModelo(getModelByUser());
		
		    //Adiciona o veiculo na lista de veiculos
		    vehiclesOnStore.put(newModel.getNumeroPlaca(), newModel);
		    System.out.println("Veiculo adicionado com sucesso.");
		
	    } catch (Exception e)
	    {
		    e.printStackTrace();
		    System.out.println("Erro ao adicionar o veiculo.");
	    }
    }
	
	public static void sellVehicle()
	{
		if (vehiclesOnStore.size() < 1)
		{
			System.out.println("Não ha veiculos na loja.");
			return;
		}
		
		listVehiclesToUser(vehiclesOnStore);
		
		System.out.print("Informe a placa do veiculo:");
		String str = Utils.getReader().next();
		
		try
		{
			Veiculo veiculo = vehiclesOnStore.get(str);
			
		} catch (Exception e){
		
		}
		
		vehiclesOnStore.get("");
		
	}
}
