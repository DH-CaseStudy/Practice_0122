package boardProgram;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardMainMenu implements BoardMenu {
    private Scanner sc = new Scanner(System.in);
    private static int index = 1;

    @Override
    public void create(ArrayList<Board> arrayList) {
        System.out.println("[ 새 게시물 입력 ]");
        System.out.print("제목 : ");
        String title = sc.nextLine();
        System.out.print("내용 : ");
        String content = sc.nextLine();
        System.out.print("작성자 : ");
        String writer = sc.nextLine();
        Date date = new Date();
        if (subMenu() == 1) {
            arrayList.add(new Board(index++, title, content, writer, date));
        }
    }

    @Override
    public void read(ArrayList<Board> arrayList) {
        System.out.println("[ 게시물 읽기 ]");
        System.out.print("bno : ");
        int bno = sc.nextInt();
        System.out.println("#".repeat(15));
        Board board = arrayList.get(arrayList.size() - bno);
        System.out.printf("번호 : %d%n", board.getBno());
        System.out.printf("제목 : %s%n", board.getBTitle());
        System.out.printf("내용 : %s%n", board.getBContent());
        System.out.printf("작성자 : %s%n", board.getBWriter());
        SimpleDateFormat now = new SimpleDateFormat("yyyy.MM.dd");
        String strNow = now.format(board.getBDate());
        System.out.printf("날짜 : %s%n", strNow);
        System.out.println("-".repeat(100));

        System.out.println("보조 메뉴 : 1. Update | 2. Delete | 3. List");
        System.out.print("메뉴 선택 : ");
        int cmd = sc.nextInt();
        sc.nextLine();
        System.out.println();
        if (cmd == 1) {
            System.out.println("[ 수정 내용 입력 ]");
            System.out.print("제목 : ");
            String title = sc.nextLine();
            System.out.print("내용 : ");
            String content = sc.nextLine();
            System.out.print("작성자 : ");
            String writer = sc.nextLine();
            if (subMenu() == 1) {
                board.setBTitle(title);
                board.setBContent(content);
                board.setBWriter(writer);
            }
        } else if (cmd == 2) {
            index--;
            arrayList.remove(board);
        } else if (cmd == 3) {
            return;
        }
    }

    @Override
    public void clear(ArrayList<Board> arrayList) {
        System.out.println("[ 게시물 전체 삭제 ]");
        System.out.println("-".repeat(100));
        if (subMenu() == 1) {
            index = 1;
            arrayList.removeAll(arrayList);
        }
    }

    @Override
    public void exit() {
        System.out.println("** 게시판 종료 **");
    }

    public int subMenu() {
        System.out.println("보조 메뉴 : 1. Ok | 2. Cancel");
        System.out.print("메뉴 선택 : ");
        int cmd = sc.nextInt();
        System.out.println();
        return cmd;
    }
}