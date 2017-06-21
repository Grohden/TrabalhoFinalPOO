package main.veiculos;

public class Moto extends Veiculo {
	
	private boolean vendido = false;
	
	/**
	 * retorna o valor do carro
	 */
	@Override
	public long getValor()
	{
		return getValorDoVeiculo();
	}
	
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
