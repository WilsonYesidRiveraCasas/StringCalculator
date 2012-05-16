/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author huesped
 */
public class Control_Calculator {
    
    
    public static int add(String cadena){
        try {
            return new StringCalculator().add(cadena);
        } catch (ExceptionCadena ex) {
            System.err.println(ex.getMessage());
        }catch(NumberFormatException e){
            System.err.println(e.getMessage());
        }
        return 0;
    }
}
