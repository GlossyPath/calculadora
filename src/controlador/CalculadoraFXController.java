package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Contador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class CalculadoraFXController implements Initializable {
    @FXML
    private TextField tfContador;
    @FXML
    private Button btCero, btIgual, btClear, btResta, btUno, btDos, btTres, btSuma, btCuatro, btCinco, btSeis,
            btMultiplicacion, btSiete, btOcho, btnueve, btDivision;

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

    
    public void añadirSigno (String btnTexto) {
    	operador = btnTexto;
        tfContador.setText(btnTexto);
        contador.setValor(Integer.parseInt(this.acumulado));
        this.acumulado = "";     
    }
    
    public void añadirPrimerDigito(String btnTexto) {
    	this.numero = btnTexto;
        tfContador.setText(this.numero);
        this.acumulado = this.numero;       
        contador.setValor(Integer.parseInt(this.acumulado));
    }
    
    public void añadirDigitos(String btnTexto) {
    	 if (this.acumulado.equals("")) {
             tfContador.setText(btnTexto);
    	 }
    	 
    	 this.numero = btnTexto;
         this.acumulado += this.numero;
         tfContador.setText(this.acumulado);
    }
    
    @FXML
    public void clickBoton(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String btnTexto = btn.getText();
        
        if (operador.equals("")) {
            	
        	if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/")) && this.numero.isEmpty()) {
                	
                añadirPrimerDigito(btnTexto);
                    
        	} else if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/")) && !this.acumulado.isEmpty()) {
                	
                añadirDigitos(btnTexto);
                    
        	} else if (btnTexto.equals("+") || btnTexto.equals("-") || btnTexto.equals("*") || btnTexto.equals("/") && btnTexto.isEmpty()) {
                	
                añadirSigno(btnTexto);
        	}
                
        } else {
            	
        	if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/") && !btnTexto.equals("=") && !btnTexto.equals("CE"))) {
                	
                añadirDigitos(btnTexto);
                    
        	} else {
                	
        		switch (this.operador) {
        			case "+":
        				contador.sumarContador(Integer.parseInt(this.acumulado));
        				tfContador.setText(Integer.toString(contador.getValor()));
        				this.acumulado = "";
        				this.operador = "";
                        break;
                            
                        case "-":
                        	contador.restarContador(Integer.parseInt(this.acumulado));
                            tfContador.setText(Integer.toString(contador.getValor()));
                            this.acumulado = "";
                            this.operador = "";
                            break;
                            
                        case "*":
                            contador.multiplicarContador(Integer.parseInt(this.acumulado));
                            tfContador.setText(Integer.toString(contador.getValor()));
                            this.acumulado = "";
                            this.operador = "";
                            break;
                            
                        case "/":
                            try {
                                contador.dividirContador(Integer.parseInt(this.acumulado));
                                tfContador.setText(Integer.toString(contador.getValor()));
                                this.acumulado = "";
                                this.operador = "";
                            } catch (NumberFormatException e) {
                                tfContador.setText("Error al dividir por 0");
                                e.printStackTrace();
                            }
                            break;                          
                            
                        default:
                			System.out.println("Opcion incorrecta");
                    }  		                   
                }
            }
        
        if(btnTexto.equals("=")) {
        	int resultado = contador.getValor();
            tfContador.setText(Integer.toString(resultado));
            
            contador.clearAndIgual();
            
            this.operador = "";
            this.acumulado = "";
            this.numero = "";
        }
        if (btnTexto.equals("CE")) {
        	
            tfContador.clear();
            
            contador.clearAndIgual();
            
            this.operador= "";
            this.acumulado = "";
            this.numero = "";
        }
    }
}