package sample.veiculos;

import sample.comercio.VeiculoComercializavel;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by gabri on 03/06/2017.
 */
public class Carro extends Veiculo implements VeiculoComercializavel {
    private boolean vendido = false;

    public Carro(){
        Calendar ano = new GregorianCalendar(2001,1,1);

        ModeloVeiculo modelo = new ModeloVeiculo()
                .setCilindradas(200)
                .setNumeroDeMarchas(6)
                .setQuantiadePortas(4);

        this    .setAnoFabricacao(ano)
                .setNumeroPlaca("BXB2")
                .setMarca(Marca.BWM)
                .setModelo(modelo)
                .setQuilometragem(0)
                .setValorDoVeiculo(2000);
    }

    @Override
    public long getValor() {
        return getValorDoVeiculo();
    }

    @Override
    public boolean estaVendido() {
        return vendido;
    }

    @Override
    public void vender() {
        vendido = true ;
    }

}