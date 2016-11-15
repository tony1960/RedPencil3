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

    Promotion instance;

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
        instance = new Promotion();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInitialStableDays() {
        System.out.println("testInitialStableDays");
        int days = 0;
        int expectedResult = 29;
        instance.InitialStableDays(29);
        int result = instance.stableDays;

        assertEquals(expectedResult, result);
    }

    @Test
    public void testInitialPrice() {
        System.out.println("testInitialPrice");
        Float price = 0.0F;
        Float expectedResult = 10.0F;
        instance.InitialPrice(10.0F);
        Float result = instance.price;

        assertEquals(expectedResult, result, 0.01);
    }

    @Test
    public void testPriceReductionInRange() {
        System.out.println("testPriceReductionInRange");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 31;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(9.00F);

        assertTrue("Promotion", result);
    }
// adding test for out of Range Low, Low End point, Hight End Point and High
    //  high out of range 

    @Test
    public void testPriceReductiomLowEnd() {
        System.out.println("testPriceReductiomLowEnd");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 31;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(6.00F);

        assertFalse("Promotion", result);
    }

    @Test
    public void testPriceReductionLowEnd() {
        System.out.println("testPriceReductionLowEnd");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 31;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(7.0F);

        assertTrue("Promotion", result);
    }

}
