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
        this.numero = "";
        
    }
    @FXML
    public void clickBoton(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String btnTexto = btn.getText();

        if (operador.isEmpty()) {
        	
            if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/")) && this.numero.isEmpty()) {
            	
                this.numero = btnTexto;
                tfContador.setText(this.numero);
                this.acumulado = this.numero;       
                contador.setValor(Integer.parseInt(this.acumulado));
                
            } else if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/")) && !this.acumulado.isEmpty()) {
            	
                this.numero = btnTexto;
                this.acumulado += this.numero;
                tfContador.setText(this.acumulado);
                
            } else if (btnTexto.equals("+") || btnTexto.equals("-") || btnTexto.equals("*") || btnTexto.equals("/")) {
            	
            	añadirSigno(btnTexto);
            }
            
        } else {
        	
            if ((!btnTexto.equals("+") && !btnTexto.equals("-") && !btnTexto.equals("*") && !btnTexto.equals("/"))) {
            	
                if (this.acumulado.equals("")) {
                    tfContador.setText(btnTexto);
                }
                
                this.numero = btnTexto;
                this.acumulado += this.numero;
                tfContador.setText(this.acumulado);
                
            } else {
            	
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
                        } catch (NumberFormatException e) {
                            tfContador.setText("Error al dividir por 0");
                            e.printStackTrace();
                        }
                        break;
                }
                tfContador.setText(Integer.toString(contador.getValor()));

                this.acumulado = "";
            }
        }

        if (btnTexto.equals("CE")) {
            tfContador.clear();
            this.operador = "";
            this.acumulado = "";
            
        }

        if (btnTexto.equals("=")) {
        	
            int resultado = contador.getValor();
            tfContador.setText(Integer.toString(resultado));
            this.operador = "";
            this.acumulado = "";
        }
    }
}