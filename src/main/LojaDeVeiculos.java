package main;

public class LojaDeVeiculos {

    public static void main(String[] args) {
        mainMenu();
    }


    public static void mainMenu() {
        mainMenu(true);
    }
	
	public static int getUserChoiceForMainMenu()
	{
		//Podia usar um enum pra deixar mais dinamico
		System.out.println("1 - Adicionar veiculos");
		System.out.println("2 - Adicionar modelos");
		System.out.println("3 - Vender Veiculos");
		System.out.println("4 - Mostrar Veiculos");
		System.out.println("5 - Sair");
		
		System.out.print("Escolha uma opcao: ");
		int choice = Sistema.getReader().nextInt();
		
		while (choice < 1 || choice > 5)
		{
			System.out.print("Opcao invalida, digite novamente: ");
			choice = Sistema.getReader().nextInt();
		}
		
		return choice;
	}
	
	public static void mainMenu(boolean clearConsole)
	{
		if (clearConsole)
		{
			Sistema.clearConsole();
		}
		
		int choice = getUserChoiceForMainMenu();
		
		while (choice != 5)
		{
			switch (choice)
			{
				case 1:
					Sistema.addNewVehicle();
					break;
				case 2:
					Sistema.addNewVehicleModel();
					break;
				case 3:
					Sistema.sellVehicle();
					break;
				case 4:
					Sistema.listVehiclesToUser();
					break;
			}
			
			Sistema.clearConsole();
			choice = getUserChoiceForMainMenu();
		}
		
		System.exit(1);
	}
}
