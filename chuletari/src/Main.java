import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        boolean opcionValida;

        // BUCLE MENÚ CON CONTROL DE ERRORES
        do {
            // Mostrar el menú de opciones
            System.out.println("Bienvenido! Selecciona la opción que necesite");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("4. Opción 4");
            System.out.println("5. Salir");

            // Verificar que la opción ingresada sea un número entero
            opcionValida = input.hasNextInt();
            if (!opcionValida) {
                System.out.println("Error: Debe ingresar un número entero.");
                input.nextLine(); // Limpiar el buffer
                continue; // Volver al inicio del bucle
            }

            // Guardar la opción seleccionada
            opcion = input.nextInt();
            input.nextLine(); // Limpiar el buffer

            // Condición para salir del menú
            if (opcion == 5) {
                System.out.println("Saliendo del programa. ¡Hasta luego!");
                break;
            }

            // Estructura de control para cada caso del menú
            switch (opcion) {
                case 1:
                    // Código para la opción 1
                    System.out.println("codigo caso 1");
                    break;
                case 2:
                    // Código para la opción 2
                    System.out.println("codigo caso 2");
                    break;
                case 3:
                    // Código para la opción 3
                    System.out.println("codigo caso 3");
                    break;
                case 4:
                    // Código para la opción 4
                    System.out.println("codigo caso 4");
                    break;
                default:
                    // Este caso no debería ocurrir debido a la validación anterior
                    System.out.println("Error opción no válida.");
                    break;
            }

        } while (opcion != 5); // Repetir hasta que se elija la opción de salir

        //FIN BUCLE MENÚ CON CONTROL DE ERRORES
    }
}