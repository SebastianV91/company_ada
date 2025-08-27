/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.util.Scanner;

/**
 *
 * @author WIN 10
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("=== Calculadora ===");

        while (!salir) {
            System.out.println("\nSelecciona una operación:");
            System.out.println("1. Suma (+)");
            System.out.println("2. Resta (-)");
            System.out.println("3. Multiplicación (*)");
            System.out.println("4. División (/)");
            System.out.println("5. Raíz cuadrada (√)");
            System.out.println("6. Salir");

            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            double num1, num2;

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el primer número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Resultado: " + (num1 + num2));
                    break;

                case 2:
                    System.out.print("Ingresa el primer número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Resultado: " + (num1 - num2));
                    break;

                case 3:
                    System.out.print("Ingresa el primer número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Resultado: " + (num1 * num2));
                    break;

                case 4:
                    System.out.print("Ingresa el primer número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    num2 = scanner.nextDouble();
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Error: División entre cero no permitida.");
                    }
                    break;

                case 5:
                    System.out.print("Ingresa el número: ");
                    num1 = scanner.nextDouble();
                    if (num1 >= 0) {
                        System.out.println("Resultado: " + Math.sqrt(num1));
                    } else {
                        System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
                    }
                    break;

                case 6:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();

    }
    
}
