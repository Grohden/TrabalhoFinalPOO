package main.veiculos;

import main.Utils;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by gabri on 10/06/2017.
 */
public abstract class VeiculoAdicionavelPorConsole {

    protected Scanner getReader()
    {
        return new Scanner(System.in);
    }

    public ModeloVeiculo getByConsoleModelo(){
        return null;
    }

    public Calendar getByConsoleAnoFabricacao(){
        System.out.print("Informe a placa do veiculo: ");
        Calendar year = Calendar.getInstance();
        year.set(Calendar.YEAR, getReader().nextInt());
        return year;
    }

    public String getByConsoleNumeroPlaca(){
        System.out.print("Informe a placa do veiculo: ");
        return getReader().next();
    }

    public Marca getByConsoleMarca(){
        System.out.print("Escolha a marca do veiculo: ");

        Marca.listOnConsole();

        return Marca.values()[Utils.assureChoice(1, Marca.values().length) - 1];
    }

    public long getByConsoleQuilometragem(){
        System.out.print("Informe a quilometragem do veiculo: ");
        return getReader().nextInt();
    }

    public long getByConsoleValorDoVeiculo(){
        System.out.print("Informe o valor do veiculo: ");
        return getReader().nextInt();
    }

}
