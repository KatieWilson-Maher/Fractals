/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mandelbrot0;

/**
 *
 * @author katie
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author katie
 */
public class Simple extends JFrame {
    private static final int SIMPLE_WIDTH = 500;
    private final int SIMPLE_HEIGHT = 500;
    private static final String SIMPLE_TITLE = "Simple";
    
    public Simple(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIMPLE_WIDTH, SIMPLE_HEIGHT);
        this.setTitle(SIMPLE_TITLE);
        
        Container pane = this.getContentPane();
        
        SimpleBitMap panel = new SimpleBitMap();
        pane.add(panel);
        
        
        this.setVisible(true);
        
    }
    
    public static void main(String[] args){
        Simple simple = new Simple();
    }
    
}

