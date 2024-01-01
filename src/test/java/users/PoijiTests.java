package users;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import users.pojos.UsersPoiji;

import java.io.File;
import java.util.List;

public class PoijiTests {

    public static void main(String[] args) {

        PoijiOptions option = PoijiOptions.PoijiOptionsBuilder.settings().addListDelimiter(";").build();
        List<UsersPoiji> data = Poiji.fromExcel(new File("src/test/resources/testdata/CreateUserData.xlsx"),UsersPoiji.class,option);
        System.out.println(data);
    }
}
