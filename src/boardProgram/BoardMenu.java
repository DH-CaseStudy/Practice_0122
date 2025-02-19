package boardProgram;

import java.util.ArrayList;

public interface BoardMenu {
    void create(ArrayList<Board> arrayList);
    void read(ArrayList<Board> arrayList);
    void clear(ArrayList<Board> arrayList);
    void exit();
}
