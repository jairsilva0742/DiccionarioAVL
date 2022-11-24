/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package arbol.binario.listaligada.busqueda.avl.ejemplos.diccionario;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;

public class Palabra implements Comparable<Palabra>  {

    private String cadena;
    private String significado;
    private  ArbolAVL sinonimos;
    private  ArbolAVL antonimos;
    
    public Palabra(String palabra) {
        
        //this.cadena = palabra;
        //ver como leonardo ingresa este
        sinonimos = new ArbolAVL();
        antonimos = new ArbolAVL();
        convertirHilera(palabra);

    }
    public Palabra() {
        sinonimos = new ArbolAVL();
        antonimos = new ArbolAVL();
    }

    public String getPalabra() {
        return cadena;
    }
    
        public String getSignificado() {
        if(significado!=null){
        return significado;}
        else{
        return "";}
    }

    public void setPalabra(String palabra) {
        this.cadena = palabra;
    }

       public void setSignificado(String significado) {
                      
        this.significado = significado;
    }
       
    public ArbolAVL getAntonimos() {
        
        return antonimos;
    }      
       
      public void setAntonimos(ArbolAVL antonimos) {
        this.antonimos = antonimos;
    }
    public ArbolAVL getsinonimos() {
        
        return sinonimos;
    }      
       
      public void setSinonimos(ArbolAVL sinonimos) {
        this.sinonimos = sinonimos;
    }
    
    public void insertarPosicion( int p ) throws Exception{
        //arbolPosiciones.insertar(p);
    }

public void convertirHilera(String cadena){
        
       
        //Determino cuantos atributos estoy ingresando en la cadena
       char[] caracteres= cadena.toCharArray();
       int h=0;
       int numeroAtributos=0;
       while(h<caracteres.length){
       if(caracteres[h]=='/'|| caracteres[h]==':'){
       numeroAtributos++;
       }
       h++;
       }
           
       switch(numeroAtributos){    
       case 1: 
       this.cadena=cadena.split("\\/")[0];
       System.out.println(this.cadena);
       break;

       case 2: 
       this.cadena=cadena.split("\\/")[0];
       this.significado=cadena.split("\\:")[1];
       System.out.println(this.cadena);
       System.out.println(this.significado);
       break;
       
       case 3:     
       this.cadena=cadena.split("\\/")[0];
       this.significado=cadena.split("\\:")[1];
       String anton=cadena.split("\\:")[2];
       System.out.println(this.cadena);
       System.out.println(this.significado);
       System.out.println(anton);
       //Calculo cuantos antonimos hay recorriendo anton      
       int i=0;
       int cAntonimos=1;
       while(i<anton.length()){
        if(anton.charAt(i)==','){
        cAntonimos++;        
        }
        i++;
        }
        //Saco cada uno de los antonimos y los voy guardando en el ArbolAVL de antonimos
        int k=0;
        while(k<cAntonimos){
        String p=anton.split("\\,")[k].trim();
        if(antonimos.buscar(p)==null){
        Palabra constructor=new Palabra(p);    
        antonimos.insertarDato(constructor);
        }
        k++;
        } 
       break;
       
       case 4:       
       this.cadena=cadena.split("\\/")[0];
       this.significado=cadena.split("\\:")[1];
       String anton2=cadena.split("\\:")[2];
       String sin= cadena.split("\\:")[3];
       System.out.println(this.cadena);
       System.out.println(this.significado);
       System.out.println(anton2);
       System.out.println(sin);
       
       //Calculo cuantos antonimos hay recorriendo anton2      
       int i2=0;
       int cAntonimos2=1;
       while(i2<anton2.length()){
        if(anton2.charAt(i2)==','){
        cAntonimos2++;        
        }
        i2++;
        }
        //Saco cada uno de los antonimos y los voy guardando en el ArbolAVL de antonimos
        int k2=0;
        while(k2<cAntonimos2){
        String p=anton2.split("\\,")[k2].trim();
        if(antonimos.buscar(p)==null){
        Palabra constructor=new Palabra(p);
        antonimos.insertarDato(constructor);
        }
        k2++;
        }           
       //Calculo cuantos sinonimos hay recorriendo sin      
        int j=0;
       int cSinonimos=1;
       while(j<sin.length()){
        if(sin.charAt(j)==','){
        cSinonimos++;        
        }
        j++;
        }
        //Saco cada uno de los sinonimos y los voy guardando en el ArbolAVL de sinonimos
        int q=0;
        while(q<cSinonimos){
        String p=sin.split("\\,")[q].trim();
        if(sinonimos.buscar(p)==null){
        Palabra constructor=new Palabra(p);    
        sinonimos.insertarDato(constructor);
        }
        q++;
        }
        break;
        
       default:
       this.cadena=cadena;
       System.out.println(this.cadena);
       break;
       }
        }

  

    @Override
    public int compareTo(Palabra o) {
        Palabra t = (Palabra) o;
        Comparable pb = t.getPalabra();
        return cadena.compareTo((String) pb);
    }

}
