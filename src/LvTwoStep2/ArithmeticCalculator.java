package LvTwoStep2;

import LvTwo.BadOpertorException;

import java.util.ArrayList;

public class ArithmeticCalculator extends Calculator {
    ArrayList<Double> numbers = new ArrayList<Double>();

    static double result;
    private boolean check = false;

    AddOperator addOperator;
    SubtractOperator subtractOperator;
    MultiplyOperator multiplyOperator;
    DivideOperator divideOperator;
    ModOperator modOperator;

    public ArithmeticCalculator(AddOperator addOperator, SubtractOperator subtractOperator
            , MultiplyOperator multiplyOperator, DivideOperator divideOperator, ModOperator modOperator ) {
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
        this.modOperator = modOperator;
    }


    public ArithmeticCalculator() {
        numbers.clear();
    }

    public boolean getCheck(char operate) throws BadOpertorException {
            //연산식 이외에 문자가 들어오면 fail
            if (!(operate == ('+')) && !(operate == ('-')) && !(operate == ('*')) && !(operate == ('/'))) {
                throw new BadOpertorException();
            }
            check = true;
        return check;
    }

    public double getResult(int fristnumber ,int secondnumber,char operate) throws BadOpertorException {
        switch (operate) {
            case '+':
                result = addOperator.setResult(fristnumber,secondnumber);
                check = true;
                break;
            case '-':
                result = subtractOperator.setResult(fristnumber,secondnumber);
                check = true;
                break;
            case '*':
                result =multiplyOperator.setResult(fristnumber,secondnumber);
                check = true;
                break;
            case '/':
                if (secondnumber == 0) {
                    throw new ArithmeticException();
                }
                result = divideOperator.setResult(fristnumber,secondnumber);
                check = true;
                break;
            case '%':
                result =modOperator.setResult(fristnumber,secondnumber);
                check = true;
                break;
            default:
                check = false;
                throw new BadOpertorException();
        }
                return result;
    }

    public void setReMove() {
        numbers.remove(0);
        System.out.println("삭제 되었습니다.");
    }

    public void setAddList() {
        numbers.add(result);
    }

    @Override
    public void setList() {
        System.out.println("아래 조회된 값입니다.");
        for (Double doub : numbers) {
            System.out.println(doub);
        }
    }

    @Override
    double getResult() {
        return 0;
    }

    public boolean setCheck() {
        return check;
    }
    public void failgetCheck(){
        check = false;
    }
}
