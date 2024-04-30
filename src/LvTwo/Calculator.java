package LvTwo;

import java.util.ArrayList;

public class Calculator {
    private int result = 0;
    private boolean check = false;
    private ArrayList<Integer> intlist = new ArrayList<Integer>();
    private ArrayList<Double> doubleArrayListlist = new ArrayList<Double>();
    private final static double Circumference = 3.14; //원주율은 3.14 고정이라서 final 사용했습니다
    private double circum = 0;


    public Calculator() {
        intlist.clear();
    }

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

    //원의 넓이 구하는 공식
    public void setCircle(int fristnumber){
        circum = fristnumber+fristnumber*Circumference;
        check=true;
    }
    public double getCircum() {
        return circum;
    }
    public void setCirlist() {
        doubleArrayListlist.add(circum);
    }
    public void setCirRemove() {
        doubleArrayListlist.remove(0);
        System.out.println("삭제 되었습니다.");
    }

    public void getCirlist() {
        System.out.println("아래 조회된 값입니다.");
        for (Double doub : doubleArrayListlist) {
            System.out.println(doub);
        }
    }

}
