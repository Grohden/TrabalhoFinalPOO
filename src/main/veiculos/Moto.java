package main.veiculos;

import java.util.Calendar;

/**
 * Classe moto
 *
 * @author Gabriel Rohden
 * @version 1.2
 * @since 1.0
 */
public class Moto extends Veiculo {

    private boolean vendido = false;

    @Override
    public boolean estaVendido() {
        return vendido;
    }

    @Override
    public void vender() {
        vendido = true;
    }

    @Override
    public int getByConsoleQuantiadePortas() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - Ano %d, placa %s, valor %d, quilometragem %d, marca %s, %d marchas e %d cilindradas",
                this.getClass().getSimpleName(),
                super.getAnoFabricacao().get(Calendar.YEAR),
                super.getNumeroPlaca(),
                super.getValorDoVeiculo(),
                super.getQuilometragem(),
                super.getMarca().toString(),
                super.getNumeroDeMarchas(),
                super.getCilindradas()
        );
    }
}
