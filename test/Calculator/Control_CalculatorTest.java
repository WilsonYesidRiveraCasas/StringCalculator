/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author huesped
 */
public class Control_CalculatorTest {
    
    public Control_CalculatorTest() {
    }

    
    /**
     * Clase que usa JUnit para llevar a cabo pruebas de unidad
     * del método add() de StringCalculator
     * 
     * Se llevarán a cabo las siguientes pruebas:
     * 
     * - caso de prueba 1: simple de numeros de una cifra.
     * - caso de prueba 2: de cadena con varios números.
     * - caso de prueba 3: de saltos de línea formato "# \n #,#"
     * - caso de prueba 4: de cambio de delimitador.
     * - caso de prueba 5: de cifras mayores a 1000
     * - caso de prueba 6: de cambio de delimitador por uno de longitud variable
     * - caso de prueba 7: cadena con cifras negativas, y no numéricas
     */
    
    
    //caso de prueba 1
    @Test
    public void testAdd1() {
        System.out.println("Caso de Prueba 1");
        String []cadena = {"","1","1,2"};
        String resultadoEsperado = " 0 1 3";
        String resultadoObtenido= "";
        for(int i=0;i<cadena.length;i++){
            resultadoObtenido+=(" "+Control_Calculator.add(cadena[i]));
        }
        System.out.println("cifras evaluadas: \"empty\", \"1\", \"1,2\" \nresultadoEsperado: "+resultadoEsperado+"\nresultadoObtenido: "+resultadoObtenido);
        Assert.assertEquals(resultadoEsperado, resultadoObtenido);
    }
    /*
     */
    @Test
    public void testAdd2() {
        System.out.println("\nCaso de Prueba 2");
        String cadena = "23,12,34,12,32,44,16,2,32,11,34,22,8,6,3,2,1,,3,2";
        int resultadoEsperado = 299;
        int resultadoObtenido=Control_Calculator.add(cadena);        
        System.out.println("cifras evaluadas: \"23,12,34,12,32,44,16,2,32,11,34,22,8,6,3,2,1,,3,2\" \nresultadoEsperado: "+resultadoEsperado+"\nresultadoObtenido: "+resultadoObtenido);
        Assert.assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
    @Test
    public void testAdd3() {
        System.out.println("\nCaso de Prueba 3");
        String cadena = "1\n2,3\n4,2";
        int resultadoEsperado = 12;
        int resultadoObtenido=Control_Calculator.add(cadena);        
        System.out.println("cifras evaluadas: \"1\\n2,3\\n4,2\" \nresultadoEsperado: "+resultadoEsperado+"\nresultadoObtenido: "+resultadoObtenido);
        Assert.assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
    @Test
    public void testAdd4() {
        System.out.println("\nCaso de Prueba 4");
        String cadena = "//;\n1;2;5;;2";
        int resultadoEsperado = 10;
        int resultadoObtenido=Control_Calculator.add(cadena);        
        System.out.println("cifras evaluadas: \"//;\\n1;2;5;;2\" \nresultadoEsperado: "+resultadoEsperado+"\nresultadoObtenido: "+resultadoObtenido);
        Assert.assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
    @Test
    public void testAdd5() {
        System.out.println("\nCaso de Prueba 5");
        String cadena = "//;\n1;2;1200;2;2";
        int resultadoEsperado = 7;
        int resultadoObtenido=Control_Calculator.add(cadena);        
        System.out.println("cifras evaluadas: \"//;\\n1;2;1200;2;2\" \nresultadoEsperado: "+resultadoEsperado+"\nresultadoObtenido: "+resultadoObtenido);
        Assert.assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
    @Test
    public void testAdd6() {
        System.out.println("\nCaso de Prueba 6");
        String cadena = "//;;;;\n1;;;;2;;;;120;;;;2;;;;2";
        int resultadoEsperado = 127;
        int resultadoObtenido=Control_Calculator.add(cadena);        
        System.out.println("cifras evaluadas: \"//;;;;\\n1;;;;2;;;;120;;;;2;;;;2\" \nresultadoEsperado: "+resultadoEsperado+"\nresultadoObtenido: "+resultadoObtenido);
        Assert.assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
    @Test
    public void testAdd7() {
        System.out.println("\nCaso de Prueba 7");
        String cadena = "-3,1,3,er,2,-2";
        int resultadoEsperado = 6;
        int resultadoObtenido=Control_Calculator.add(cadena);        
        System.out.println("cifras evaluadas: \"-3,1,3,er,2,-2\" \nresultadoEsperado: "+resultadoEsperado+"\nresultadoObtenido: "+resultadoObtenido);
        Assert.assertEquals(resultadoEsperado, resultadoObtenido);
    }
}
