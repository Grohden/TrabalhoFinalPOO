package main.veiculos;

import java.util.Calendar;

import main.veiculos.comercio.ItemDeVenda;

/**
 * Classe base para veiculos
 * @author Gabriel Rohden
 * @version 0.2
 * @since 10/06/2017
 */
public abstract class Veiculo extends ItemDeVenda
{
    private Calendar anoFabricacao;
    private String numeroPlaca;
    private long valorDoVeiculo;
    private long quilometragem;
    private Marca marca;
    private int quantiadePortas;
    private int numeroDeMarchas;
    private int cilindradas;

    /**
     * Seta a quantidade de portas do veiculo
     *
     * @param quantiadePortas quantidade de portas do veiculo.
     * @return a instancia do objeto para 'chain sets'
     */
    public Veiculo setQuantiadePortas(int quantiadePortas) {
        this.quantiadePortas = quantiadePortas;
        return this;
    }

    /**
     * Seta a quantidade de marchas do veiculo
     *
     * @param numeroDeMarchas numero de marchas do veiculo.
     * @return a instancia do objeto para 'chain sets'
     */
    public Veiculo setNumeroDeMarchas(int numeroDeMarchas) {
        this.numeroDeMarchas = numeroDeMarchas;
        return this;
    }

    /**
     * Seta a quantidade de cilindradas do veiculo
     *
     * @param cilindradas cilindradas do veiculo.
     * @return a instancia do objeto para 'chain sets'
     */
    public Veiculo setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
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

    /**
     * @return A quantidade de portas do veiculo
     */
    public int getQuantiadePortas() {
        return quantiadePortas;
    }

    /**
     * @return O numero de marchas do veiculo
     */
    public int getNumeroDeMarchas() {
        return numeroDeMarchas;
    }

    /**
     * @return A quantidade de cilindradas do veiculo
     */
    public int getCilindradas() {
        return cilindradas;
    }

    /**
     * Formato legivel do veiculo, com as informações do mesmo
     */
    @Override
    public String toString() {
        return String.format(
                "%s - Ano %d, placa %s, valor %d, quilometragem %d, marca %s, %d portas, %d marchas e %d cilindradas",
                this.getClass().getSimpleName(),
                this.anoFabricacao.get(Calendar.YEAR),
                this.numeroPlaca,
                this.valorDoVeiculo,
                this.quilometragem,
                this.marca.toString(),
                this.quantiadePortas,
                this.numeroDeMarchas,
                this.cilindradas
        );
    }


}