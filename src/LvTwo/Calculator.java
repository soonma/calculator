package LvTwo;

import java.util.ArrayList;

public class Calculator {
    private int result = 0;
    private boolean check = false;
    private ArrayList<Integer> intlist = new ArrayList<Integer>();


    public void setResult(int fristnumber, int secondnumber, char operate)  {
        try {
            //연산식 이외에 문자가 들어오면 fail
            if (!(operate == ('+')) && !(operate == ('-')) && !(operate == ('*')) && !(operate == ('/'))) {
                throw new BadOpertorException();
            //숫자 이외에 문자가 들어오면 fail
            } else {
                if (operate == ('+')) {
                    result = fristnumber + secondnumber;
                } else if (operate == ('-')) {
                    result = fristnumber - secondnumber;
                } else if (operate == ('*')) {
                    result = fristnumber * secondnumber;
                } else if (operate == ('/')) {
                    result = fristnumber / secondnumber;
                }
                check = true;
            }
        } catch ( ArithmeticException e) {
            check = false;
            System.out.println("피연산자 중에 값이 0 이있습니다. 다시 해주세요");
        } catch (BadOpertorException e) {
            check = false;
        }

    }


    public void setIntlist() {
        intlist.add(result);
    }

    public void setRemove() {
        intlist.remove(0);
        System.out.println("삭제 되었습니다.");
    }

    public void setInquiry() {
        System.out.println("아래 조회된 값입니다.");
        for (Integer integer : intlist) {
            System.out.println(integer);
        }
    }

    public int getResult() {
        return result;
    }
    public boolean getCheck() {
        return check;
    }
}
