package main;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe de utils da loja de veiculos
 * @author Gabriel Rohden
 * @since 1.0
 */
public class Utils {

    public static Scanner getReader() {
        return new Scanner(System.in);
    }

    /**
     * Limpa o console no windows ou mac (não funciona em certos consoles integrados em IDE'S)
     */
    public static void clearConsole() {
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
     * Espera uma key aleatoria do usuario
     */
    public static void waitForAnyKey()
	{
		try
		{
			System.out.print("Aperte qualquer tecla para continuar...");
			System.in.read();
		}
		catch (IOException ignored)
		{
		
		}
	}

    /**
     * Garante que a escolha do usuario vai estar entre um range de numeros
     *
     * @param invalidMessage mensagem para quando o usuario errar
     * @param minChoice      numero minimo
     * @param maxChoice      numero maximo
     * @return o numero valido escolhido
     */
    public static int assureChoice(String invalidMessage, int minChoice, int maxChoice) {
        int actualChoice = getReader().nextInt();
	    while (actualChoice < minChoice || actualChoice > maxChoice)
	    {
		    System.out.print(invalidMessage);
		    actualChoice = getReader().nextInt();
        }

        return actualChoice;
    }

    public static int assureChoice(int minChoice, int maxChoice) {
        return assureChoice("Opcao invalida, digite novamente: ", minChoice, maxChoice);
    }
}
