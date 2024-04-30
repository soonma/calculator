package LvTwoStep2;



public class AddOperator extends ArithmeticCalculator {
    public double setResult(int fristnumber, int secondnumber){

        super.result = fristnumber + secondnumber;
        return (double) fristnumber + secondnumber;

    }
}
