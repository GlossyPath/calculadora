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

	
	public void sumarContador(int segundaCifra) {	
		
		int total = this.getValor() + segundaCifra;
		this.setValor(total);		
	}
	
	
	public void restarContador(int segundaCifra) {
		
		int total = this.getValor() - segundaCifra;		
		this.setValor(total);
	}
	
	
	public void multiplicarContador(int segundaCifra) {
		int total = this.getValor() * segundaCifra;
		this.setValor(total);
	}
	
	
	public void dividirContador(int segundaCifra) throws NumberFormatException {
		if( segundaCifra == 0) {
			throw new NumberFormatException ("No se puede dividir por 0");
			
		} else {
			int total = this.getValor() / segundaCifra;
			this.setValor(total);
		}		
	}
	
	public void raizCuadradaContador(int valorActual) {
		int total = (int) Math.sqrt(valorActual);
		this.setValor(total);		
	}
	
	public int resultadoContador() {
		
		int resultado = this.getValor();
		
		this.setValor(resultado);
		
		return resultado;
	}
	
	
	public void clear(){
		this.setValor(0);
	}
}