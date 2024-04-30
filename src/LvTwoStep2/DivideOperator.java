package LvTwoStep2;

public class DivideOperator extends ArithmeticCalculator{
    public double setResult (int fristnumber, int secondnumber){
        try {
            super.result = fristnumber / secondnumber;
                    }catch (ArithmeticException e){
            System.out.println("/ 중 값이 0이 들어왔습니다 . 다시 해주세요");
        }
        return fristnumber / secondnumber;
    }
}
