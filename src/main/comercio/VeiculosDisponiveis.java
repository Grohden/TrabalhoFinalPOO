package main.comercio;

import main.veiculos.Carro;
import main.veiculos.Moto;
import main.veiculos.Onibus;
import main.veiculos.Veiculo;

public enum VeiculosDisponiveis {
    CARRO(Carro.class),MOTO(Moto.class),ONIBUS(Onibus.class);

    private Class clazz;

    VeiculosDisponiveis(Class clazz){
        this.clazz = clazz;
    }

    public Veiculo getInstance() throws IllegalAccessException, InstantiationException, ClassCastException {
        return (Veiculo) clazz.newInstance();
    }

}
