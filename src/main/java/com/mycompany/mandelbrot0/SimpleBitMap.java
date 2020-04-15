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
import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author katie
 */
public class SimpleBitMap extends JPanel {

    private static final int SIMPLEBITMAP_WIDTH = 500;
    private static final int SIMPLEBITMAP_HEIGHT = 500;
    private BufferedImage simpleBitMapImage;
    private static final int THRESHOLD = 50;
    public static double u0 = -2;
    public static double u1 = 2;
    public static double v0 = -2;
    public static double v1 = 2;
    //private final ArrayList<int[]> colors = new ArrayList<int[]>();
    private final int[][] colors = new int[51][3]; ;
    public SimpleBitMap() {
        int w = SIMPLEBITMAP_WIDTH;
        int h = SIMPLEBITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.simpleBitMapImage = new BufferedImage(w, h, imageType);
        
        Random rand = new Random(); 
        for (int i = 0; i <= 49; i++){
            int rand1 = rand.nextInt(255);
            int rand2 = rand.nextInt(255);
            int rand3 = rand.nextInt(255);
            colors[i][0]= rand1 ; colors[i][1]=rand2 ; colors[i][2] = rand3 ;
        }
        colors[50][0] = 0;
        colors[50][1] = 0;
        colors[50][2] = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform scale = new AffineTransform();
        //scale.setToScale(((double) w / SIMPLEBITMAP_WIDTH), ((double) h / SIMPLEBITMAP_HEIGHT));

        scale.setToScale(1,1);
        
        WritableRaster raster = this.simpleBitMapImage.getRaster();
//        
//        for (int j = 0; j < h; j++){
//            for (int i = 0; i < w; i++){
//                if (i<j){
//                    raster.setPixel(i, j, yellow);
//                }
//                else {
//                    raster.setPixel(i, j, black);
//                }
//            }
//        }
//        g2d.drawImage(simpleBitMapImage, scale, this);


        for (int row = 0; row < SIMPLEBITMAP_HEIGHT; row++) {
            for (int column = 0; column < SIMPLEBITMAP_WIDTH; column++) {
                // Create z with components (0.0, 0.0)
                Complex z = new Complex(0, 0);
                // Create c with components map(row, column)
                double realC = (((double) column)/w) * (u1 - u0) + u0;
                double imaginaryC = (((double)row)/h) * (v1 - v0) + v0;
                Complex c = new Complex(realC, imaginaryC);
                int count = 0;
                while ((z.mag() < 2.0) && (count < THRESHOLD)) {
                    //System.out.println(count);
                    z = z.product(z);
                    z = z.sum(c);
                    count++;
                } // while

                // use count to assign a color to the pixel at (row, column)
                //System.out.println("row: "+row+" column: "+column+" count: "+count);
                raster.setPixel(column, row, colors[count]);
                //System.out.println("row: "+row+" column: "+column+" count: "+count+" mag: "+z.mag());
            } // for
        } // for
        
        g2d.drawImage(simpleBitMapImage, scale, this);
    }
}
