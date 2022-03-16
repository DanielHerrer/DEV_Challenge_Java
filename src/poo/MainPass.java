package poo;
import java.util.Scanner;
import poo.libreria.Password;

public class MainPass{
    //COLORES
    String FONT_RED = "\u001B[31m";
    String FONT_GREEN = "\u001B[32m";
    String FONT_YELLOW = "\u001B[33m";
    String FONT_PURPLE = "\u001B[35m";
    String FONT_CYAN = "\u001B[36m";
    String FONT_RESET = "\u001B[0m";

    Password mensajero = new Password();
    Scanner entrada = new Scanner(System.in);
    int longitud, operacion, salir = 0;


    public MainPass(){
        do{
            System.out.println("");
            System.out.println(FONT_PURPLE+"*************************************************");
            System.out.println("                   Challenge POO                 ");
            System.out.println("*************************************************"+FONT_RESET);
            System.out.println("");
            System.out.println("1. Generar una contraseña por default.");
            System.out.println("2. Generar una contraseña con una longitud especifica.");
            System.out.println("3. Corroborar si la contraseña es fuerte.");
            System.out.println("");
            System.out.println("4. Salir.");
            System.out.println("");
            System.out.print("Elija la operacion que desea: ");
            operacion = entrada.nextInt();
            System.out.println(FONT_PURPLE+"*************************************************"+FONT_RESET);
            System.out.println("");

            switch (operacion) {
                case 1:
                    mensajero.generarPassword();
                    System.out.println(FONT_CYAN+"La contraseña es: "+ mensajero.getContraseña() +""+FONT_RESET);
                    break;

                case 2:
                    System.out.print("Cual es la longitud que usted desea?: ");
                    longitud = entrada.nextInt();
                    System.out.println("");
                    mensajero.setLongitud(longitud);
                    mensajero.generarPassword();
                    System.out.println(FONT_CYAN+"La contraseña es: "+ mensajero.getContraseña() +""+FONT_RESET);
                    break;

                case 3:
                    if(mensajero.getContraseña().isEmpty()){        //Corrobora si hay una contraseña creada primero
                        System.out.println(FONT_YELLOW+"Genere una contraseña primero."+FONT_RESET);
                    }else{
                        if(mensajero.esFuerte()){
                            System.out.println(FONT_GREEN+"La contraseña es fuerte."+FONT_RESET);
                        }else{
                            System.out.println(FONT_RED+"La contraseña no es fuerte."+FONT_RESET);
                        }
                    }
                    break;

                case 4:
                    salir = 1;
                    break;

                default:
                    System.out.println("Opcion elegida no existente.");
                    break;
            }
        }while(salir!=1);
        entrada.close();
        System.out.println("Finalizando programa. Hasta pronto.");
        System.exit(0);
    }
}
