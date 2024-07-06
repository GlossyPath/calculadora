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
    private String operator;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.contador = new Contador();	
		tfContador.setText(Integer.toString(contador.getValor()));
	}

	// Event Listener on Button[#btCero].onAction
	@FXML
	public void clickBotonCero(ActionEvent event) {
	}
	// Event Listener on Button[#btIgual].onAction
	@FXML
	public void clickBotonIgual(ActionEvent event) {
	}
	// Event Listener on Button[#btClear].onAction
	@FXML
	public void clickBotonClear(ActionEvent event) {
        tfContador.clear();
        contador.setValor(0);
	}
	// Event Listener on Button[#btResta].onAction
	@FXML
	public void clickBotonResta(ActionEvent event) {
	}
	// Event Listener on Button[#btUno].onAction
	@FXML
	public void clickBotonUno(ActionEvent event) {
        tfContador.appendText("1");
	}
	
	// Event Listener on Button[#btDos].onAction
	@FXML
	public void clickBotonDos(ActionEvent event) {
	}
	// Event Listener on Button[#btTres].onAction
	@FXML
	public void clickBotonTres(ActionEvent event) {
	}
	// Event Listener on Button[#btSuma].onAction
	@FXML
	public void clickBotonSuma(ActionEvent event) {
		
		numero = contador.getValor();
		operator = "+";
		tfContador.appendText(operator); //añade el operador o numero o lo que sea alo q esta en el tfContador
		
	}
	// Event Listener on Button[#btCuatro].onAction
	@FXML
	public void clickBotonCuatro(ActionEvent event) {
	}
	// Event Listener on Button[#btCinco].onAction
	@FXML
	public void clickBotonCinco(ActionEvent event) {
	}
	// Event Listener on Button[#btSeis].onAction
	@FXML
	public void clickBotonSeis(ActionEvent event) {
	}
	// Event Listener on Button[#btMultiplicacion].onAction
	@FXML
	public void clickBotonMultiplicacion(ActionEvent event) {
	}
	// Event Listener on Button[#btSiete].onAction
	@FXML
	public void clickBotonSiete(ActionEvent event) {
	}
	// Event Listener on Button[#btOcho].onAction
	@FXML
	public void clickBotonOcho(ActionEvent event) {
	}
	// Event Listener on Button[#btnueve].onAction
	@FXML
	public void clickBotonNueve(ActionEvent event) {
	}
	// Event Listener on Button[#btDivision].onAction
	@FXML
	public void clickBotonDivision(ActionEvent event) {
	}
	
}
