/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extra.pkg06.Entidad;

/**
 *
 * @author gasto
 */
public class Ahorcado {
    
    //Atributos
    private String [] palabra;
    private int errores;
    private int erroresMaximos;
    private boolean gano;
    private String[] progreso;

    
    //Constructores
    public Ahorcado() {
    }

    public Ahorcado(String[] palabra, int erroresMaximos) {
        this.palabra = palabra;
        this.erroresMaximos = erroresMaximos;
        gano=false;
        progreso = new String[palabra.length];
        for (int i = 0; i < palabra.length; i++) {
            progreso[i]="_";
        }
        errores=0;
    }

    //Getter & Setter
    public String[] getPalabra() {
        return palabra;
    }

    public void setPalabra(String[] palabra) {
        this.palabra = palabra;
    }

    public int getErroresMaximos() {
        return erroresMaximos;
    }

    public void setErroresMaximos(int erroresMaximos) {
        this.erroresMaximos = erroresMaximos;
    }

    public boolean isGano() {
        return gano;
    }

    public void setGano(boolean gano) {
        this.gano = gano;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }
    
    //Metodos
    public void mostrarPalabra(){
        for (String palabra1 : palabra) {
            System.out.print("[" + palabra1 + "]");
        }
        System.out.println("");
    }
    
    public void mostrarProgreso(){
        for (String palabra1 : progreso) {
            System.out.print("[" + palabra1 + "]");
        }
        System.out.println("");
    }
    
    public boolean tieneLetra(String letra){
        boolean letraEsta=false;
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i].equals(letra)) {
                letraEsta=true;
                progreso[i]=letra;
            }
        }
        if (!letraEsta) {
            errores++;
           System.out.println("ERROR " + errores); 
        }
        return letraEsta;
    }
    
    public boolean puedeSeguirJugando(){
        return(errores<erroresMaximos);
    }
    
    public boolean ganaste(){
        for (int i = 0; i < palabra.length; i++) {
            if (!palabra[i].equals(progreso[i])) {
                return false;
            }
        }
        return true;
    }
}
