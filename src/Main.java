import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fristnumber;
        int secondnumber;
        int result = 0;
        String countinueYN;

        while (true) {
            String operate;
            Scanner input = new Scanner(System.in);
            System.out.print("첫번째 숫자를 입력 하세요: ");
            fristnumber = input.nextInt();
            System.out.print("두번째 숫자를 입력 하세요: ");
            secondnumber = input.nextInt();
            System.out.print("연산자를 입력 하세요 ");
            operate = input.next();

            if (operate.equals("+")) {
                result = fristnumber + secondnumber;
            } else if (operate.equals("-")) {
                result = fristnumber - secondnumber;
            } else if (operate.equals("*")) {
                result = fristnumber * secondnumber;
            } else if (operate.equals("/")) {
                result = fristnumber / secondnumber;
            } else if (operate.equals("%")) {
                result = fristnumber % secondnumber;
            }

            System.out.println("결과: " + result);
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");

            countinueYN = sc.nextLine();
            if (countinueYN.equals("exit")) {
                break;
            }
        }
    }

}