package LvTwoStep2;


import LvTwo.BadOpertorException;

import java.util.InputMismatchException;
import java.util.Scanner;

//try 안에 try-catch문 삭제 진행 후 코드가 전보다 보는게 좋아짐(크게 묶는 작업을 진행)
//app.java에 operate 값을 기준으로 메서드를 호출 하는 방식을 ArithmeticCalculator안에 getResult메서드로 사용
//씹힘문제는 완전히 해결 못함

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fristnumber = 0;
        int secondnumber = 0;
        int arrycnt = 0;
        char operate = 0;
        ArithmeticCalculator calculator;
        String scan = "";

        while (true) {
            try {
                System.out.print("사칙 연산을 진행 할거면 '사칙' 원의 넓이를 구하고 싶으면 '원넓이'를 입력 하세요 : ");
                scan = sc.nextLine();

                if (!scan.equals("사칙") && !scan.equals("원넓이")) {
                    throw new BadInputException();
                }
                if (scan.equals("사칙")) {
                    calculator = new ArithmeticCalculator(new AddOperator(), new SubtractOperator(), new MultiplyOperator(), new DivideOperator(), new ModOperator());
                    while (true) {

                        System.out.print("첫번째 숫자를 입력 하세요: ");
                        fristnumber = Integer.parseInt(sc.nextLine());
                        System.out.print("두번째 숫자를 입력 하세요: ");
                        secondnumber = Integer.parseInt(sc.nextLine()); //씹힘 현상 수정하기 위해 형변환 시도, 덕분에 안씹히는거 확인
                        System.out.print("연산자를 입력 하세요 ");
                        operate = sc.next().charAt(0);
                        calculator.getCheck(operate);

                        if (fristnumber < 0&& secondnumber < 0 ) {
                            System.out.println("양의 정수가 아님");
                            continue;
                        }



                        System.out.println("이떄 체크값 " + calculator.setCheck());
                        //exception 발생시 값이 저장되는 현상이 발생 하여 if문으로 참이면 값을 저장 ,삭제 여부 결정 거짓이면 스킵
                        if (calculator.setCheck()) {
                                System.out.println("결과: " + calculator.getResult(fristnumber, secondnumber,operate));
                                calculator.setAddList();

                            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

                            scan = sc.nextLine();
                            if (scan.equals("remove")) {
                                calculator.setReMove();
                            }

                            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                            scan = sc.nextLine();
                            if (scan.equals("inquiry")) {
                                calculator.setList();
                            }

                            arrycnt++;
                            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료) : " + arrycnt + " 번째");
                            scan = sc.nextLine();
                            if (scan.equals("exit")) {
                                break;
                            }
                        }
                    }
                }
                if (scan.equals("원넓이")) {
                    CircleCalculator Circlecal = new CircleCalculator();
                    while (true) {

                        System.out.print("원의 반지름을 입력 하세요 : ");
                        fristnumber = Integer.parseInt(sc.nextLine());

                        Circlecal.setCheck();

                        if (Circlecal.getCheck()) {
                            System.out.println("원의 넓이 : " + Circlecal.getCircleResult(fristnumber));
                            Circlecal.setAddList();
                            sc.nextLine();

                            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                            scan = sc.nextLine();
                            if (scan.equals("remove")) {
                                Circlecal.setReMove();
                            }

                            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                            scan = sc.nextLine();
                            if (scan.equals("inquiry")) {
                                Circlecal.setList();
                            }
                            arrycnt++;
                            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료) : " + arrycnt + " 번째");
                            scan = sc.nextLine();
                            if (scan.equals("exit")) {
                                break;
                            }
                        }
                    }
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("잘못 입력 했습니다. 확인 부탁드립니다.");

            } catch (BadInputException e) {
                e.getMessage();

            } catch (ArithmeticException e) {
                System.out.println("두번 째 정수 값이 0 입니다. 확인해주세요");

            } catch (BadOpertorException e) {
                e.getMessage();
                sc.nextLine();

            }
        }
    }


}
