package LvTwoStep2;

public class BadInputException extends Exception {
    public  BadInputException(){
        System.out.println("입력을 잘못했습니다. 다시 해주세요");
    }
}
