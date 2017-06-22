package main.veiculos.comercio;

import main.veiculos.VeiculoAdicionavelPorConsole;

/**
 * Interface de veiculos comercializaveis
 */
public abstract class VeiculoComercializavel extends VeiculoAdicionavelPorConsole
{

    /** Deve retornar o valor do veiculo */
    public abstract long getValorDoVeiculo();

    /** Deve retornar se o veiculo esta vendido*/
    public abstract boolean estaVendido();

    /** Deve setar o estado de vendido para true */
    public abstract void vender();
}
