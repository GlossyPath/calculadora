package modelo;

public class Contador {

	private int valor;
	
	public Contador() {
		
		this.valor = 0;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void sumarContador(int valor) {
		
		this.valor += valor;
	}
	
	
	
}
