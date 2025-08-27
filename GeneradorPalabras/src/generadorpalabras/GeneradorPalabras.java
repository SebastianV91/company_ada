/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorpalabras;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author WIN 10
 */
public class GeneradorPalabras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        // Array de caracteres
        char[] cadena = {
            'w','e','r','f','b','h','j','i','u','y','t','r','e','d','f','g','y','u','i','o',
            'l','k','m','n','b','v','f','r','e','w','s','x','f','g','y','u','i','k','m','n',
            'b','v','f','r','e','w','w','r','t','y','u','i','o','k','m','n','b','v','w','s',
            'x','c','f','g','h','u','i','o','p','l','k','n','b','v','f','d','e','w','a','z',
            'x','c','g','h','u','i','o','p','u','y','t','r','e','w','q','s','d','f','g','k',
            'j','v','c','x'
        };

        // Diccionario de ejemplo
        Set<String> diccionario = Set.of("fer", "web", "jug", "fin", "rey", "bus", "red", "fun", "tip");

        // Generamos combinaciones simples de 3 letras
        Set<String> palabrasValidas = new HashSet<>();
        for (int i = 0; i < cadena.length; i++) {
            for (int j = 0; j < cadena.length; j++) {
                for (int k = 0; k < cadena.length; k++) {
                    String palabra = "" + cadena[i] + cadena[j] + cadena[k];
                    if (diccionario.contains(palabra)) {
                        palabrasValidas.add(palabra);
                    }
                }
            }
        }

        System.out.println("Palabras válidas encontradas: " + palabrasValidas);
        
    }

}
