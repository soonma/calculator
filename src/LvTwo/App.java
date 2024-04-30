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

        String index = "";

        Calculator calculator = new Calculator();

//      6.  Calculator 인스턴스를 생성(new)할 때 생성자를 통해 연산 결과를 저장하고 있는 컬렉션 필드가 초기화 되도록 수정합니다.
//      7.  Calculator 클래스에 반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현합니다.
//        - APP 클래스의 main 메서드에 Scanner를 활용하여 사칙연산을 진행할지 원의 넓이를 구할지 명령어를 입력 받은 후 원의 넓이를 구하는 것을 선택했을 때 원의 반지름을 입력 받아 원의 넓이를 구한 후 출력되도록 구현합니다.
//        - 기존에 구현되어있던 사칙연산 기능은 수정 후에도 반드시 이전과 동일하게 동작해야합니다.
//                - 이때, static, final 키워드를 활용할 수 있는지 고민한 후 활용 해봅니다.
//        - 반드시 static, final 키워드에 대한 설명과 활용한 이유에 대해 주석으로 작성합니다.
//        - 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성
//                - 계산된 원의 넓이를 저장합니다.
//                - 생성자로 초기화됩니다.
//                - 외부에서 직접 접근할 수 없습니다.
//        - Getter, Setter 메서드를 구현합니다.
//        - 원의 넓이 결과값들을 조회하는 메서드를 구현합니다.

        while (true) {
            try {
                System.out.print("사칙 연산을 진행 할거면 '사칙' 원의 넓이를 구하고 싶으면 '원넓이'를 입력 하세요 : ");
                index = sc.nextLine();
                if (!index.equals("사칙") && !index.equals("원넓이")) {
                    throw new BadInputException();
                } else {
                    if (index.equals("사칙")) {
                        calculator = new Calculator();
                        while (true) {
                            try {
                                System.out.print("첫번째 숫자를 입력 하세요: ");
                                fristnumber = sc.nextInt();
                                System.out.print("두번째 숫자를 입력 하세요: ");
                                secondnumber = sc.nextInt();
                                System.out.print("연산자를 입력 하세요 ");
                                operate = sc.next().charAt(0);
                                calculator.setResult(fristnumber, secondnumber, operate);
                            } catch (InputMismatchException e) {
                                //Calculator 함수에서 오입력 시 발생하는 Exception 처리가 제대로 되지 않아 Main 함수에서 진행 아마 입력 하자마자 발생 해서 우선순위때문인듯
                                System.out.println("값이 잘못 입력 했습니다, 다시해주세요");
                                sc.nextLine(); //여기시 씹힙 현상 발생 하여 무한 루프 발생 해당 구문으로 초기화 진행
                            }
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
                    } else if (index.equals("원넓이")) {
                        while (true) {
                            calculator = new Calculator();
                            try {
                                System.out.print("원의 반지름을 입력 하세요 : ");
                                fristnumber = sc.nextInt();
                                calculator.setCircle(fristnumber);

                            } catch (InputMismatchException e) {
                                System.out.println("값이 잘못 입력 했습니다, 다시해주세요");
                                sc.nextLine();
                            }
                            if (calculator.getCheck()) {
                                System.out.println("원의 넓이 : " + calculator.getCircum());
                                calculator.setCirlist();
                                sc.nextLine();
                                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                                index = sc.nextLine();

                                if (index.equals("remove")) {
                                    calculator.setCirRemove();
                                }

                                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                                index = sc.nextLine();
                                if (index.equals("inquiry")) {
                                    calculator.getCirlist();
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
            } catch (BadInputException e) {
            }
        }
    }
}
