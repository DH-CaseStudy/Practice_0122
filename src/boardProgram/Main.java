package boardProgram;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardExample boardExample = new BoardExample();

        while (true) {
            boardExample.list();
            System.out.println("메인 메뉴 : 1. Create | 2. Read | 3. Clear | 4. Exit");
            System.out.print("메뉴 선택 : ");
            int cmd = sc.nextInt();
            System.out.println();
            boardExample.mainMenu(cmd);
            if (cmd == 4) {
                break;
            }
        }
    }
}
