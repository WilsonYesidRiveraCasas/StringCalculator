/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Vista.TextAreaOutPut;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author huesped
 */
public class FlujoOutPut extends PrintStream{
    
    private TextAreaOutPut textConsole;
    
    public FlujoOutPut(TextAreaOutPut t){
        super(new OutputStream() {

            @Override
            public void write(int i) throws IOException {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        this.textConsole=t;
        
    }//end constructor
    
    @Override
    public void write(byte[] bytes) throws IOException {
       
    }
    
    @Override
    public void println(String string) {
        this.textConsole.addOut("\n"+string);      
      }

    @Override
    public void print(String string) {
         this.textConsole.addOut(string);
    }
}
