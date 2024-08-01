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
            btMultiplicacion, btSiete, btOcho, btnueve, btDivision;

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
        
        this.numero += btnTexto;
        tfContador.setText(this.numero);
        
        tfAcumulado.appendText(btnTexto);
    }
    
    public void guardarOperador(String btnTexto) {
        if (!this.numero.isEmpty()) {
            realizarOperacion();
        }
        
        this.operador = btnTexto;
        tfAcumulado.appendText(this.operador);
        reset = true;
    }
    
    public void realizarOperacion() {
        int valorActual = Integer.parseInt(this.numero);
        
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
                
            case "/":
                try {
                    contador.dividirContador(valorActual);
                    
                } catch (NumberFormatException e) {
                    tfContador.setText("Error al dividir por 0");
                    e.printStackTrace();
                }
                break;
                
            default:
                contador.setValor(valorActual);
        }
        tfContador.setText(Integer.toString(contador.getValor()));
        this.numero = "";
    }
    
    @FXML
    public void clickBoton(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String btnTexto = btn.getText();
        
        if (btnTexto.matches("[0-9]")) {
            añadirDigitos(btnTexto);
            
        } else if (btnTexto.matches("[+\\-*/]")) {
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
        }
    }
    
    @FXML
    public void clickMenuCerrar(ActionEvent event) {
    	Platform.exit();
    }
}