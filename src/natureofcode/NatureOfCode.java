/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


 */
package natureofcode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.Timer;
import javax.swing.JFrame;
/**
 *
 * @author Dustin Hu
 */
public class NatureOfCode {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {
        // TODO code application logic here
        
        Vector l = new Vector(10, 10);
        Vector v = new Vector(2, 2);
        Vector a = new Vector(1, 1);
        a.randomizeSelf();
        Mover M = new Mover(l, v, a);
        Ball aBall = new Ball(5, M);
        
        SketchPanel sp = new SketchPanel(aBall);

        JFrame frame = new JFrame("Nature of Code");
        frame.getContentPane().add(sp, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
        
        Timer time = new Timer(50, new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                sp.aFunction();
            }
        });
        time.start();

    }
    
    
}