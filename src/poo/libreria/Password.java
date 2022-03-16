package poo.libreria;

public class Password {

    private int longitud;
    private String contraseña = "";
    private String NUMEROS = "0123456789";
    private String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

    public Password() {
        this.longitud = 8;
    }

    public Password(int longitud) {
        this.longitud = longitud;
        generarPassword();
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void generarPassword() {
        String pass = "", key = NUMEROS + MAYUSCULAS + MINUSCULAS;

        for (int i = 0; i < longitud; i++) {
            pass += (key.charAt((int)(Math.random() * key.length())));
        }
        contraseña = pass;
    }

    public boolean esFuerte(){
        char caracter;
        int cMinusc = 0, cNum = 0, cMayusc = 0;
        for(int i=0;i<contraseña.length();i++){
            caracter = contraseña.charAt(i);
            if(Character.isDigit(caracter)){
                cNum ++;
            }else if(Character.isLowerCase(caracter)){
                cMinusc ++;
            }else {                     //Al llegar a este else el caracter es Mayuscula
                cMayusc ++;
            }
        }

        if(cNum > 3 && cMinusc > 1 && cMayusc > 2){
            return true;
        } else {
            return false;
        }
    }


}