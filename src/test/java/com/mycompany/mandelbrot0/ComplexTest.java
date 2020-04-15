/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mandelbrot0;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author katie
 */
public class ComplexTest {
    
    private static final double EPSILON = 1E-8;
    
    public ComplexTest() {
    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

    /**
     * Test of sum method, of class Complex.
     */
    @Test
    public void testSum() {
        //Complex expected = 
    }

    /**
     * Test of product method, of class Complex.
     */
    @Test
    public void testProduct() {
        Complex expected = new Complex(-9,38);
        Complex c1 = new Complex(3,4);
        Complex c2 = new Complex(5,6);
        Complex actual = c1.product(c2);
        String expectedString = expected.real + " + " + expected.imaginary + "i";
                
        String a = String.valueOf(actual.real);  
        
        String actualString = String.valueOf(actual.real) + " + " + String.valueOf(actual.imaginary) + "i";
                
        assertEquals(expectedString, actualString);
    }

    /**
     * Test of mag method, of class Complex.
     */
    @Test
    public void testMag() {
        double expected = 5;
        Complex c = new Complex(-4, -3);
        double actual = c.mag();
        assertEquals(expected, actual);
        
    }

    /**
     * Test of toString method, of class Complex.
     */
    @Test
    public void testToString() {
        String expected = "3.0 + 4.0i";
        Complex c = new Complex(3,4);
        String actual = c.toString();
        assertEquals(expected, actual);
    }
}


