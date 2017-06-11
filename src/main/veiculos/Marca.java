package main.veiculos;

public enum Marca {
    FORD,
    FIAT,
    WOLKSVAGEM,
    BWM,
    KIA;


    public static void listOnConsole(){
        for (int i = 0; i < values().length; i++) {
            System.out.println(i + " - " + values()[i].name());
        }
    }
}
