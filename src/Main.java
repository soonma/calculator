import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fristnumber;
        int secondnumber;
        int result = 0;
        int[] arr = new int[10];
        int chago = 0;
        String countinueYN;
        int arrycnt = 0;
        boolean flag = false;

        String operate;
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.print("첫번째 숫자를 입력 하세요: ");
            fristnumber = input.nextInt();
            System.out.print("두번째 숫자를 입력 하세요: ");
            secondnumber = input.nextInt();
            System.out.print("연산자를 입력 하세요 ");
            operate = input.next();

//            5. 연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성하고 연산의 결과를 저장합니다.
//                    - 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다.
//                    - 연산의 결과를 비어있는 곳에 저장하기 위해 저장할 때마다 count 합니다.
//            연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정합니다.
//            현재 저장된 index가 마지막(9)라면 가장 먼저 저장된 결과 값이 삭제 되고 새로운 결과 값이 마지막 index에 저장될 수 있도록 구현합니다
            try {
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
                flag = true;
            } catch (ArithmeticException e) {
                System.out.println("피연사 중에 값이 0이 들어 갔습니다 확인부탁드립니다.");
                flag = false;
            }
            if (flag) {
                chago = result;
                //i가 10 이상 , 즉 배열의 입력 값을 초과 했을때 값을 밀어 내는 방식의 코드
                if (arrycnt >= arr.length) {
                    for (int j = 0; j < arr.length; j++) {
                        if (j == arr.length - 1) {
                            arr[j] = chago;
                        } else {
                            arr[j] = arr[j + 1];
                        }
                    }
                } else {
                    arr[arrycnt] = result;
                }
                arrycnt++;

                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : " + arrycnt + " 번째");

                countinueYN = sc.nextLine();
                if (countinueYN.equals("exit")) {
                    break;
                }
            }

            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[j]);
            }
        }
    }
}




