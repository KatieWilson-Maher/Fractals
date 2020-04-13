/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mandelbrot0;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author katie
 */
public class SimpleBitMap extends JPanel {
    
    private static final int SIMPLEBITMAP_WIDTH = 500;
    private static final int SIMPLEBITMAP_HEIGHT = 500;
    private BufferedImage simpleBitMapImage;
    
    public SimpleBitMap(){
        int w = SIMPLEBITMAP_WIDTH;
        int h = SIMPLEBITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.simpleBitMapImage = new BufferedImage(w, h, imageType);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        int w = this.getWidth();
        int h = this.getHeight();
        
        AffineTransform scale = new AffineTransform();
        scale.setToScale(((double) w / SIMPLEBITMAP_WIDTH), ((double) h / SIMPLEBITMAP_HEIGHT));
    
        WritableRaster raster = this.simpleBitMapImage.getRaster();
        
                
        int[] black = {0, 0, 0};
        int[] yellow = {255, 255, 0};
        
        for (int j = 0; j < h; j++){
            for (int i = 0; i < w; i++){
                if (i<j){
                    raster.setPixel(i, j, yellow);
                }
                else {
                    raster.setPixel(i, j, black);
                }
            }
        }
             g2d.drawImage(simpleBitMapImage, scale, this);
    }
    
}
