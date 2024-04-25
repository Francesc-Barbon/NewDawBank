import java.util.*;
public class CuentaBancaria{
    private final String IBAN;
    private final String titular;
    private double saldo;
    private ArrayList<String> movimientos;
    private boolean correcta;

    public CuentaBancaria(String titular, String IBAN){
        this.titular = titular;
        this.IBAN = IBAN;
        saldo = 0;
        movimientos = new ArrayList<String>();
    }
    /*Getters y setters*/
    public String getTitular(){
        return this.titular;
    }
    /*
    public void setTitular(String titular){
        this.titular = titular;
    }
    */

    public String getIBAN(){
        return this.IBAN;
    }
    /*
    public void setIBAN(String IBAN){
        this.IBAN = IBAN;
    }
    */

    public double getSaldo(){
        return this.saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void getMovimientos(){
        for(int i = 0; i < movimientos.size(); i++){
            System.out.println("Movimiento "+(i+1)+" "+movimientos.get(i));
        }
    }
    public void ingresarDinero(double cantidad){
        if(cantidad >= 3000){
            System.out.println("Avuisar a Hacienda");
        }
        this.saldo += cantidad;
        movimientos.add("Se han ingresado "+cantidad+" euros");
    }
    public void retirarDinero(double cantidad){
        this.saldo -= cantidad;
        if(this.saldo < -50){
            this.saldo = -50;
            System.out.println("Saldo negativo");
            movimientos.add("El saldo era inferior a -50 euros");
        }else if(this.saldo < 0){
            System.out.println("Se han retirado "+cantidad+" euros");
            System.out.println("Saldo negativo");
            movimientos.add("Se han retirado "+cantidad+" euros");
        }else{
            System.out.println("Se han retirado "+cantidad+" euros");
            movimientos.add("Se han retirado "+cantidad+" euros");
        }
    }

    public boolean validarIBAN(String IBAN){
        String regex = "[A-Z]{2}[0-9]{22}";
        if(IBAN.matches(regex)){
            return true;
        }
        return false;
    }





}
