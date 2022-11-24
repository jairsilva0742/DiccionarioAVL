/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.avl.ejemplos.diccionario;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.busqueda.avl.NodoAVL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Usuario
 */
public class Diccionario extends ArbolAVL {
    
    private int cantidad;
    private final JTextArea jTextAreaResultado;
    NodoAVL nodoBusqueda;

    Diccionario(JTextArea jTextAreaResultado) throws IOException, Exception {
        this.cantidad = 0;
        this.jTextAreaResultado = jTextAreaResultado;
        load();
        
    }

    public void insertar(Palabra dato) throws Exception {
        try{
        if (super.buscar((String)dato.getPalabra()) == null) {
            if( super.insertarDato(dato) == null){
                throw new Exception("Error al insertar la palabra " + dato.getPalabra());
            }
            cantidad++;
            //jTextAreaResultado.setText((String)dato.getPalabra());
        }}catch(Exception e){
            System.out.println("Hubo un error");
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public final void load() throws FileNotFoundException, IOException, Exception {
        BufferedReader in = new BufferedReader(new FileReader("Spanish.dic"));
        String palabra;
        
        while ((palabra = in.readLine()) != null) {
           //palabra=palabra.split("\\/")[0];
            Palabra p=new Palabra(palabra);//constructor con mas atrubitos
            //p.convertirHilera(palabra);
            insertar(p);
            
        }
        
    }

    public NodoAVL getNodoBusqueda(){
        return nodoBusqueda;
    }
   public void eliminar(){
       
   }
    
   public String buscar1(String dato) {
       String resultado;
       
        if ( super.buscar(dato) == null) {
            resultado=" La palabra " + dato + " No se encuentra";
            return resultado;
            
        } else {
            nodoBusqueda=super.buscar(dato);
            resultado=" Urra!!! Palabra encontrada "+nodoBusqueda.getDato().getPalabra();
            return resultado;
           
            
        }
        
    }
   


}
