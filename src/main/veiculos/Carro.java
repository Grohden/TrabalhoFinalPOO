package main.veiculos;

/**
 * Classe de um carro
 * @author Gabriel Rohden
 * @version 1.0
 * @since 1.0
 */
public class Carro extends Veiculo
{
    private boolean vendido = false;
    
    public Carro()
    {
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
