package main.veiculos;

import main.Utils;

/**
 * Created by gabri on 10/06/2017.
 */
public abstract class ModeloAdicionavelPorConsole {

    public String getByConsoleNome() {
        System.out.print("Informe o nome do modelo: ");
        return Utils.getReader().next();
    }

    public int getByConsoleNumeroDeMarchas() {
        System.out.print("Informe quantas marchas o modelo tem: ");
        return Utils.getReader().nextInt();
    }

    public int getByConsoleCilindradas() {
        System.out.print("Informe quantidade de cilindradas do modelo: ");
        return Utils.getReader().nextInt();

    }

    public int getByConsoleQuantiadePortas() {
        System.out.print("Informe quantas portas o modelo vai ter: ");
        return Utils.getReader().nextInt();
    }
}
