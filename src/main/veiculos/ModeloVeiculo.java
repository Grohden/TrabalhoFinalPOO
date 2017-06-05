package main.veiculos;

public class ModeloVeiculo {
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

    public int getQuantiadePortas() {
        return quantiadePortas;
    }

    public ModeloVeiculo setQuantiadePortas(int quantiadePortas) {
        this.quantiadePortas = quantiadePortas;
        return this;
    }

    public int getNumeroDeMarchas() {
        return numeroDeMarchas;
    }

    public ModeloVeiculo setNumeroDeMarchas(int numeroDeMarchas) {
        this.numeroDeMarchas = numeroDeMarchas;
        return this;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public ModeloVeiculo setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
        return this;
    }
}
