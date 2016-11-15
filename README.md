
These files represent a solution for the Red Pencil Kata.
To execute simplely type 'ant' in the topmost directory. The code will build and
execute the junit tests.

Important Directories.
src   -  Contains the code for the program. The methods priceReduction,
        promotionValid, addtionalPromotionValid test to determine is a promotion
        is valid given the currect state. The methods InitialPrice, InitialStableDays
        costIncrease actual set values and effect internal state.

        Promotion
        ---------
        public void InitialStableDays(int days)

        public void InitialPrice(Float price)

        public Boolean priceReduction(Float reducedPrice)

        public Boolean promotionValid()

        public void furtherPriceReduction(Float reduction)

        public void costIncrease(Float price)

        public Boolean addtionalPromotionValid()

test -  Contains the JUNIT test code for this progam


