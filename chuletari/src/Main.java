import java.util.Scanner;

public class Main {

    // Método para crear una matriz de enteros
    public static int[][] crearMatriz(int filas, int columnas) {
        return new int[filas][columnas];
    }

    // Método para imprimir una matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para pedir un número entero al usuario con control de errores
    public static int pedirNumeroEntero(Scanner input, String mensaje) {
        int numero = 0;
        boolean tipoCorrecto = false;

        // Bucle para asegurarse de que se ingrese un número entero válido
        while (!tipoCorrecto) {
            System.out.print(mensaje);
            if (input.hasNextInt()) {
                numero = input.nextInt();
                tipoCorrecto = true;  // Si el número es válido, salimos del bucle
            } else {
                System.out.println("¡Error! Debes ingresar un número entero.");
                input.nextLine(); // Limpiamos el buffer de entrada
            }
        }
        return numero;
    }

    // Método para pedir una matriz de enteros al usuario
    public static int[][] pedirMatriz(Scanner input, int filas, int columnas) {
        int[][] matriz = crearMatriz(filas, columnas);
        System.out.println("Ingresa los valores para la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = pedirNumeroEntero(input, "Ingresa el valor para la posición [" + i + "][" + j + "]: ");
            }
        }
        return matriz;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Pedir dimensiones de la primera matriz
        int filas1 = pedirNumeroEntero(input, "Ingrese el número de filas para la primera matriz: ");
        int columnas1 = pedirNumeroEntero(input, "Ingrese el número de columnas para la primera matriz: ");

        // Crear la primera matriz
        int[][] matriz1 = pedirMatriz(input, filas1, columnas1);

        // Pedir dimensiones de la segunda matriz
        int filas2 = pedirNumeroEntero(input, "Ingrese el número de filas para la segunda matriz: ");
        int columnas2 = pedirNumeroEntero(input, "Ingrese el número de columnas para la segunda matriz: ");

        // Crear la segunda matriz
        int[][] matriz2 = pedirMatriz(input, filas2, columnas2);

        // Imprimir las matrices ingresadas
        System.out.println("Matriz 1:");
        imprimirMatriz(matriz1);

        System.out.println("Matriz 2:");
        imprimirMatriz(matriz2);

        // Intentar sumar las matrices
        int[][] matrizSuma = sumarMatrices(matriz1, matriz2);
        if (matrizSuma != null) {
            System.out.println("Suma de matrices:");
            imprimirMatriz(matrizSuma);
        }

        // Intentar multiplicar las matrices
        int[][] matrizMultiplicacion = multiplicarMatrices(matriz1, matriz2);
        if (matrizMultiplicacion != null) {
            System.out.println("Multiplicación de matrices:");
            imprimirMatriz(matrizMultiplicacion);
        }
    }

    // Método para sumar dos matrices
    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        int filas = matriz1.length;
        int columnas = matriz1[0].length;

        // Verificar si las dimensiones son compatibles para la suma
        if (filas != matriz2.length || columnas != matriz2[0].length) {
            System.out.println("Error: Las matrices no tienen las mismas dimensiones para ser sumadas.");
            return null; // Retorna null si no se pueden sumar
        }

        int[][] resultado = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return resultado;
    }

    // Método para multiplicar dos matrices
    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int filas2 = matriz2.length;
        int columnas2 = matriz2[0].length;

        // Verificar si las matrices tienen dimensiones compatibles para la multiplicación
        if (columnas1 != filas2) {
            System.out.println("Error: El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz.");
            return null; // Retorna null si no se pueden multiplicar
        }

        int[][] resultado = new int[filas1][columnas2];
        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                for (int k = 0; k < columnas1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado;
    }
}