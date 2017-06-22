package main;

/**
 * Classe de entrada da aplicacao, com menu
 *
 * @author Gabriel Rohden e Pedro Burguesan
 * @version 0.7
 * @since 1.0
 */
public class LojaDeVeiculos {

	public static void main(String[] args) {
		mainMenu();
	}

	/**
	 * Overload pra o mainMenu, sempre limpando o console .
	 * @see LojaDeVeiculos#mainMenu(boolean)
	 */
	public static void mainMenu() {
		mainMenu(true);
	}

	/** Pega uma escolha do usuario no menu inicial */
	public static int getUserChoiceForMainMenu() {
		//Podia usar um enum pra deixar mais dinamico
		System.out.println("1 - Adicionar veiculos");
        System.out.println("2 - Mostrar detalhes de um veiculo");
        System.out.println("3 - Mostrar veiculos não vendidos");
        System.out.println("4 - Vender veiculo");
        System.out.println("5 - Sair");

		System.out.print("Escolha uma opcao: ");

		return Utils.assureChoice(1,5);
	}

	/**
	 * Menu principal da aplicacao
	 * @param clearConsole se vai limpar o console antes de mostrar o menu
	 */
	public static void mainMenu(boolean clearConsole) {
		if (clearConsole) {
			Utils.clearConsole();
		}

		int choice = getUserChoiceForMainMenu();

		while (choice != 5) {
			switch (choice) {
				case 1:
					Sistema.addNewVehicle();
					break;
				case 2:
                    Sistema.showVehicleDetails();
                    break;
				case 3:
					Sistema.showNotSoldVehicles();
					break;
				case 4:
					Sistema.sellVehicle();
					break;
			}

			Utils.clearConsole();
			choice = getUserChoiceForMainMenu();
		}

		System.exit(1);
	}
}
