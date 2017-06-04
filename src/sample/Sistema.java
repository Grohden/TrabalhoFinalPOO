package sample;

import sample.veiculos.ModeloVeiculo;
import sample.veiculos.Veiculo;
import sample.comercio.VeiculosDisponiveis;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by gabri on 03/06/2017.
 */
public class Sistema {
    private static Map<String, Veiculo> veiculosAVenda = new HashMap<String, Veiculo>();
    private static Map<Integer,ModeloVeiculo> modelos = new HashMap<Integer, ModeloVeiculo>();
    public static final PrintStream console = System.out;
    public static final Scanner reader = new Scanner(System.in);

    private Sistema(){}

    public static void limpaConsole(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {

        }
    }



    public static ModeloVeiculo addNovoModelo(){
        ModeloVeiculo novoModelo = new ModeloVeiculo();

        console.print("Nome: ");
        novoModelo.setNome(reader.next());

        console.print("Informe quantas portas o modelo vai ter: ");
        novoModelo.setQuantiadePortas(reader.nextInt());

        console.print("Informe quantas marchas: ");
        novoModelo.setNumeroDeMarchas(reader.nextInt());

        console.print("Informe quantidade de cilindradas: ");
        novoModelo.setCilindradas(reader.nextInt());

        modelos.put(modelos.size(), novoModelo);

        return novoModelo;
    }

    public static void listModelos(){
        if (modelos.isEmpty()){
            return;
        }

        for (Map.Entry<Integer, ModeloVeiculo> entry : modelos.entrySet()) {
            showModelo(entry.getValue());
            console.println("===================================");
        }
    }

    public static void showModelo(ModeloVeiculo modelo){
        String message = String.format(
                "Modelo %s, com %d portas, %d marchas e %d cilindradas",
                modelo.getNome(),
                modelo.getQuantiadePortas(),
                modelo.getNumeroDeMarchas(),
                modelo.getCilindradas()
        );
        console.println(message);
    }

    public static void listVeiculos(){
        if (veiculosAVenda.isEmpty()){
            return;
        }


        for (Map.Entry<String, Veiculo> entry : veiculosAVenda.entrySet()) {
            showVeiculo(entry.getValue());
            console.println("===================================");
        }
    }

    public static void showVeiculo(Veiculo veiculo){
        //todo
    }

    public static ModeloVeiculo getModeloPeloUsuario(){
        if(modelos.isEmpty()){
            console.println("Nao foi encontrado um modelo, cadastre um novo.");
            return addNovoModelo();
        }

        listModelos();
        console.print("Digite o numero do modelo:");
        int nrModelo = reader.nextInt();

        while(nrModelo > modelos.size() && nrModelo < 1){
            console.print("Numero invalido, digite novamente: ");
            nrModelo = reader.nextInt();
        }
        ModeloVeiculo escolhido = modelos.get(nrModelo - 1);

        console.println("Modelo escolhido: " + escolhido.getNome());

        return escolhido;
    }

    public static void addNovoVeiculo(){
        limpaConsole();

        Veiculo novoModelo;
        int choice = 0;
        VeiculosDisponiveis[] opcoesDisponiveis = VeiculosDisponiveis.values();

        console.println("Qual o tipo do veiculo? ");

        int count = -1;
        while(count++ < opcoesDisponiveis.length - 1){
            console.println(count + 1 + " - " + VeiculosDisponiveis.values()[count]);
        }

        choice = reader.nextInt();

        while(choice < 1 && choice > opcoesDisponiveis.length){
            console.println("Opcao invalida, digite novamente: ");
            choice = reader.nextInt();
        }

        try{
            novoModelo = opcoesDisponiveis[count - 1].getInstance();

            console.print("Placa: ");
            novoModelo.setNumeroPlaca(reader.next());

            console.print("Valor do veiculo: ");
            novoModelo.setValorDoVeiculo(reader.nextInt());

            //console.print("Ano de fabricacao");
            //novoModelo.setAnoFabricacao(reader.nex)

            //console.print("Quatidade de acentos");

            console.print("Cilindradas: ");
            novoModelo.setQuilometragem(reader.nextInt());

            novoModelo.setModelo(getModeloPeloUsuario());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void venderVeiculo() {
    }
}
