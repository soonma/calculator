package LvThree;

import java.util.ArrayList;

public class CircleCalculator extends Calculator {
    private final static double Circumference = 3.14;
    private double result;
    private boolean check = true;

    ArrayList<Double> doubleArrayListlist = new ArrayList<>();



    public CircleCalculator() {
        doubleArrayListlist.clear();
    }
    public boolean getCheck() {
        return check;
    }
    public double getResult() {
        return result;
    }
    public boolean setCheck() {
        return check;
    }



    @Override
    public void setList() {
        System.out.println("아래 조회된 값입니다.");
        for (Double doub : doubleArrayListlist) {
            System.out.println(doub);
        }
    }
    public void setReMove() {
        doubleArrayListlist.remove(0);
        System.out.println("삭제 되었습니다.");
    }

    public void setAddList(){
        doubleArrayListlist.add(result);
    }

    public double getCircleResult(int firstNumber) {
        try {
            if(firstNumber == 0) {
                throw new BadNotIntgerException();
            }
            result = firstNumber * firstNumber*Circumference;
            check=true;
        } catch (BadNotIntgerException e) {
            check = false;
        }
        return result;
    }
}
