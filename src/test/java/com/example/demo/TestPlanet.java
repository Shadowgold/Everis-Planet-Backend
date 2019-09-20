package com.example.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.demo.Entity.Planet;

import static org.junit.Assert.*;

/**
 *
 * @author Agustin
 */
public class TestPlanet {
    
    static Planet instance;
    public TestPlanet() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Planet();
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
        
        String expResult = "Tierra";
        instance.setName("Tierra");
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetName() {
        System.out.println("setNombre");
        String nombre = "Marte";
        String expResult="Marte";
        instance.setName(nombre);
        assertEquals(expResult, instance.getName());
    }

    @Test
    public void testGetSize() {
        System.out.println("getSize");
        
        int expResult = 5;
        instance.setSize(5);
        int result = instance.getSize();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int tamaño = 500;
        int expResult =500;
        instance.setSize(tamaño);
        assertEquals(expResult, instance.getSize());
    }
    
}