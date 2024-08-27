package modelo;

public class Contador {

    private double valor;

    public Contador() {
        this.valor = 0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void sumarContador(double segundaCifra) {
        double total = this.getValor() + segundaCifra;
        this.setValor(total);
    }

    public void restarContador(double segundaCifra) {
        double total = this.getValor() - segundaCifra;
        this.setValor(total);
    }

    public void multiplicarContador(double segundaCifra) {
        double total = this.getValor() * segundaCifra;
        this.setValor(total);
    }

    public void dividirContador(double segundaCifra) throws ArithmeticException {
        if (segundaCifra == 0) {
            throw new ArithmeticException("No se puede dividir por 0");
        } else {
            double total = this.getValor() / segundaCifra;
            this.setValor(total);
        }
    }

    public double resultadoContador() {
        return this.getValor();
    }

    public void clear() {
        this.setValor(0);
    }
}