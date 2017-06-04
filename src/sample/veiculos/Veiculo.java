package sample.veiculos;

import java.util.Calendar;

/**
 * Created by Gabriel on 03/06/2017.
 */
public abstract class Veiculo {
    private Calendar anoFabricacao;
    private String numeroPlaca;
    private long valorDoVeiculo;
    private long quilometragem = 0;
    private Marca marca;
    private ModeloVeiculo modelo;

    public Veiculo(){

    }

    public Veiculo setModelo(ModeloVeiculo modelo) {
        this.modelo = modelo;
        return this;
    }

    public Veiculo setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
        return this;
    }

    public Veiculo setValorDoVeiculo(long valorDoVeiculo) {
        this.valorDoVeiculo = valorDoVeiculo;
        return this;
    }

    public Veiculo setAnoFabricacao(Calendar anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
        return this;
    }

    public Veiculo setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
        return this;
    }

    public Veiculo setMarca(Marca marca) {
        this.marca = marca;
        return this;
    }

    public Calendar getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public Marca getMarca() {
        return marca;
    }

    public ModeloVeiculo getModelo() {
        return modelo;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public long getValorDoVeiculo() {
        return valorDoVeiculo;
    }
}