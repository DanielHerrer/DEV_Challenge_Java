package algoritmos;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Algoritmos {
    //COLORES
    String FONT_RED = "\u001B[31m";
    String FONT_GREEN = "\u001B[32m";
    String FONT_YELLOW = "\u001B[33m";
    String FONT_CYAN = "\u001B[36m";
    String FONT_RESET = "\u001B[0m";

    Scanner entrada = new Scanner(System.in);
    int operacion, salir = 0;

    public Algoritmos(){
        do {
            System.out.println("");
            System.out.println(FONT_CYAN+"*************************************************");
            System.out.println("              Challenge Algoritmo                ");
            System.out.println("*************************************************"+FONT_RESET);
            System.out.println("");
            System.out.println("1. Corroborar numero primo.");
            System.out.println("2. Verificación de contraseña.");
            System.out.println("3. Importe a cobrar del empleado.");
            System.out.println("4. Encontrar numero aleatorio.");
            System.out.println("5. Numeros acumulados.");
            System.out.println("6. Salir.");
            System.out.println("");
            System.out.print("Elija la operacion que desea: ");
            operacion = entrada.nextInt();
            System.out.println(FONT_CYAN+"*************************************************"+FONT_RESET);
            System.out.println("");

            switch (operacion) {
                case 1:
                    numeroPrimo();
                    break;
                case 2:
                    contraseña();
                    break;
                case 3:
                    empleado();
                    break;
                case 4:
                    numeroAleatorio();
                    break;
                case 5:
                    numAcumulativo();
                    break;
                case 6:
                    salir = 1;
                    break;
                default:
                    System.out.println("Opcion elegida no existente.");
                    break;
            }
        }while(salir!=1);
        entrada.close();
        System.out.println("");
        System.out.println("Finalizando programa. Hasta pronto.");
        System.exit(0);
    }

    // 1. Corroborar numero primo.
    public void numeroPrimo(){
        int numero, bandera = 1, divisor = 2;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Por favor, ingrese un numero: ");
        numero = entrada.nextInt();

        if(numero == 0 || numero == 1 || numero == 2){
            bandera = 0;
        }

        while ((bandera == 1) && (divisor!=numero)){
            if(numero % divisor == 0) {     // Si el resto de la division entre el (numero ingresado) y el (divisor) es igual a 0 entonces es par
                bandera = 0;
            }
            divisor++;                      // Sino el divisor incrementara hasta llegar al numero ingresado demostrando ser primo
        }

        if(bandera == 0) {
            System.out.println("");
            System.out.println(FONT_RED+"El numero no es primo."+FONT_RESET);
        }else if(bandera == 1){
            System.out.println("");
            System.out.println(FONT_GREEN+"El numero es primo."+FONT_RESET);
        }
    }

    // 2. Verificación de contraseña.
    public void contraseña(){
        Scanner entrada = new Scanner(System.in);
        String pass, v_pass;
        int intentos = 0;

        System.out.print("Ingrese su contraseña a registrar: ");
        pass = entrada.nextLine();
        System.out.println("Contraseña registrada!");
        System.out.println("");

        while(intentos < 3) {
            System.out.print("Ahora verifique su contraseña: ");
            v_pass = entrada.nextLine();

            if(pass.equals(v_pass)) {
                System.out.println("");
                System.out.println(FONT_GREEN+"Felicitaciones, recuerdas tu contraseña."+FONT_RESET);
                intentos = 4;   //Se usa el numero 4 para salir del while sin entrar en el if
            } else if(intentos<2){
                System.out.println(FONT_YELLOW+"Contraseña incorrecta, vuelva a intentar."+FONT_RESET);
                System.out.println("");
                intentos++;
            } else if(intentos==2) {
                System.out.println(FONT_YELLOW + "Contraseña incorrecta, no tienes mas intentos." + FONT_RESET);
                intentos++;
            }
        }

        if(intentos == 3){
            System.out.println("");
            System.out.println(FONT_RED+"Tienes que ejercitar la memoria."+FONT_RESET);
        }
    }

    // 3. Importe a cobrar del empleado.
    public void empleado(){
        String nombre = "";
        Scanner entrada = new Scanner(System.in);
        int valorHora, horasMes, antiguedad, cobrar;

        System.out.print("Ingrese el valor por hora del empleado: ");
        valorHora = entrada.nextInt();
        System.out.println("");

        entrada.nextLine();             //Se usó el nextLine para limpiar el buffer del Scanner

        System.out.print("Ingrese el nombre del empleado: ");
        nombre = entrada.nextLine();
        System.out.println("");

        System.out.print("Ingrese los años de antiguedad del empleado: ");
        antiguedad = entrada.nextInt();
        System.out.println("");

        System.out.print("Ingrese la cantidad de horas trabajadas por mes del empleado: ");
        horasMes = entrada.nextInt();
        System.out.println("");

        cobrar = valorHora * horasMes;
        if(antiguedad > 10){
            cobrar += antiguedad * 30;
        }

        System.out.println("---------------------------------------");
        System.out.println("- Nombre del empleado: "+ nombre);
        System.out.println("- Antiguedad: "+ antiguedad +" años.");
        System.out.println("- Monto a cobrar: $"+ cobrar);
        System.out.println("---------------------------------------");

        }

    // 4. Encontrar numero aleatorio.
    public void numeroAleatorio(){
        int aleatorio = (int) (Math.random() * 1000);
        int numero;               //Asignamos el valor -1 para que no haya problemas si se llega a generar un numero aleatorio igual a 0

        do{
            System.out.print("Escriba por teclado un número del 0 al 1000 : ");
            numero = entrada.nextInt();
            System.out.println("");

            if(numero < 0 || numero > 1000){
                System.out.println(FONT_RED+"El numero ingresado es incorrecto."+FONT_RESET);
                System.out.println("");
            }else if(numero > aleatorio){
                System.out.println(FONT_CYAN+"El numero a encontrar es menor!"+FONT_RESET);
                System.out.println("");
            }else if(numero < aleatorio) {
                System.out.println(FONT_YELLOW+"El numero a encontrar es mayor!"+FONT_RESET);
                System.out.println("");
            }
        }while(numero != aleatorio);

        System.out.println(FONT_GREEN+"Has encontrado el numero! "+ numero +" "+FONT_RESET);

    }

    // 5. Numeros acumulados.
    public void numAcumulativo() {
        int num, numMayor, numMenor, sumaTotal, suma;
        Scanner entrada = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<Integer>();    //Generamos una lista Integer

        do{
            System.out.print("Ingrese su numero: ");
            num = entrada.nextInt();
            if(num!=-1){
                lista.add(num);
            }
        }while(num != -1);

        numMayor = getMayor(lista);
        numMenor = getMenor(lista);
        sumaTotal = getTotal(lista);
        suma = numMayor + numMenor + sumaTotal;

        System.out.println("El numero mas grande fue: "+numMayor);
        System.out.println("El numero mas bajo fue: "+numMenor);
        System.out.println("La suma de todos los numeros ingresados es: "+sumaTotal);
        System.out.println("La suma de los numeros enlistados es: "+suma);

    }

    // Este metodo forma parte de numAcumulativo()
    private int getMayor(ArrayList<Integer> lista){
        int numMayor = 0;

        for(int i=0; i<lista.size(); i++){
            if(lista.get(i) > numMayor){
                numMayor = lista.get(i);
            }
        }
        return numMayor;
    }

    // Este metodo forma parte de numAcumulativo()
    private int getMenor(ArrayList<Integer> lista){
        int numMenor = lista.get(0);

        for(int i=0; i<lista.size(); i++){
            if(lista.get(i) < numMenor){
                numMenor = lista.get(i);
            }
        }
        return numMenor;
    }

    // Este metodo forma parte de numAcumulativo()
    private int getTotal(ArrayList<Integer> lista){
        int sumaTotal = 0;

        for(int i=0; i<lista.size(); i++){
            sumaTotal += lista.get(i);
        }
        return sumaTotal;
    }

}
