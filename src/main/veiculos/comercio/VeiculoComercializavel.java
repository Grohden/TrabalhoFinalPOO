package main.veiculos.comercio;

/** Interface de veiculos comercializaveis*/
public interface VeiculoComercializavel {

    /** Deve retornar o valor do veiculo */
    long getValor();

    /** Deve retornar se o veiculo esta vendido*/
    boolean estaVendido();

    /** Deve setar o estado de vendido para true */
    void vender();
}
