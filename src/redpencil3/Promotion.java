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

    
}
