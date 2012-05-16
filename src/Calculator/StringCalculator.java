/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author huesped
 */
public class StringCalculator {

    private String delimitador;
    
    //constructor
    public StringCalculator() {
    }
    
    /**Método que permite llevar a cabo la suma de cifras enteras incluidas
     * en una cadena, el procedimientos consiste en determinar si la cadena tiene
     * un patron determinado, en el cual decida cual es el caracter delimitador
     * por el cual va a separar las posibles cifra; El delimitador por defecto es ",";
     * Si la  cadena contiene números negativos debe lanzar una excepción; de igual forma lo 
     * hace si el caracter o conjunto de ellos no corresponde a un valor numérico
     * @param numbers {String} cadena que contiene las cifras para ser sumadas
     * @return valor numérico entero producto de la suma de las cifras encontradas.
     */
    public int add(String numbers) throws ExceptionCadena {

        //verifico si la cadena es vacía.
        if (numbers.isEmpty())return 0;
        this.delimitador=",";//delimitador por defecto
        
        //Es necesario verificar si la cadena tiene el formato "//[delimitador]\n
        Pattern expresion = Pattern.compile("^//[^0-9]+\\\n");//("^//[a-zA-Z$_]+|\\W+\\\\n");
        Matcher m = expresion.matcher(numbers);
        if (m.find()) {
                System.out.println("La cadena es del formato //[delimitador]\\n..");
                String s=m.group();//es necesario obtener el delimitador, group permite obtener la coincidencia de la expresion regular encontrada
                s=s.replaceAll("//", "");
                this.delimitador=s.replaceAll("\\\n", "");
                numbers=m.replaceAll("");
                System.out.println("El delimitador de la cadena: "+numbers+" es: "+this.delimitador);
        }
        
        //ahora es necesario verificar si hay saltos de lineas
        expresion = Pattern.compile("\\\n+");//Averiguo si la cadena tiene \n para aplicar al otro formato
        m = expresion.matcher(numbers);
        if (m.find()){
            Pattern expresion2 = Pattern.compile("(,\\\n)+|(\\\n,)+");//verifico que el formato sea correcto
            Matcher m2 = expresion2.matcher(numbers);
            if (m2.find()) {
                throw new ExceptionCadena("Formato de cadena no válido\nNo permitido: \",\\n\", ó \"\\n,\", ó \",\\n,\"");
            }else                    
                return this.sumar(m.replaceAll(this.delimitador));//reemplazo los \n por ,                
        }
        
        //si la cadena es del formato sencillo #,#,#,# o no tiene saltos de linea
        return this.sumar(numbers);
    }

    /**Método que permite llevar a cabo la sumatorio de las cifra que 
     * encuentra en la cadena separandola por el delimitador encontrado.
     * @param cadena {String} cadena String que contiene las cifras.
     * @return retorna un valor int de la suma de las cifras.
     * @exception lanza excepciones a raiz de numeros negativos o que no corresponde a un valor numérico
     */
    private int sumar(String cadena){
         String[] numeros;
        try{
            //validación para un caso especial con caracteres que entran en conflicto 
            //con la expresión regular que usa el método split.
            if(this.delimitador.equals("$")|this.delimitador.equals("|")|this.delimitador.equals("^")){
                this.delimitador="\\"+this.delimitador;
            }
            numeros = cadena.split(this.delimitador);//divido la cadena en partes por el delimitador ','
        }catch(Exception e){
             numeros = cadena.split("\\"+this.delimitador);//en caso que el caracter del delimitador entre en conflicto con operadores de JAva
        }

        int suma = 0;
        for (String g : numeros) {//proceso 
            try {
                if (g.isEmpty()) {
                    g = "0";
                }
                int num = this.positivo(g);
                if (num <= 1000) {
                    suma += num;//validar si es mayor a 1000                
                }
            } catch (ExceptionCadena e) {
                System.out.println(e.getException());
                continue;
            } catch (NumberFormatException e) {
                System.out.println("la cadena \"" + g + "\" no corresponde a un valor numérico. Es un String de longitud " + g.length() + " caracteres\nPOR FAVOR DIGITE SOLO NÚMEROS SEPARADOS POR EL DELIMITADOR CORRESPONDIENTE, SIN ESPACIOS\n");
                continue;
            }
        }
        return suma;
    }
    
   
    /**Método que verifica si una cadena corresponde a un valor numérico entero positivo
     * @param num {String} cadena que contiene la cifra.
     * @return valor int del número encontrado.
     * @exception lanza excepción si la cifra no corresponde a un valor numérico entero positivo
     */
    private int positivo(String num) throws ExceptionCadena {
        int cifra = Integer.parseInt(num);
        if (cifra < 0)//verifica que el número no sea negativo
        {
            throw new ExceptionCadena(cifra + " negatives not allowed");
        }
        return cifra;
    }

}
