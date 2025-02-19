package boardProgram;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BoardExample {
    private ArrayList<Board> arrayList = new ArrayList<>();

    public void list() {
        System.out.println("[ 게시물 목록 ]");
        System.out.println("-".repeat(100));
        System.out.printf("%-10s%-20s%-30s%-40s%n", "no", "writer", "date", "title");
        System.out.println("-".repeat(100));
        System.out.println();

        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, Comparator.comparing(Board::getBno).reversed());
            arrayList.forEach(x ->{
                SimpleDateFormat now = new SimpleDateFormat("yyyy.MM.dd");
                String strNow = now.format(x.getBDate());
                System.out.printf("%-10d%-20s%-30s%-40s%n", x.getBno(), x.getBWriter(), strNow, x.getBTitle());
            });
        }
        System.out.println();
        System.out.println("-".repeat(100));
    }

    public void mainMenu(int cmd) {
        BoardMainMenu boardMainMenu = new BoardMainMenu();

        switch (cmd) {
            case 1 -> {
                System.out.println();
                boardMainMenu.create(arrayList);
            }
            case 2 -> {
                System.out.println();
                boardMainMenu.read(arrayList);
            }
            case 3 -> {
                System.out.println();
                boardMainMenu.clear(arrayList);
            }
            case 4 -> {
                boardMainMenu.exit();
            }
        }
    }
}
