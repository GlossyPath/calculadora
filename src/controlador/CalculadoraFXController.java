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
    private TextField tfAcumulado;
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
    
   
    public void añadirDigitos(String btnTexto) {  //método correcto, pero más adelante mejoraremos la lógica del mismo  
    	
    	this.numero = btnTexto;
        this.acumulado += this.numero;
        tfContador.setText(this.acumulado);
        tfAcumulado.appendText(btnTexto);   		
    }
    
    
    public void guardarSigno (String btnTexto) {
    	
    	if(contador.getValor() == 0) {
        	contador.setValor(Integer.parseInt(this.acumulado));
        	this.acumulado = "";
    	}
    	
    	this.operador = btnTexto;
    	
    	tfAcumulado.appendText(this.operador);
    }
    
    
    @FXML
    public void clickBoton(ActionEvent event) {
    	
        Button btn = (Button) event.getSource();
        String btnTexto = btn.getText();
        
        
        if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/") && !btnTexto.equals("=") && !btnTexto.equals("CE")) && contador.getValor() == 0) { // CORRECTO
                	
        	añadirDigitos(btnTexto);
        	
        } else if ((btnTexto.equals("+") || btnTexto.equals("-") || btnTexto.equals("*") || btnTexto.equals("/")) && this.operador.equals("")) {
        
        	guardarSigno (btnTexto);
                    
        } else if ((contador.getValor() != 0 && !this.operador.equals("")) || this.acumulado.equals("")) {
        	
        	if(this.acumulado.equals("")) {
        		
            	añadirDigitos(btnTexto);
            	
        	} else {
        		
        		switch (this.operador) {
            	
        		case "+":	    			
        			tfContador.setText(Integer.toString(contador.getValor()));
        			
        			contador.sumarContador(Integer.parseInt(this.acumulado));

        			this.acumulado = "";
        			this.operador = "";
                    break;
                            
        		case "-":
        			tfAcumulado.appendText(btnTexto);
        			contador.restarContador(Integer.parseInt(this.acumulado));
        			tfContador.setText(Integer.toString(contador.getValor()));
        			this.acumulado = "";
        			break;
                            
        			case "*":
        				contador.multiplicarContador(Integer.parseInt(this.acumulado));
        				tfContador.setText(Integer.toString(contador.getValor()));
        				this.acumulado = "";
                        break;
                            
        			case "/":
        				try {
        					contador.dividirContador(Integer.parseInt(this.acumulado));
                            tfContador.setText(Integer.toString(contador.getValor()));
                            this.acumulado = "";
        				} catch (NumberFormatException e) {
        					tfContador.setText("Error al dividir por 0");
        					e.printStackTrace();
        				}
        				break;
        				
        			case "CE":
        				tfContador.clear();
        				tfAcumulado.clear();
        	            contador.clear();
        	            this.operador = "";
        	            this.acumulado = "";
        	            this.numero = "";
        	            break;
        	            
        			case "=":
        				int resultado = contador.resultadoContador();
        				tfContador.setText(Integer.toString(resultado));
        	            
        	            this.operador = "";
        	            this.acumulado = "";
        	            this.numero = "";
        	            return;
                                        
        			default:
        				System.out.println("Opcion incorrecta");
        		}  		                   
        	}     	       	
        	}
        	
        	
        	        	
        	
        } 
}