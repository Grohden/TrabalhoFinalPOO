package main;

import main.veiculos.Marca;
import main.veiculos.Veiculo;
import main.veiculos.VeiculoAdicionavelPorConsole;

import java.util.Calendar;
import java.util.Map;

import static main.LojaDeVeiculos.filterMenu;

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
        System.out.println("3 - Listar veiculos por filtro");
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
                    filterMenu();
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

    /**
     * Menu dos filtros
     */
    public static void filterMenu() {
        System.out.println("1 - Mostrar por ano");
        System.out.println("2 - Mostrar por marca");
        System.out.println("3 - Mostrar por quilometragem");
        System.out.println("4 - Mostrar veiculos não vendidos");
        System.out.println("5 - Voltar");

        System.out.print("Escolha uma opcao: ");

        Map<String, Veiculo> filtrados = null;
        int choice = Utils.assureChoice(1, 5);

        while (choice != 5) {
            switch (choice) {
                case 1:
                    System.out.print("Informe o ano para o filtro: ");
                    int chosenYear = Utils.assureChoice(1, Integer.MAX_VALUE);
                    filtrados = Sistema.filterByYear(chosenYear);
                    break;
                case 2:
                    System.out.println("Informe a marca do veiculo para o filtro: ");
                    Marca.listOnConsole();
                    filtrados = Sistema.filterByMarca(Marca.values()[Utils.assureChoice(1, Marca.values().length) - 1]);
                    break;
                case 3:
                    System.out.print("Informe a quilometragem do veiculo para o filtro: ");
                    filtrados = Sistema.filterByQuilometragem(Utils.getReader().nextInt());
                    break;
                case 4:
                    filtrados = Sistema.filterNotSoldVehicles();
                    break;
            }

            if (filtrados != null) {
                Sistema.listVehiclesToUser(filtrados);
            } else {
                System.out.println("Não foram encontrados veiculos pelo criterio do filtro");
            }

            Utils.clearConsole();
        }
    }
}
