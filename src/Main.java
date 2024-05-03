import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> intlist = new ArrayList<Integer>();
        int fristnumber;
        int secondnumber;
        int result = 0;


        String Scan;
        int arraycnt = 0;

        String operate;
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.print("첫번째 숫자를 입력 하세요: ");
            fristnumber = input.nextInt();
            System.out.print("두번째 숫자를 입력 하세요: ");
            secondnumber = input.nextInt();
            System.out.print("연산자를 입력 하세요 ");
            operate = input.next();


//            7. 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정합니다.
//            - JCF(Java Collection Framework)를 사용합니다. (e.g. List, Set …)
//            - “remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록 구현합니다.
//            8. **inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력합니다.**
//            - foreach(향상된 for문)을 활용하여 구현 해봅니다.

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

            intlist.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            Scan = sc.nextLine();

            if (Scan.equals("remove")) {
                intlist.remove(0);
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            Scan = sc.nextLine();

            if (Scan.equals("inquiry")) {
                for(Integer integer : intlist) {
                    System.out.println(integer);
                }
            }

            arraycnt++;
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : " + arraycnt + " 번째");

            Scan = sc.nextLine();
            if (Scan.equals("exit")) {
                break;
            }
        }


    }
}




