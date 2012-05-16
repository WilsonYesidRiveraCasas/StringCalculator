/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JTextArea;

/**
 *
 * @author huesped
 */
public class TextAreaOutPut extends JTextArea {
    
    public void addOut(String msg){
        this.setText(this.getText()+msg);
    }
    
}
