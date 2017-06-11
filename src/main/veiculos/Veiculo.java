package main.veiculos;

import main.Sistema;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Classe base para veiculos
 * @author Gabriel Rohden
 * @version 0.2
 * @since 10/06/2017
 */
public abstract class Veiculo extends VeiculoAdicionavelPorConsole {
    private Calendar anoFabricacao;
    private String numeroPlaca;
    private long valorDoVeiculo;
    private long quilometragem = 0;
    private Marca marca;
    private ModeloVeiculo modelo;

    /**
     * Instancia da classe base para veiculos
     */
    public Veiculo() {

    }

    /**
     * Seta o modelo do veiculo
     *
     * @param modelo modelo do veiculo
     * @return a instancia do objeto para 'chain sets'
     * @see main.veiculos.ModeloVeiculo
     */
    public Veiculo setModelo(ModeloVeiculo modelo) {
        this.modelo = modelo;
        return this;
    }

    /**
     * Seta a quantidade de quilometros rodados pelo veiculo
     *
     * @param quilometragem quilometragem rodada.
     * @return a instancia do objeto para 'chain sets'
     */
    public Veiculo setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
        return this;
    }

    /**
     * Seta o valor do veiculo
     *
     * @param valorDoVeiculo valor em reais do veiculo
     * @return a instancia do objeto para 'chain sets'
     */
    public Veiculo setValorDoVeiculo(long valorDoVeiculo) {
        this.valorDoVeiculo = valorDoVeiculo;
        return this;
    }

    /**
     * Seta o ano de fabricacao do veiculo
     *
     * @param anoFabricacao instancia do calendar com o ano de fabricacao
     * @return a instancia do objeto para 'chain sets'
     */
    public Veiculo setAnoFabricacao(Calendar anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
        return this;
    }

    /**
     * Seta o numero da placa do veiculo, para posterior identificacao
     *
     * @param numeroPlaca numero da placa do veiculo
     * @return a instancia do objeto para 'chain sets'
     */
    public Veiculo setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
        return this;
    }

    /**
     * Seta a marca do veiculo
     *
     * @param marca Marca do veiculo
     * @return a instancia do objeto para 'chain sets'
     * @see main.veiculos.Marca
     */
    public Veiculo setMarca(Marca marca) {
        this.marca = marca;
        return this;
    }

    /**
     * @return o modelo do veiculo
     * @see main.veiculos.ModeloVeiculo
     */
    public ModeloVeiculo getModelo() {
        return modelo;
    }

    /**
     * @return o ano de fabricacao do veiculo
     */
    public Calendar getAnoFabricacao() {
        return anoFabricacao;
    }

    /**
     * @return o numero da placa registrado
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * @return a marca do modelo
     * @see main.veiculos.Marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @return a quilometragem rodada pelo veiculo
     */
    public long getQuilometragem() {
        return quilometragem;
    }

    /**
     * @return O valor do veiculo
     */
    public long getValorDoVeiculo() {
        return valorDoVeiculo;
    }
}