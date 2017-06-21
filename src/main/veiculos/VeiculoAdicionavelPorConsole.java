package main.veiculos;

import java.util.Calendar;
import java.util.Scanner;
import main.Utils;

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
	
	/**
	 * Requisita por console um numero de placa
	 * Sendo o ano valido se estiver entre 1800 e 3000
	 *
	 * @return Numero da placa
	 */
	public Calendar getByConsoleAnoFabricacao()
	{
		System.out.print("Informe o ano de fabricação do veiculo: ");
		Calendar year = Calendar.getInstance();
		int chosenYear = Utils.assureChoice(
			"O ano minimo para fabricação é 1800, e o maximo é 3000, digite novamente.",
			1876,
			3000
		);
		year.set(Calendar.YEAR, chosenYear);
		return year;
	}
	
	/**
	 * Requisita por console um numero de placa
	 * @return Numero da placa
	 */
	public String getByConsoleNumeroPlaca(){
		System.out.print("Informe a placa do veiculo: ");
		return getReader().next();
	}
	
	/**
	 * Requisita por console a marca do veiculo
	 * @return Marca do veiculo
	 */
	public Marca getByConsoleMarca()
    {
	    System.out.println("Escolha a marca do veiculo: ");

        Marca.listOnConsole();

        return Marca.values()[Utils.assureChoice(1, Marca.values().length) - 1];
    }
	
	/**
	 * Requisita por console a quilometragem
	 * @return Quilometragem do veiculo
	 */
	public long getByConsoleQuilometragem(){
        System.out.print("Informe a quilometragem do veiculo: ");
        return getReader().nextInt();
    }
	
	/**
	 * Requisita por console o valor
	 * @return Valor do veiculo
	 */
	public long getByConsoleValorDoVeiculo(){
        System.out.print("Informe o valor do veiculo: ");
        return getReader().nextInt();
    }

}
