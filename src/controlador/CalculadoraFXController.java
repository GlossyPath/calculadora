package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import modelo.Contador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class CalculadoraFXController implements Initializable{
	@FXML
	private TextField tfContador;
	@FXML
	private Button btCero;
	@FXML
	private Button btIgual;
	@FXML
	private Button btClear;
	@FXML
	private Button btResta;
	@FXML
	private Button btUno;
	@FXML
	private Button btDos;
	@FXML
	private Button btTres;
	@FXML
	private Button btSuma;
	@FXML
	private Button btCuatro;
	@FXML
	private Button btCinco;
	@FXML
	private Button btSeis;
	@FXML
	private Button btMultiplicacion;
	@FXML
	private Button btSiete;
	@FXML
	private Button btOcho;
	@FXML
	private Button btnueve;
	@FXML
	private Button btDivision;
	
	private Contador contador;
	private String numero;
    private String operador;
    private String acumulado;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.contador = new Contador();	
		this.operador = "";
		this.numero = "";
		this.acumulado = "";
		
	}

	// Event Listener on Button[#btCero].onAction
	@FXML
	public void clickBoton(ActionEvent event) {
		
		Button btn = (Button) event.getSource();
		
		String btnTexto = btn.getText();
		
		if(operador.isEmpty()) {
			
			if((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/")) && this.numero.isEmpty()){
				
				this.numero = btnTexto;
				
				tfContador.setText(this.numero);
			
				this.acumulado = this.numero;
				
				contador.setValor(Integer.parseInt(this.acumulado));
				
			} else if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/")) && !this.acumulado.isEmpty()) {
				
				this.numero = btnTexto;
				
				this.acumulado += this.numero;
				tfContador.setText(this.acumulado);
				
				contador.setValor(Integer.parseInt(this.acumulado));
				
			}  else if (btnTexto.equals("+") || btnTexto.equals("-") || btnTexto.equals("*") || btnTexto.equals("/")) {
				
				operador = btnTexto;
				tfContador.setText(btnTexto);
				this.setAcumulado("");
			}
		} else {
			
			 if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/")) && !operador.isEmpty()) {
				 
				 
	             int segundoNumero = Integer.parseInt(btnTexto);
	             this.acumulado += btnTexto;
	             
	             
	         if(btnTexto.equals("+") || btnTexto.equals("-") || btnTexto.equals("*") || btnTexto.equals("/"))       
	                
	                switch (this.operador) {
	                    case "+":
	                    	contador.sumarContador(Integer.parseInt(this.acumulado));
	                    	break;
	                    	
	                    case "-":
	                        contador.restarContador(Integer.parseInt(this.acumulado));
	                        break;
	                        
	                    case "*":
	                        contador.multiplicarContador(Integer.parseInt(this.acumulado));
	                        break;
	                        
	                    case "/":
	                        try {
	                        	contador.dividirContador(Integer.parseInt(this.acumulado));
	                        } catch(NumberFormatException e) {
	                        	tfContador.setText("Error al dividir por 0");
	                        	e.printStackTrace();
	                        	
	                        }
	                        break;
	                }
	         		tfContador.setText(Integer.toString(contador.getValor()));
	                contador.setValor(contador.getValor());
	                this.operador = "";
			}
			
		}
		
		if(btnTexto.equals("CE")) {
			
			tfContador.clear();
			
			this.operador = "";
		}
		
		if(btnTexto.equals("=")) {
			
			int resultado = contador.getValor();
			
			tfContador.setText(Integer.toString(resultado));
			
			this.operador = "";
		}	
	}

	
	public String getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(String acumulado) {
		this.acumulado = acumulado;
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
