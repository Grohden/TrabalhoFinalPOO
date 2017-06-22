package main.veiculos;

/**
 * Classe do onibus
 *
 * @author Gabriel Rohden
 * @version 1.0
 * @since 1.0
 */
public class Onibus extends Veiculo
{

    private boolean vendido = false;

    @Override
    public boolean estaVendido() {
        return vendido;
    }

    @Override
    public void vender() {
        vendido = true;
    }
}
