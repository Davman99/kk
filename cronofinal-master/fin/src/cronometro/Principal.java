/* Principal.java 28/02/2018
 * copyrigth (c) 2018 Jesus Roso, David Manosalba, Francisco Barrero
 */
package cronometro;

import cronometro.logica.Cronometro;

/**
 * La clase principal es la que llama a las demas clases e imprime los resultados.
 * @author Jesus Roso
 * @author David Manosalba
 * @author Francisco Barrero
 * @version 1.0
 */
public class Principal {
     /*Esta clase llama a la subclase Cronometro y a la subclase Memoria y utiliza sus
    * datos para la impresion de los datos en la consola .
    */

    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        
        for (int i = 0; i < 1000; i++) {
            c.avanzar();
            System.out.println(c.obtenerTiempo());
            if(i % 100 == 0){
                c.guardarMemoria();
            }
        }
        System.out.println("Memorias");
        c.mostrarMemoriasGUI();
        System.out.println("Retrocediendo");
        for(int i = 0; i < 1000; i++){
            c.retroceder();
            System.out.println(c.obtenerTiempo());
        }
    }
    
}
