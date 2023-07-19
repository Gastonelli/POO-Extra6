/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extra.pkg06.Servicios;

import extra.pkg06.Entidad.Ahorcado;
import java.util.Scanner;

/**
 *
 * @author gasto
 */
public class AhorcadoService {

    Scanner leer = new Scanner(System.in);

    public Ahorcado crearJuego() {
        System.out.println("Ingrese la palabra que debera adivinar el jugador");
        String word = leer.next().toUpperCase();
        String[] palabra = new String[word.length()];
        palabra = guardarPalabra(word, palabra);
        System.out.println("Cuantas veces podra equivocarse el jugador?");
        int chances = leer.nextInt();
        System.out.println("*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*");
        return new Ahorcado(palabra, chances);
    }

    public String[] guardarPalabra(String word, String[] palabra) {
        for (int i = 0; i < palabra.length; i++) {
            palabra[i] = word.substring(i, i + 1);
        }
        return palabra;
    }

    public void juego(Ahorcado a1) {
        String[] alfabeto = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
        a1.mostrarProgreso();
        do {
            System.out.println("Ingrese una letra para ver si esta en la palabra");
            String letra = leer.next().toUpperCase();

            if (a1.tieneLetra(letra)) {
                a1.mostrarProgreso();
            } else {
                System.out.println("No se hallo la letra " + letra + " en la palabra escondida");
                System.out.println("Perdiste una vida, te quedan " + (a1.getErroresMaximos() - a1.getErrores()));
                a1.mostrarProgreso();
            }

            eliminarLetra(alfabeto, letra);
            mostrarDisponibles(alfabeto);

            if (a1.ganaste()) {
                a1.setGano(true);
                break;
            }

        } while (a1.puedeSeguirJugando());

    }

    public void eliminarLetra(String[] alfabeto, String letra) {
        for (int i = 0; i < alfabeto.length; i++) {
            if (alfabeto[i].equals(letra)) {
                alfabeto[i] = "/";
            }
        }
    }

    public void mostrarDisponibles(String[] alfabeto) {
        System.out.println("____________________________________");
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + alfabeto[i] + "]");
        }
        System.out.println("");
        System.out.print(" ");
        for (int i = 10; i < 19; i++) {
            System.out.print("[" + alfabeto[i] + "]");
        }
        System.out.println("");
        System.out.print("  ");
        for (int i = 19; i < 26; i++) {
            System.out.print("[" + alfabeto[i] + "]");
        }
        System.out.println("");
        System.out.println("____________________________________");
    }

}
