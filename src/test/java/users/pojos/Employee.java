package users.pojos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@AllArgsConstructor
@EqualsAndHashCode //overide method equals, 2obj chỉ cần giống value, ko cần point tới same memery location thì vẫn gọi là bằng nhau.
//khi overide equals thì cần overide cả hashcode để cho 2 object trả về same hashcode
public class Employee {

    private int id;
    private String name;

//    @Override
//    public boolean equals(Object obj){
//        Employee e = (Employee) obj;
//        return this.id == e.id && this.name == e.name;
//    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(id,name);
//    }
}
