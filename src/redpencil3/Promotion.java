/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redpencil3;

/**
 *
 * @author tonys
 */
public class Promotion {

    /**
     * InitialStableDays. Sets the number of days at a Stable price.
     *
     * @param stableDays Stable days.
     */
    Float price = 0.0F;
    Float reducedPrice = 0.0F;
    int stableDays = 0;

    public void InitialStableDays(int stableDays) {
        this.stableDays = stableDays;
    }

    /**
     * InitialPrice. Sets the Price for start of test.
     *
     * @param price Price value.
     */
    public void InitialPrice(Float price) {
        this.price = price;
    }

    /**
     * priceRedution . Reduces price to reducedPrice price.
     *
     * @param reducedPrice Price value.
     * @return true - if reduced price is with range otherwise false
     */
    public Boolean priceReduction(Float reducedPrice) {

        if (stableDays < 30) {
            return false;
        }

        Float low;
        Float high;

        low = price * .70F;
        high = price * .95F;

        if (reducedPrice.compareTo(low) < 0) {
            return false;
        }
        if (reducedPrice.compareTo(high) > 0) {
            return false;
        }

        this.stableDays = 0;
        this.reducedPrice = reducedPrice;

        return true;
    }

    /**
     * Determines is a promotion is Valid.
     *
     * @return true, if a promotion is valid otherwise false.
     */
    public Boolean promotionValid() {

        if ((stableDays >= 31) && (reducedPrice.compareTo(0.0F) == 0)) {
            return true;
        }
        return false;
    }
    
        /**
     * Further reduces a reduced price promotion. if reduction is out of range
     * it with sets reducedPrice and StableDays to zero
     *
     * @param reduction the price to reduce reducedPrice too.
     */
    public void furtherPriceReduction(Float reduction) {

        Float low;
        Float high;

        low = price * .70F;

        System.out.println(" compare reduction " + reduction);

        if (reduction.compareTo(low) < 0) {

            System.out.println(" compare low = " + reducedPrice.compareTo(low));
            System.out.println("reducedPrice = " + reducedPrice);

            stableDays = 0;
            reducedPrice = 0.0F;

            System.out.println("low = " + low + " " + "reduction " + reduction);
            return;
        }

        reducedPrice = reduction;

    }

    /**
     * Increases the cost of an item. sets reducedPrice and StableDays to zero
     *
     * @param price The price to increase to.
     */
    public void costIncrease(Float price) {
        if (reducedPrice.compareTo(price) < price) {
            this.price = price;
            reducedPrice = 0.0F;
            stableDays = 0;
        }
    }


}
