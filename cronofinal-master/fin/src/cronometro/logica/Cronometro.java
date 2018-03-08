/*Cronometro.java
 *copyrigth (c) 2018 Jesus Roso, David Manosalba, Francisco Barrero
 */
package cronometro.logica;

import java.util.ArrayList;

/**
 * la clase Cronometro establece el cambio de las unidades de tiempo y el formato 
 * del cronometro. Ademas guarda los tiempos y reinicia el cronometro
 * @author Jesus Roso
 * @author David Manosalba
 * @author Francisco Barrero
 * @version 1.0
 */
public class Cronometro {

    private UnidadTiempo decimas;
    private UnidadTiempo segundos;
    private UnidadTiempo minutos;
    private UnidadTiempo horas;
    private ArrayList<Memoria> memorias;
    
/** Asignar los valores de tope a las unidades de tiempo*/
    
    public Cronometro() {
        decimas = new UnidadTiempo(10);
        segundos = new UnidadTiempo(60);
        minutos = new UnidadTiempo(60);
        horas = new UnidadTiempo(24);
        memorias = new ArrayList<Memoria>(10);
    }

    public UnidadTiempo getDecimas() {
        return decimas;
    }

    public void setDecimas(UnidadTiempo decimas) {
        this.decimas = decimas;
    }

    public UnidadTiempo getSegundos() {
        return segundos;
    }

    public void setSegundos(UnidadTiempo segundos) {
        this.segundos = segundos;
    }

    public UnidadTiempo getMinutos() {
        return minutos;
    }

    public void setMinutos(UnidadTiempo minutos) {
        this.minutos = minutos;
    }

    public UnidadTiempo getHoras() {
        return horas;
    }

    public void setHoras(UnidadTiempo horas) {
        this.horas = horas;
    }
    /**
     * Avanza las unidadede tiempo y analizan cuando estas llegan al tope para
     * aumentar en uno la siguiente 
     */
    public void avanzar() {
        decimas.avanzar();
        if (decimas.getValor() == 0) {
            segundos.avanzar();
            if (segundos.getValor() == 0) {
                minutos.avanzar();
                if (minutos.getValor() == 0) {
                    horas.avanzar();
                }
            }
        }
    }
    /**
     * Retrocede las unidadede tiempo y analizan cuando estas llegan al 0 para
     * disminuir en uno la anterior
     */
    public void retroceder(){
        if(horas.getValor() !=0 || decimas.getValor()!=0 || minutos.getValor()!=0 || segundos.getValor()!=0 ){
            decimas.retroceder();
            if(decimas.getValor()==decimas.getTope()-1){
                segundos.retroceder();
                if(segundos.getValor()==segundos.getTope()-1){
                    minutos.retroceder();
                    if(minutos.getValor()==minutos.getTope()-1){
                        horas.retroceder();
                }
            }
        }
        }
    }
    /**
     * reinicia todas las unidades de tiempo, las ubica en cero
     */
        
    public void reiniciar (){
        decimas.reiniciar();
        segundos.reiniciar();
        minutos.reiniciar();
        horas.reiniciar();
    }
    /**
     * Le da formato al cronometro a traves de un string
     * @return 
     */
    public String obtenerTiempo() {
        return horas.obtenerValorFormateado() + " : "
                + minutos.obtenerValorFormateado() + " : "
                + segundos.obtenerValorFormateado() + " : "
                + decimas.obtenerValorFormateado();
    }
    /**
     * guarda los tiemmpos seleccionados en uns string
     */

    public void guardarMemoria() {
        Memoria m = new Memoria();
        
        m.setValorDecimas(decimas.getValor());
        m.setValorSegundos(segundos.getValor());
        m.setValorMinutos(minutos.getValor());
        m.setValorHoras(horas.getValor());
        
        memorias.add(m);
        
    }
    /**
     * recorre un string y muestra sus datos
     * @return 
     */

    public String mostrarMemoriasGUI() {
        String a = "";
        for(Memoria memoria : memorias){
            a = (a+memoria.obtenerTiempo()+"<br>" );           
        }
        a = "<html>"+a+"</html>";
        System.out.println(a);
        return a;
    }
}

