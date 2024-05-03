package LvTwo;

import java.util.ArrayList;

public class Calculator {
    private int result = 0;
    private boolean check = false;
    private ArrayList<Integer> intlist = new ArrayList<Integer>();


    public void setResult(int fristnumber, int secondnumber, char operate) throws BadOpertorException,ArithmeticException {
            switch (operate) {
                case '+' :
                    result = result + fristnumber;
                    check = true;
                    break;
                case '-' :
                    result = result - fristnumber;
                    check = true;
                    break;
                case '*' :
                    result = result * fristnumber;
                    check = true;
                    break;
                case '/' :
                    if (secondnumber == 0) {
                        throw new ArithmeticException();
                    }
                    result = result / fristnumber;
                    check = true;
                    break;
                default:
                    check = false;
                    throw new BadOpertorException();
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
