package main.veiculos;

public class Onibus extends Veiculo
{
	
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
