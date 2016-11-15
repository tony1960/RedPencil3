/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redpencil3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tonys
 */
public class PromotionTest {

    public PromotionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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
    public void testInitialStableDays() {
        System.out.println("testInitialStableDays");
        Promotion instance = new Promotion();
        int days = 0;
        int expectedResult = 29;
        instance.InitialStableDays(29);
        int result = instance.stableDays;

        assertEquals(expectedResult, result);
    }

    @Test
    public void testInitialPrice() {
        System.out.println("testInitialPrice");
        Promotion instance = new Promotion();

        Float price = 0.0F;
        Float expectedResult = 10.0F;
        instance.InitialPrice(10.0F);
        Float result = instance.price;

        assertEquals(expectedResult, result, 0.01);
    }

}
