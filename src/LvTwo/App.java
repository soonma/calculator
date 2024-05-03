package LvTwo;


import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fristnumber;
        int secondnumber;
        int i = 0;
        char operate;
        boolean posiIntCheck = true;

        String index = "";

        Calculator calculator = new Calculator();

        while (true) {
            try {

                System.out.print("첫번째 숫자를 입력 하세요: ");
                fristnumber = sc.nextInt();
                System.out.print("두번째 숫자를 입력 하세요: ");
                secondnumber = sc.nextInt();
                System.out.print("연산자를 입력 하세요 ");
                operate = sc.next().charAt(0);
                //양의 정수가 아닐떄 되돌아가는 코드 추가
                if (fristnumber <= 0&& secondnumber <= 0 ) {
                    System.out.println("양의 정수가 아님");
                    continue;
                }
                calculator.setResult(fristnumber, secondnumber, operate);

            } catch (InputMismatchException e) {
                //Calculator 함수에서 오입력 시 발생하는 Exception 처리가 제대로 되지 않아 Main 함수에서 진행 아마 입력 하자마자 발생 해서 우선순위때문인듯
                System.out.println("값이 잘못 입력 했습니다, 다시해주세요");
                sc.nextLine(); //여기시 씹힙 현상 발생 하여 무한 루프 발생 해당 구문으로 초기화 진행
            }

//            1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
//            - 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다. (매개변수로 해당 오류 내용을 전달합니다.)

//            2. Level 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정합니다.
//            - 연산 수행 역할은 Calculator 클래스가 담당합니다.
//                    - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장됩니다.
//            - 소스 코드 수정 후에도 수정 전의 기능들이 반드시 똑같이 동작해야합니다.

//            3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
//                    - 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
//            - 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드)
//            - 위 요구사항을 모두 구현 했다면 App 클래스의 main 메서드에서 위에서 구현한 메서드를 활용 해봅니다.

//            4. Calculator 클래스에 저장된 연산 결과들 중  가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정합니다.
//            5. Calculator 클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 조회 메서드가 활용될 수 있도록 수정합니다.

            //exception 발생시 값이 저장되는 현상이 발생 하여 if문으로 참이면 값을 저장 ,삭제 여부 결정 거짓이면 스킵
            if (calculator.getCheck()) {
                System.out.println("결과: " + calculator.getResult());
                calculator.setIntlist();

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                sc.nextLine(); // 여기서 Scanner 씹히는 현상이 발생 해서 한번 초기화 내컴퓨터만 그런걸수도..
                index = sc.nextLine();
                if (index.equals("remove")) {
                    calculator.setRemove();
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                index = sc.nextLine();
                if (index.equals("inquiry")) {
                    calculator.setInquiry();
                }

                i++;

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료) : " + i + " 번째");
                index = sc.nextLine();
                if (index.equals("exit")) {
                    break;
                }
            }
        }
    }
}
