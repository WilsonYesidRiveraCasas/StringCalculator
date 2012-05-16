/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author huesped
 */
public class ExceptionCadena extends Exception{
    
    ExceptionCadena(){
        super();
    }
    
    ExceptionCadena(String cadena){
        super(cadena);
    }
    
    public String getException(){
        return this.getMessage();
    }
    
}
