import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        while (true) {
            System.out.println("*************************");
            System.out.println("Bienvenido al conversor de Monedas:");
            System.out.println("1. Dolar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dolar");
            System.out.println("3. Dolar a Real Brasileño");
            System.out.println("4. Real Brasileño a Dolar");
            System.out.println("5. Dolar a Sol Peruano");
            System.out.println("6. Sol Peruano a Dolar");
            System.out.println("7. Salir");
            System.out.println("Elija una opcion: ");
            System.out.println("*************************");

            try {
                int opcion = lectura.nextInt();

                if (opcion == 7){
                    System.out.println("Gracias por usar el conversor, Hasta Pronto");
                    break;
                }
                if (opcion < 1 || opcion > 6) {
                    System.out.println("Opcion no valida, intente de nuevo");
                    continue;
                }
                System.out.println("Ingrese el valor que deseas convertir: ");
                double valor = lectura.nextDouble();

                String monedaBase = "";
                String monedaDestino = "";

                switch (opcion) {
                    case 1:
                        monedaBase = "USD";
                        monedaDestino = "ARS";
                        break;
                    case 2:
                        monedaBase = "ARS";
                        monedaDestino = "USD";
                        break;
                    case 3:
                        monedaBase = "USD";
                        monedaDestino = "BRL";
                        break;
                    case 4:
                        monedaBase = "BRL";
                        monedaDestino = "USD";
                        break;
                    case 5:
                        monedaBase = "USD";
                        monedaDestino = "PEN";
                        break;
                    case 6:
                        monedaBase = "PEN";
                        monedaDestino = "USD";
                        break;
                }
                Moneda moneda = consulta.buscaMoneda(monedaBase);
                double tasaDeConversion = moneda.conversion_rates().get(monedaDestino);
                double valorFinal = valor*tasaDeConversion;
                //System.out.println("El valor " + valor + monedaBase + " corresponde al valor final de:" + valorFinal + monedaDestino);
                System.out.printf("El valor %.1f (%s) corresponde al valor final de: %.2f (%s)\n\n",
                        valor, monedaBase, valorFinal, monedaDestino);
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un numero valido");
                lectura.next();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicacion");
                break;
            }

        }
    }
}
