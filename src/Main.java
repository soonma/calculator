import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int fristnumber;
            int secondnumber;
            String operate;
            Scanner input = new Scanner(System.in);
            System.out.print("첫번째 숫자를 입력 하세요: ");
            fristnumber = input.nextInt();
            System.out.print("두번째 숫자를 입력 하세요: ");
            secondnumber = input.nextInt();
            System.out.print("연산자를 입력 하세요 ");
            operate = input.next();
        }

}