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

	
	public void resultadoContador(int segundaCifra) {
		
		int resultado = this.getValor() + segundaCifra;
		
		this.setValor(resultado);
	}
	
	
	public void clear(){
		this.setValor(0);
	}
}