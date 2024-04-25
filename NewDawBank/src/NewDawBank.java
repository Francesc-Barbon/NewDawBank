import java.util.*;

public class NewDawBank{

    public static void menu(){
        System.out.println("Que accion quieres realizar?\n");
        System.out.println("1. Mostrar todos los datos\n" +
                "2. Mostrar IBAN\n" +
                "3. Mostrar titual\n" +
                "4. Saldo disponible\n" +
                "5. Hacer un ingreso\n" +
                "6. Retirar dinero\n" +
                "7. Mostrar movimientos\n" +
                "8. Salir"
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double cantidad;
        int opcion;
        boolean salir = false;
        System.out.println("Introduce el titular de la cuenta");
        String titular = sc.nextLine();
        System.out.println("Introduce el IBAN");
        String IBAN = sc.nextLine();
        while(!IBAN.matches("[A-Z]{2}[0-9]{22}")){
            System.out.println("IBAN incorrecto");
            System.out.println("Introduce el IBAN");
            IBAN = sc.nextLine();
        }
        CuentaBancaria cuenta = new CuentaBancaria(titular,IBAN);
        System.out.println("Cuenta creada correctamente!!");
        menu();
        opcion = sc.nextInt();
        while(opcion != 8){

            switch(opcion){
                case 1:
                    System.out.println("El titular de la cuenta es "+cuenta.getTitular());
                    System.out.println("El IBAN de la cuenta es "+cuenta.getIBAN());
                    System.out.println("El saldo de la cuenta es "+cuenta.getSaldo());
                    break;
                case 2:
                    System.out.println("El IBAN de la cuenta es "+cuenta.getIBAN());
                    break;
                case 3:
                    System.out.println("El titular de la cuenta es "+cuenta.getTitular());
                    break;
                case 4:
                    System.out.println("El saldo de la cuenta es "+cuenta.getSaldo());
                    break;
                case 5:
                    System.out.print("Cantidad a ingresar: ");
                    cantidad = sc.nextDouble();
                    cuenta.ingresarDinero(cantidad);
                    break;
                case 6:
                    System.out.println("Cantidad a retirar: ");
                    cantidad = sc.nextDouble();
                    cuenta.retirarDinero(cantidad);
                    break;
                case 7:
                    System.out.println("Movimiento de la cuenta: ");
                    cuenta.getMovimientos();
                    break;
                default:
                    break;

            }
            menu();
            opcion = sc.nextInt();
        }
        System.out.println("Adios!");
    }
}