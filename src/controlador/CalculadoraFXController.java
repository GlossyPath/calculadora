/**
 * Proyecto: CalculadoraFX
 * 
 * Descripción:
 * CalculadoraFX es una aplicación de calculadora desarrollada en JavaFX y SceneBuilder.
 * Este proyecto implementa una calculadora básica con una interfaz gráfica intuitiva utilizando JavaFX y Scene Builder.
 * 
  * Funcionalidades:
 * - Operaciones básicas de suma, resta, multiplicación y división.
 * - Cálculo de raíz cuadrada.
 * - Cálculo del logaritmo en base 10.
 * - Operación de elevar un número al cuadrado.
 * - Funcionalidad para eliminar toda la información.
 * - Interfaz gráfica con botones para ingresar números y realizar operaciones.
 * 
 * Autor: GlossyPath
 * Fecha: 20/06/2024
 * Versión: 1.0
 * 
 * Notas:
 * - Este archivo contiene el controlador para la interfaz de usuario, gestionando la lógica de interacción
 *   entre la interfaz y el modelo de la calculadora.
 */

package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Contador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class CalculadoraFXController implements Initializable {
    @FXML
    private TextField tfContador;
    @FXML
    private TextField tfAcumulado;
    @FXML
    private Button btCero, btIgual, btClear, btResta, btUno, btDos, btTres, btSuma, btCuatro, btCinco, btSeis,
            btMultiplicacion, btSiete, btOcho, btnueve, btDivision, btRaizCuadrada, btPi, btLog, btCuadrado;

    private Contador contador;
    
    private String numero;
    private String operador;
    private boolean reset;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.contador = new Contador();
        this.operador = "";
        this.numero = "";
        this.reset = false;
    }
    
    
    public void añadirDigitos(String btnTexto) {
    	 if (reset) {
    	        tfContador.clear();
    	        reset = false;
    	    }
    	    
    	 if(btnTexto.equals("π") ) {
    		 this.numero = "3.14159";
    		 tfContador.setText(this.numero);
        	 tfAcumulado.appendText(btnTexto);
        	 
    	 } else {
    		 this.numero += btnTexto;
        	 tfContador.setText(this.numero);
        	 tfAcumulado.appendText(btnTexto);
    	 }	 
    	 
    	}
    
    
    public void guardarOperador(String btnTexto) {
    	 if (!this.numero.isEmpty()) {
             realizarOperacion();  
         }
         
    	 /*
    	 if (btnTexto.equals("√") || btnTexto.equals("log")) {
    		 this.operador = btnTexto;
    	     tfAcumulado.appendText(this.operador);
    	     reset = true;
    	        
    	 } else {*/
    		 this.operador = btnTexto;
    	     tfAcumulado.appendText(this.operador);
    	     reset = true;
    	 //}
     }
    
    public void realizarOperacion() {
        if (this.numero.isEmpty()) {
            return;
        }
        
        double valorActual;
        
        try {
            valorActual = Double.parseDouble(this.numero);
            
        } catch (NumberFormatException e) {
            tfContador.setText("Error");
            this.numero = "";
            return;
        }
        
        switch (this.operador) {
        
            case "+":
                contador.sumarContador(valorActual);
                break;

            case "-":
                contador.restarContador(valorActual);
                break;

            case "*":
                contador.multiplicarContador(valorActual);
                break;

            case "√":
            	try {
            		contador.raizCuadrada(valorActual);
            		
            	}catch(ArithmeticException e) {
            		tfContador.setText("Error: raiz cuadrada negativa");
                    e.printStackTrace();
                    this.numero = "";
                    return;
                }           
                break;

            case "/":
                try {
                    contador.dividirContador(valorActual);
                    
                } catch (ArithmeticException e) {
                    tfContador.setText("Error al dividir por 0");
                    e.printStackTrace();
                    this.numero = "";
                    return;
                }
                break;
                
            case "log":
                try {
                    contador.log10(valorActual);
                    
                } catch (ArithmeticException e) {
                    tfContador.setText("Error: Logaritmo no definido para ≤ 0");
                    this.numero = "";
                    return;
                }
                break;
            
            default:
                contador.setValor(valorActual);
        }
        
        tfContador.setText(Double.toString(contador.getValor()));
        this.numero = "";
    }
    
    
    @FXML
    public void clickBoton(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String btnTexto = btn.getText();
        
        if (btnTexto.matches("[0-9]")) {
            añadirDigitos(btnTexto);
            
        } else if (btnTexto.equals("+") || btnTexto.equals("-") || btnTexto.equals("*") || btnTexto.equals("/") || btnTexto.equals("√") || btnTexto.equals("log")) {
            guardarOperador(btnTexto);
            
        } else if (btnTexto.equals("=")) {
            realizarOperacion();
            this.operador = "";
            
        } else if (btnTexto.equals("CE")) {
            tfContador.clear();
            tfAcumulado.clear();
            contador.clear();
            this.operador = "";
            this.numero = "";
            
        } else if (btnTexto.equals("π")) {
            añadirDigitos(btnTexto);
        }
    }
    
    
    @FXML
    public void clickMenuCerrar(ActionEvent event) {
    	Platform.exit();
    }
    
    @FXML
    public void clickBotonBorrar(ActionEvent event) {
    	tfContador.clear();
        tfAcumulado.clear();
        contador.clear();
        this.operador = "";
        this.numero = "";
    }
}