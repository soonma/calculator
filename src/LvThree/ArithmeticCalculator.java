package LvThree;

import LvTwo.BadOpertorException;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ArithmeticCalculator<T> extends Calculator {
    ArrayList<T> numbers = new ArrayList<>();
    //Stream<T> stream = numbers.stream();

    T result;
    private boolean check = true;
    static char operate = 0;

    public ArithmeticCalculator() {
        numbers.clear();
    }

    public boolean getCheck(char operate) {
        try {
            //연산식 이외에 문자가 들어오면 fail
            if (!(operate == ('+')) && !(operate == ('-')) && !(operate == ('*')) && !(operate == ('/'))) {
                throw new BadOpertorException();
            }
            this.operate = operate;
            check = true;
        } catch (BadOpertorException e) {
            check = false;
        }

        return check;
    }
    public void getArithmetic(double firstNumber, double secondNumber) {
        if (operate=='+'){
            OperatorType op = OperatorType.PLUS;
            System.out.println("결과: " + op.getBinaryOperator( firstNumber,secondNumber));
            setAddList();
        } else if (operate=='-'){
            OperatorType op = OperatorType.MINUS;
            System.out.println("결과: " + op.getBinaryOperator( firstNumber,secondNumber));
            setAddList();
        } else if (operate=='*'){
            OperatorType op = OperatorType.TIMED;
            System.out.println("결과: " + op.getBinaryOperator( firstNumber,secondNumber));
            setAddList();
        } else if (operate=='/'){
            OperatorType op = OperatorType.DIVIDE;
            System.out.println("결과: " + op.getBinaryOperator( firstNumber,secondNumber));
            setAddList();
        } else if(operate=='%'){
            OperatorType op = OperatorType.REMAIN;
            System.out.println("결과: " + op.getBinaryOperator( firstNumber,secondNumber));
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
        for (T doub : numbers) {
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
