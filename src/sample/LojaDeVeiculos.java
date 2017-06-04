package sample;

public class LojaDeVeiculos {

    public static void main(String[] args) {
        mainMenu();
    }


    public static void mainMenu() {
        mainMenu(true);
    }

    public static void mainMenu(boolean cleanConsole) {
        if (cleanConsole) {
            Sistema.limpaConsole();
        }

        Sistema.console.println("1 - Adicionar veiculos");
        Sistema.console.println("2 - Adicionar modelos");
        Sistema.console.println("3 - Vender Veiculos");
        Sistema.console.println("4 - Mostrar Veiculos");
        Sistema.console.println("5 - Sair");

        Sistema.console.print("Escolha uma opcao: ");
        int escolha = Sistema.reader.nextInt();

        while (escolha < 1 || escolha > 5) {
            Sistema.console.print("Opcao invalida, digite novamente: ");
            escolha = Sistema.reader.nextInt();
        }


        switch (escolha) {
            case 1:
                Sistema.addNovoVeiculo();
                break;
            case 2:
                Sistema.addNovoModelo();
                break;
            case 3:
                Sistema.venderVeiculo();
                break;
            case 4:
                Sistema.listVeiculos();
                break;
            case 5:
                System.exit(1);
                break;
        }

        mainMenu();
    }
}
