package main.veiculos;

/**
 * Created by gabri on 03/06/2017.
 * Classe de um carro
 */
public class Carro extends Veiculo
{
    private boolean vendido = false;
    
    public Carro()
    {
    }
    
    /**
     * retorna o valor do carro
     */
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
