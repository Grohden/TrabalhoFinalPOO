package sample.comercio;

import sample.veiculos.Carro;
import sample.veiculos.Moto;
import sample.veiculos.Onibus;
import sample.veiculos.Veiculo;

/**
 * Created by gabri on 04/06/2017.
 */
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
