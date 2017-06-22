package main.veiculos.comercio;

import main.veiculos.Carro;
import main.veiculos.Moto;
import main.veiculos.Onibus;
import main.veiculos.Veiculo;

/**
 * Enum que controla a as classes de veiculos disponiveis para a venda na loja
 * @author Gabriel Rohden
 */
public enum VeiculosDisponiveis {
    CARRO(Carro.class), MOTO(Moto.class), ONIBUS(Onibus.class);

    private Class clazz;

    /** @param clazz Classe do veiculo a ser instanciada quando nescessario*/
    VeiculosDisponiveis(Class clazz){
        this.clazz = clazz;
    }

    /** Retorna uma instancia do veiculo */
    public Veiculo getInstance() throws IllegalAccessException, InstantiationException, ClassCastException {
        return (Veiculo) clazz.newInstance();
    }

}
