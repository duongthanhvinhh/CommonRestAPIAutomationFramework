package users.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {

//    @Builder.Default
    @ExcelCell(0)
    private String userName = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FULLNAME);
//    @Builder.Default
    @ExcelCellName("password")
    private String password = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.PASSWORD);

    //    private String gender = Stream.of("male", "female", "others").findAny().get(); // lấy random, hay dùng đối với field gender male/female/other
//    private String gender = Arrays.asList("male", "female", "others").get(RandomDataGenerator.getRandomNumber(0,3));
//    private Gender gender = Arrays.stream(Gender.values()).findAny().get();
//    private Gender gender = Gender.male;
}
