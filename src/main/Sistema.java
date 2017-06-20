package main;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import main.comercio.VeiculosDisponiveis;
import main.veiculos.ModeloVeiculo;
import main.veiculos.Veiculo;

public class Sistema {
	
	private static Map<String, Veiculo> vehiclesOnStore = new HashMap<>();
	private static Map<Integer, ModeloVeiculo> vehiclesModel = new HashMap<>();
	
	//So acessos estaticos ao sistema. (poderia ser tambem ou um singleton)
	private Sistema(){}
	
	public static Scanner getReader()
	{
		return new Scanner(System.in);
	}
	
	public static void clearConsole()
	{
		//Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {

        }
    }
	
	
	/**
	 * Adiciona um novo modelo de veiculo
	 */
	public static ModeloVeiculo addNewVehicleModel()
	{
		ModeloVeiculo novoModelo = new ModeloVeiculo();
		
		System.out.print("Nome: ");
		novoModelo.setNome(getReader().next());
		
		System.out.print("Informe quantas portas o modelo vai ter: ");
		int qt = getReader().nextInt();
		novoModelo.setQuantiadePortas(qt);
		
		System.out.print("Informe quantas marchas: ");
		novoModelo.setNumeroDeMarchas(getReader().nextInt());
		
		System.out.print("Informe quantidade de cilindradas: ");
		novoModelo.setCilindradas(getReader().nextInt());
		
		//Rever para a retirada, o modelo devia ser listado e procurado por nome
		vehiclesModel.put(vehiclesModel.size(), novoModelo);
		
		System.out.println("Modelo " + novoModelo.getNome() + " adicionado com sucesso");

        return novoModelo;
    }
	
	public static void listModelsToUser()
	{
		if (vehiclesModel.isEmpty())
		{
			return;
        }
		Object[] vehicles = vehiclesModel.values().toArray();
		
		for (int i = 0; i < vehicles.length; i++)
		{
			showModelToUser((ModeloVeiculo) vehicles[i], i + 1);
		}
		System.out.println("===================================");
	}
	
	public static void showModelToUser(ModeloVeiculo modelo)
	{
		showModelToUser(modelo, null);
	}
	
	/**
	 * Mostra um modelo para o usuario
	 *
	 * @param count Numero para mostrar na frente, opcional
	 * @param modelo Modelo para pegar as informações
	 */
	public static void showModelToUser(ModeloVeiculo modelo, Integer count)
	{
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
	
	public static void listVehiclesToUser()
	{
		if (vehiclesOnStore.isEmpty())
		{
			return;
        }
		
		for (Map.Entry<String, Veiculo> entry : vehiclesOnStore.entrySet())
		{
			showVehicleToUser(entry.getValue());
			System.out.println("===================================");
		}
    }
	
	public static void showVehicleToUser(Veiculo veiculo)
	{
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
	
	public static ModeloVeiculo getModelByUser()
	{
		if (vehiclesModel.isEmpty())
		{
			System.out.println("Nao foi encontrado um modelo, cadastre um novo.");
			return addNewVehicleModel();
		}
		
		listModelsToUser();
		
		System.out.print("Digite o numero do modelo:");
		int modelNumber = getReader().nextInt();
		
		while (modelNumber > vehiclesModel.size() && modelNumber < 1)
		{
			System.out.print("Numero invalido, digite novamente: ");
			modelNumber = getReader().nextInt();
		}
		
		ModeloVeiculo chosen = vehiclesModel.get(modelNumber - 1);
		
		System.out.println("Modelo escolhido: " + chosen.getNome());
		
		return chosen;
	}
	
	/**
	 * Garante que a escolha do usuario vai estar entre um range de numeros
	 *
	 * @param invalidMessage mensagem para quando o usuario errar
	 * @param minChoice numero minimo
	 * @param maxChoice numero maximo
	 * @param actualChoice escolha atual
	 */
	private static int assureChoice(String invalidMessage, int minChoice, int maxChoice,
		int actualChoice)
	{
		while (actualChoice < minChoice || actualChoice > maxChoice)
		{
			System.out.println(invalidMessage);
			actualChoice = getReader().nextInt();
		}
		
		return actualChoice;
	}
	
	private static int assureChoice(int minChoice, int maxChoice, int actualChoice)
	{
		return assureChoice("Opcao invalida, digite novamente: ", minChoice, maxChoice,
			actualChoice);
	}
	
	
	/**
	 * Adiciona um novo veiculo
	 */
	public static void addNewVehicle()
	{
		clearConsole();
		
		Veiculo newModel;
		VeiculosDisponiveis[] avaliableOptions = VeiculosDisponiveis.values();
		int choice = 0;
		
		System.out.println("Qual o tipo do veiculo? ");

        int count = -1;
		while (count++ < avaliableOptions.length - 1)
		{
			System.out.println(count + 1 + " - " + avaliableOptions[count]);
		}
		
		choice = getReader().nextInt();
		choice = assureChoice(1, avaliableOptions.length, choice);
		
		
        try{
	        newModel = avaliableOptions[choice - 1].getInstance();
	
	        System.out.print("Placa: ");
	        newModel.setNumeroPlaca(getReader().next());
	
	        System.out.print("Valor do veiculo: ");
	        newModel.setValorDoVeiculo(getReader().nextInt());
	
	        //System.out.print("Ano de fabricacao");
	        //novoModelo.setAnoFabricacao(reader.nex)
	
	        //System.out.print("Quatidade de acentos");
	
	        System.out.print("Cilindradas: ");
	        newModel.setQuilometragem(getReader().nextInt());
	
	        newModel.setModelo(getModelByUser());
	
	        vehiclesOnStore.put(newModel.getNumeroPlaca(), newModel);
	
	        System.out.println("Veiculo adicionado com sucesso");
	
        } catch (Exception e){
            e.printStackTrace();
        }
    }
	
	public static void sellVehicle()
	{
	}
}
