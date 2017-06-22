package main.veiculos;

/**
 * Enum que contem todas as marcas disponiveis na loja
 *
 * @author Pedro Burguesan
 * @version 1
 */
public enum Marca {
    FORD,
    FIAT,
    WOLKSVAGEM,
    BWM,
    KIA;


    /** Lista as marcas disponiveis no console */
    public static void listOnConsole(){
        for (int i = 0; i < values().length; i++) {
            System.out.println((i + 1) + " - " + values()[i].name());
        }
    }
}
