package users.pojos;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelUnknownCells;
import lombok.ToString;

import java.util.Map;

@ToString
public class UsersPoiji {
    @ExcelCell(0)
    private String userName;
    @ExcelCellName("password")
    private String password;

    @ExcelUnknownCells
    private Map<String,String> extraCells;
}
