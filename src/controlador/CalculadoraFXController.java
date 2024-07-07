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
		this.acumulado = contador.getValor();
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
				this.acumulado = this.numero;
				
				tfContador.setText(Integer.toString(this.acumulado));
				
			}  else if (btnTexto.equals("+") || btnTexto.equals("-") || btnTexto.equals("*") || btnTexto.equals("/")) {
				
				operador = btnTexto;
				tfContador.setText(btnTexto);
			}
		} else {
			
			int segundoNumero = Integer.parseInt(btnTexto);	
			tfContador.setText(Integer.toString(segundoNumero));
			
			int resultado = 0;
			
			switch (this.operador) {
            case "+":
                resultado = this.acumulado + segundoNumero;
                tfContador.setText(Integer.toString(resultado));
                contador.setValor(resultado);
                break;
            case "-":
                resultado = this.acumulado - segundoNumero;
                tfContador.setText(Integer.toString(resultado));
                break;
            case "*":
                resultado = this.acumulado * segundoNumero;
                tfContador.setText(Integer.toString(resultado));
                break;
            case "/":
                resultado = this.acumulado / segundoNumero;
                tfContador.setText(Integer.toString(resultado));
                break;
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
