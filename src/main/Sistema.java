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
		
		vehiclesModel.put(vehiclesModel.size(), novoModelo);

        return novoModelo;
    }
	
	public static void listModelsToUser()
	{
		if (vehiclesModel.isEmpty())
		{
			return;
        }
		
		for (Map.Entry<Integer, ModeloVeiculo> entry : vehiclesModel.entrySet())
		{
			showModelToUser(entry.getValue());
			System.out.println("===================================");
		}
    }
	
	public static void showModelToUser(ModeloVeiculo modelo)
	{
		String message = String.format(
                "Modelo %s, com %d portas, %d marchas e %d cilindradas",
                modelo.getNome(),
                modelo.getQuantiadePortas(),
                modelo.getNumeroDeMarchas(),
                modelo.getCilindradas()
        );
		System.out.println(message);
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
			veiculo.getClass().getName(),
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
	 * Adiciona um novo veiculo
	 */
	public static void addNewVehicle()
	{
		clearConsole();
		
		Veiculo newModel;
		int choice = 0;
		VeiculosDisponiveis[] avaliableOptions = VeiculosDisponiveis.values();
		
		System.out.println("Qual o tipo do veiculo? ");

        int count = -1;
		while (count++ < avaliableOptions.length - 1)
		{
			System.out.println(count + 1 + " - " + VeiculosDisponiveis.values()[count]);
		}
		
		choice = getReader().nextInt();
		
		while (choice < 1 && choice > avaliableOptions.length)
		{
			System.out.println("Opcao invalida, digite novamente: ");
			choice = getReader().nextInt();
		}

        try{
	        newModel = avaliableOptions[count - 1].getInstance();
	
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

        } catch (Exception e){
            e.printStackTrace();
        }
    }
	
	public static void sellVehicle()
	{
	}
}
