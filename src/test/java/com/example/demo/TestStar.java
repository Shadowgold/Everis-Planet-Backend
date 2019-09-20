package com.example.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.demo.Entity.Star;

import static org.junit.Assert.*;

/**
 *
 * @author Agustin
 */
public class TestStar {
    
    static Star instance;
    public TestStar() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Star();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        
        String expResult = "Sol";
        instance.setName("Sol");
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetName() {
        System.out.println("setNombre");
        String nombre = "Alfa Centauri";
        String expResult="Alfa Centauri";
        instance.setName(nombre);
        assertEquals(expResult, instance.getName());
    }

    @Test
    public void testGetDensity() {
        System.out.println("getDensity");
        
        int expResult = 5;
        instance.setDensity(5);
        int result = instance.getDensity();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetDensity() {
        System.out.println("setDensity");
        int densidad = 500;
        int expResult =500;
        instance.setDensity(densidad);
        assertEquals(expResult, instance.getDensity());
    }
    
}
