package LvThree;


import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fristnumber = 0;
        int secondnumber =0;
        int i = 0;
        char operate = 0;

        String index = "";
        
        while (true) {
            try {
                System.out.print("사칙 연산을 진행 할거면 '사칙' 원의 넓이를 구하고 싶으면 '원넓이'를 입력 하세요 : ");
                index = sc.nextLine();
                if (!index.equals("사칙") && !index.equals("원넓이")) {
                    throw new BadInputException();
                } else {
                    if (index.equals("사칙")) {
                        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
                       while (true) {
                            try {
                                System.out.print("첫번째 숫자를 입력 하세요: ");
                                fristnumber = sc.nextInt();
                                System.out.print("두번째 숫자를 입력 하세요: ");
                                secondnumber = sc.nextInt();
                                System.out.print("연산자를 입력 하세요 ");
                                operate = sc.next().charAt(0);
                                calculator.getCheck(operate);
                            } catch (InputMismatchException e) {
                                //Calculator 함수에서 오입력 시 발생하는 Exception 처리가 제대로 되지 않아 Main 함수에서 진행 아마 입력 하자마자 발생 해서 우선순위때문인듯
                                System.out.println("값이 잘못 입력 했습니다, 다시해주세요");
                                sc.nextLine(); //여기시 씹힙 현상 발생 하여 무한 루프 발생 해당 구문으로 초기화 진행
                                calculator.failgetCheck();
                            }
                            System.out.println("이떄 체크값 "+calculator.setCheck());
                            //exception 발생시 값이 저장되는 현상이 발생 하여 if문으로 참이면 값을 저장 ,삭제 여부 결정 거짓이면 스킵
                            if ( calculator.setCheck()) {

                                calculator.getArithmetic(fristnumber,secondnumber);

                                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                                sc.nextLine(); // 여기서 Scanner 씹히는 현상이 발생 해서 한번 초기화 내컴퓨터만 그런걸수도..
                                index = sc.nextLine();
                                if (index.equals("remove")) {
                                    calculator.setReMove();
                                }

                                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                                index = sc.nextLine();
                                if (index.equals("inquiry")) {
                                    calculator.setList();
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
                        CircleCalculator calculator = new CircleCalculator();
                        while (true) {
                            try {
                                System.out.print("원의 반지름을 입력 하세요 : ");
                                fristnumber = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("값이 잘못 입력 했습니다, 다시해주세요");
                                calculator.setCheck();
                                sc.nextLine();
                            }
                            if (calculator.getCheck()) {
                                System.out.println("원의 넓이 : " + calculator.getCircleResult(fristnumber));
                                calculator.setAddList();
                                sc.nextLine();

                                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                                index = sc.nextLine();
                                if (index.equals("remove")) {
                                    calculator.setReMove();
                                }

                                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                                index = sc.nextLine();
                                if (index.equals("inquiry")) {
                                    calculator.setList();
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
            } catch (BadInputException ignored) {
            }
        }
    }


}
