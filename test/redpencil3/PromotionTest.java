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

    @Test
    public void testPriceReductionHighEndPoint() {
        System.out.println("priceReduction");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 31;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(9.5F);

        assertTrue("Promotion", result);
    }

    @Test
    public void testPriceReductionHigh() {
        System.out.println("testPriceReductionHigh");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 31;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(9.6F);

        assertFalse("Promotion", result);
    }

    @Test
    public void testPriceReductionFewerDays() {
        System.out.println("testPriceReductionFewerDays");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 29;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(9.00F);

        assertFalse("Promotion", result);
    }

    // reemove
    @Test
    public void testPriceReductiomLowEndFewerDays() {
        System.out.println("testPriceReductiomLowEndFewerDays");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 29;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(9.00F);

        assertFalse("Promotion", result);
    }

    @Test
    public void testPriceReductionHighFewerDays() {
        System.out.println("testPriceReductionHighFewerDays");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 29;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(9.6F);

        assertFalse("Promotion", result);
    }

    @Test
    public void testPriceReductionLowEndFewerDays() {
        System.out.println("testPriceReductionLowEndFewerDays");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 29;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(7.0F);

        assertFalse("Promotion", result);
    }

    @Test
    public void testPriceReductionHighEndFewerDay() {
        System.out.println("testPriceReductionHighEndFewerDay");
        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int days = 29;
        instance.InitialStableDays(days);
        Boolean result = instance.priceReduction(9.5F);

        assertFalse("Promotion", result);
    }

    // Test if a promotioin is Valid
    //
    @Test
    public void testpromotionValid() {
        System.out.println("testpromotionValid");
        int days = 29;
        instance.InitialStableDays(days);
        Boolean result = instance.promotionValid();
        assertFalse("Promotion", result);

    }

    @Test
    public void testpromotionValidEndPoint() {
        System.out.println("testpromotionValidMoreDays");
        int days = 30;
        instance.InitialStableDays(days);
        Boolean result = instance.promotionValid();
        assertFalse("Promotion", result);
    }

    @Test
    public void testpromotionValidMoreDays() {
        System.out.println("testpromotionValidMoreDays");
        int days = 31;
        instance.InitialStableDays(days);
        Boolean result = instance.promotionValid();
        assertTrue("Promotion", result);
    }

    //
    
        
    
    
    @Test
    public void testFurtherPriceReductionRange() {
        System.out.println("testFurtherPriceReductionOutofRangePrice");

        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        Float expectedResult = 7.0F;
        instance.priceReduction(8.0F);
        Float futherReduction = 7.0F;
        instance.furtherPriceReduction(futherReduction);
        Float result = instance.reducedPrice;
        assertEquals(expectedResult, result, .001);
    }

    @Test
    public void testFurtherPriceReductionOutofRange() {
        System.out.println("testFurtherPriceReductionOutofRangeDays");

        Float initPrice = 10.0F;
        instance.InitialPrice(initPrice);
        int expectedResult = 0;
        instance.priceReduction(8.0F);
        Float futherReduction = 6.0F;
        instance.furtherPriceReduction(futherReduction);
        int result = instance.stableDays;
        assertEquals(expectedResult, result);
    }
    
    
    @Test
    public void TestcostIncreasePrice() {
        System.out.println("costIncreasePrice");
        Float initPrice = 10.0F;
        Float reducedPrice = 8.0F;
        Float expectedResult = 11.0F;
        instance.InitialPrice(initPrice);
        instance.furtherPriceReduction(reducedPrice);
        Float priceIncrease = 11.0F;
        instance.costIncrease(priceIncrease);
        Float result = instance.price;
        assertEquals(expectedResult, result, 0.001F);
    }

    @Test
    public void testCostIncreaseDays() {
        System.out.println("costIncreaseDays");
        Float initPrice = 10.0F;
        Float reducedPrice = 8.0F;
        int expectedResult = 0;
        instance.InitialPrice(initPrice);
        instance.furtherPriceReduction(reducedPrice);
        Float priceIncrease = 11.0F;
        instance.costIncrease(priceIncrease);
        int result = instance.stableDays;
        assertEquals(expectedResult, result);
    }

}
