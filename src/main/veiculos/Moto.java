package main.veiculos;

public class Moto extends Veiculo {
	
	private boolean vendido = false;
	
	@Override
	public boolean estaVendido()
	{
		return vendido;
	}
	
	@Override
	public void vender()
	{
		vendido = true;
	}
}
