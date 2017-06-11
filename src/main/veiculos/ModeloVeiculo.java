package main.veiculos;

public class ModeloVeiculo extends ModeloAdicionavelPorConsole{
    private String nome;
    private int quantiadePortas;
    private int numeroDeMarchas;
    private int cilindradas;

    public String getNome() {
        return nome;
    }

    public ModeloVeiculo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ModeloVeiculo setQuantiadePortas(int quantiadePortas) {
        this.quantiadePortas = quantiadePortas;
        return this;
    }

    public ModeloVeiculo setNumeroDeMarchas(int numeroDeMarchas) {
        this.numeroDeMarchas = numeroDeMarchas;
        return this;
    }

    public ModeloVeiculo setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
        return this;
    }

    public int getQuantiadePortas() {
        return quantiadePortas;
    }

    public int getNumeroDeMarchas() {
        return numeroDeMarchas;
    }

    public int getCilindradas() {
        return cilindradas;
    }
}
