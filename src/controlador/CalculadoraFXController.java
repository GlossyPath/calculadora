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
        tfContador.setText(operador);
        
        if(!this.acumulado.isEmpty()) {
        	contador.setValor(Integer.parseInt(this.acumulado));
            this.acumulado = "";
        }            
    }
    
    
    public void añadirDigitos(String btnTexto) {
    	
    	 if (this.acumulado.equals("")) {
    		 this.numero = btnTexto;
             tfContador.setText(this.numero);
             this.acumulado = this.numero;       
             
    	 } else {
    		 this.numero = btnTexto;
             this.acumulado += this.numero;
             tfContador.setText(this.acumulado);
    	 }
    }
    
    
    @FXML
    public void clickBoton(ActionEvent event) {
    	
        Button btn = (Button) event.getSource();
        String btnTexto = btn.getText();
        
        if (btnTexto.equals("CE")) {
            tfContador.clear();
            contador.clear();
            this.operador = "";
            this.acumulado = "";
            this.numero = "";
            return;
        }
        
        if(btnTexto.equals("=")) {
        	contador.resultado(Integer.parseInt(this.acumulado));
            
            this.operador = "";
            this.acumulado = "";
            this.numero = "";
            return;
        }
        
        
        
        if (operador.equals("")) {
            	
        	if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/"))) {
                	
        		añadirDigitos(btnTexto);
                    
        	} else if (btnTexto.equals("+") || btnTexto.equals("-") || btnTexto.equals("*") || btnTexto.equals("/")) {
                	
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
                        break;
                            
                        case "-":
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
                                        
                        default:
                			System.out.println("Opcion incorrecta");
                    }  		                   
                }
        } 
    }
}