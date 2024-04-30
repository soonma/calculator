package LvTwoStep2;

public class BadOpertorException extends Exception {
    public BadOpertorException() {
        System.out.println("연산자가 잘못 들어 왔습니다. 다시 입력해주세요");
    }
}
