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
	
	
	public void sumarContador(int segundoNumero) {		
		int total = this.getValor() + segundoNumero;
		this.setValor(total);		
	}
	
	
	public void restarContador(int segundoNumero) {
		int total = this.getValor() - segundoNumero;		
		this.setValor(total);
	}
	
	
	public void multiplicarContador(int segundoNumero) {
		int total = this.getValor() * segundoNumero;
		this.setValor(total);
	}
	
	
	public void dividirContador(int segundoNumero) throws NumberFormatException {
		if( segundoNumero == 0) {
			throw new NumberFormatException ("No se puede dividir por 0");
			
		} else {
			int total = this.getValor() / segundoNumero;
			this.setValor(total);
		}		
	}

	
	public void resultado(int acumulado) {
		
		int resultado = this.getValor() + acumulado;
		
		this.setValor(resultado);
	}
	
	
	public void clear(){
		this.setValor(0);
	}
}