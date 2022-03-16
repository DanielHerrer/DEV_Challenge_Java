import algoritmos.Algoritmos;
import poo.MainPass;
import java.util.Scanner;

public class ClasePrincipal {

    public static void main(String args[]) {
        //COLORES
        String FONT_RED = "\u001B[31m";
        String FONT_GREEN = "\u001B[32m";
        String FONT_BLUE = "\u001B[34m";
        String FONT_PURPLE = "\u001B[35m";
        String FONT_CYAN = "\u001B[36m";
        String FONT_RESET = "\u001B[0m";

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;


            System.out.println(FONT_RED+"*************************************************"+FONT_RESET);
            System.out.println("             DEVPLACE - DevChallenge             ");
            System.out.println(FONT_GREEN+"*************************************************"+FONT_RESET);
            System.out.println("              Daniel Franco Herrera");
            System.out.println(FONT_BLUE+"*************************************************"+FONT_RESET);
            System.out.println("");
            System.out.println("Bienvenido, elija una de las siguientes operaciones. ");
            System.out.println("");
            System.out.println(FONT_CYAN+"1. Challenge - Algoritmos."+FONT_RESET);
            System.out.println(FONT_PURPLE+"2. Challenge - Programacion Orientada a Objetos."+FONT_RESET);
            System.out.println(FONT_BLUE+"3. Challenge - Base de Datos."+FONT_RESET);
            System.out.println("4. Salir.");
            System.out.println("");
            System.out.print("Por favor, seleccione una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    Algoritmos algoritmos = new Algoritmos();
                    break;
                case 2:
                    MainPass poo = new MainPass();
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Finalizando programa. Hasta pronto.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("La opcion elegida es incorrecta.");
                    break;
            }
            entrada.close();
    }
}