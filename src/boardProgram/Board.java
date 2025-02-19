package boardProgram;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Board {
    private int bno;
    private String bTitle;
    private String bContent;
    private String bWriter;
    private Date bDate;
}
