import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        while (true) {
            System.out.println("******************************************************");
            System.out.println("""
                     ██████╗ ██████╗ ███╗   ██╗██╗   ██╗███████╗██████╗ ███████╗ ██████╗ ██████╗      █████╗ ██╗     ██╗   ██╗██████╗  █████╗\s
                    ██╔════╝██╔═══██╗████╗  ██║██║   ██║██╔════╝██╔══██╗██╔════╝██╔═══██╗██╔══██╗    ██╔══██╗██║     ██║   ██║██╔══██╗██╔══██╗
                    ██║     ██║   ██║██╔██╗ ██║██║   ██║█████╗  ██████╔╝███████╗██║   ██║██████╔╝    ███████║██║     ██║   ██║██████╔╝███████║
                    ██║     ██║   ██║██║╚██╗██║╚██╗ ██╔╝██╔══╝  ██╔══██╗╚════██║██║   ██║██╔══██╗    ██╔══██║██║     ██║   ██║██╔══██╗██╔══██║
                    ╚██████╗╚██████╔╝██║ ╚████║ ╚████╔╝ ███████╗██║  ██║███████║╚██████╔╝██║  ██║    ██║  ██║███████╗╚██████╔╝██║  ██║██║  ██║
                     ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝  ╚═╝    ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝
                                                                                                                                             \s""");
            System.out.println("Sea Bienvenido/a al Challenge Alura: Conversor de Moneda ");
            System.out.println("1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Dólar =>> Peso Chileno");
            System.out.println("8) Peso Chileno =>> Dólar");
            System.out.println("9) Salir");
            System.out.println("Elija una opción Válida: ");
            System.out.println("*******************************************************");

            int opcion = obtenerOpcion(scanner);
            if (opcion == 9) {
                System.out.println("Muchas gracias por utilizar el conversor de monedas Alura Latam");
                break; // Salir del programa
            }

            System.out.print("Ingrese la cantidad que desea convertir: ");
            double cantidad = scanner.nextDouble();
            double resultado = 0;

            switch (opcion) {
                case 1:
                    resultado = conversor.convertir("USD", "ARS", cantidad);
                    System.out.printf("$%.2f Dólares Equivalen a: $%.2f Pesos Argentinos%n", cantidad, resultado);
                    break;
                case 2:
                    resultado = conversor.convertir("ARS", "USD", cantidad);
                    System.out.printf("$%.2f Pesos Argentinos Equivalen a: $%.2f Dólares%n", cantidad, resultado);
                    break;
                case 3:
                    resultado = conversor.convertir("USD", "BRL", cantidad);
                    System.out.printf("$%.2f Dólares Equivalen a: $%.2f Reales Brasileños%n", cantidad, resultado);
                    break;
                case 4:
                    resultado = conversor.convertir("BRL", "USD", cantidad);
                    System.out.printf("$%.2f Reales Brasileños Equivalen a: $%.2f Dólares%n", cantidad, resultado);
                    break;
                case 5:
                    resultado = conversor.convertir("USD", "COP", cantidad);
                    System.out.printf("$%.2f Dólares Equivalen a: $%.2f Pesos Colombianos%n", cantidad, resultado);
                    break;
                case 6:
                    resultado = conversor.convertir("COP", "USD", cantidad);
                    System.out.printf("$%.2f Pesos Colombianos Equivalen a: $%.2f Dólares%n", cantidad, resultado);
                    break;
                case 7:
                    resultado = conversor.convertir("USD", "CLP", cantidad);
                    System.out.printf("$%.2f Dólares Equivalen a: $%.2f Pesos Chilenos%n", cantidad, resultado);
                    break;
                case 8:
                    resultado = conversor.convertir("CLP", "USD", cantidad);
                    System.out.printf("$%.2f Pesos Chilenos Equivalen a: $%.2f Dólares%n", cantidad, resultado);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static int obtenerOpcion(Scanner scanner) {
        while (true) {
            try {
                int opcion = scanner.nextInt();
                return opcion;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }
}
