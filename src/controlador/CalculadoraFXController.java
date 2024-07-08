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
	private int numero;
	private int acumulado;
    private String operador;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.contador = new Contador();	
		this.acumulado = 0;
		this.operador = "";
		this.numero = 0;
		
	}

	// Event Listener on Button[#btCero].onAction
	@FXML
	public void clickBoton(ActionEvent event) {
		
		Button btn = (Button) event.getSource();
		
		String btnTexto = btn.getText();
		
		if(operador.isEmpty()) {
			
			if(btnTexto.matches("\\d")){
				
				this.numero = Integer.parseInt(btnTexto);
				
				
				tfContador.setText(Integer.toString(this.numero));
				contador.setValor(this.numero);
				this.acumulado = this.numero;
				
			}  else if (btnTexto.equals("+") || btnTexto.equals("-") || btnTexto.equals("*") || btnTexto.equals("/")) {
				
				operador = btnTexto;
				tfContador.setText(btnTexto);
			}
		} else {
			
			 if (btnTexto.matches("\\d")) {
				 
	                int segundoNumero = Integer.parseInt(btnTexto);
	                
	                switch (this.operador) {
	                    case "+":
	                    	contador.sumarContador(segundoNumero);
	                    	break;
	                    	
	                    case "-":
	                        contador.restarContador(segundoNumero);
	                        break;
	                        
	                    case "*":
	                        contador.multiplicarContador(segundoNumero);
	                        break;
	                        
	                    case "/":
	                        try {
	                        	contador.dividirContador(segundoNumero);
	                        } catch(NumberFormatException e) {
	                        	e.printStackTrace();
	                        	tfContador.setText("Error al dividir por 0");
	                        }
	                        break;
	                }
	                tfContador.setText(Integer.toString(segundoNumero));
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
