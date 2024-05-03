package LvThree;

import LvTwo.BadOpertorException;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ArithmeticCalculator extends Calculator {
    ArrayList<Double> numbers = new ArrayList<>();
    //Stream<T> stream = numbers.stream();

    double result;
    private boolean check = true;
    static char operate = 0;

    public ArithmeticCalculator() {
        numbers.clear();
    }

    public boolean getCheck(char operate) throws BadOpertorException {

            //연산식 이외에 문자가 들어오면 fail
            if (!(operate == ('+')) && !(operate == ('-')) && !(operate == ('*')) && !(operate == ('/'))) {
                throw new BadOpertorException();
            }
            this.operate = operate;
            check = true;
        return check;
    }
    public void getArithmetic(double firstNumber, double secondNumber) {
        if (operate=='+'){
            OperatorType op = OperatorType.PLUS;
            result =op.getBinaryOperator( firstNumber,secondNumber);
            System.out.println("결과: " + result);
            setAddList();
        } else if (operate=='-'){
            OperatorType op = OperatorType.MINUS;
            result =op.getBinaryOperator( firstNumber,secondNumber);
            System.out.println("결과: " + result);
            setAddList();
        } else if (operate=='*'){
            OperatorType op = OperatorType.TIMED;
            result =op.getBinaryOperator( firstNumber,secondNumber);
            System.out.println("결과: " + result);
            setAddList();
        } else if (operate=='/'){
            OperatorType op = OperatorType.DIVIDE;
            result =op.getBinaryOperator( firstNumber,secondNumber);
            System.out.println("결과: " + result);
            setAddList();
        } else if(operate=='%'){
            OperatorType op = OperatorType.REMAIN;
            result = op.getBinaryOperator( firstNumber,secondNumber);
            System.out.println("결과: " + result);
            setAddList();
        }

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
        return result;
    }

    public boolean setCheck() {
        return check;
    }
    public void failgetCheck(){
        check = false;
    }
}
