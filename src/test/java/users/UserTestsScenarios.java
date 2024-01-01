package users;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.Setup;
import restUtils.AssertionUtils;
import users.pojos.CreateUser;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.*;

@Listeners(Setup.class)
public class UserTestsScenarios extends UsersAPIs{

    @Test(dataProvider = "userData")
    public void createUserAndVerify(CreateUser users) throws IOException {

        ExtentTest test = Setup.extentReports.createTest("Test Name: " + users.getScenarioId(),
                users.getScenarioDesc());
        Setup.extentTest.set(test);

        Response response = createUser(users);

        if (users.getExpectedStatusCode()!=200){
            if (users.getScenarioId().equals("Createuser_EmptyPayload")){
                response = createUser(users);
            }
            Assert.assertEquals(response.getStatusCode(),users.getExpectedStatusCode());
            Assert.assertEquals(response.jsonPath().getString("message"),users.getExpectedErrormessage());
        } else {
            Map<String,Object> expectedValuesMap = new HashMap<>();
            expectedValuesMap.put("userName",users.getUserName());
            expectedValuesMap.put("password",users.getPassword());
            if (users.getScenarioId().equalsIgnoreCase("Createuser_OnlyUserName")){
                expectedValuesMap.remove("password");
            }
            AssertionUtils.assertExpectedValuesWithJsonPath(response,expectedValuesMap);

        }
    }

    @DataProvider(name = "userData")
    public Iterator<CreateUser> getCreateUserData() throws IOException {
        List<LinkedHashMap<String,String>> excelDataAsListOfMap = ExcelUtils.getExcelDataAsListOfMap("CreateUserDataScenarios","Sheet1");
        List<CreateUser> userData = new ArrayList<>();
        for (LinkedHashMap<String,String> data : excelDataAsListOfMap){
            CreateUser user = getCustomizedUserData(data);
            userData.add(user);
        }
        return  userData.iterator();
    }

    private CreateUser getCustomizedUserData(LinkedHashMap<String,String> data){
        CreateUser createUser = new CreateUser();
        createUser.setScenarioId(data.get("ScenarioID"));
        createUser.setScenarioDesc(data.get("ScenarioDesc"));
        createUser.setExpectedStatusCode(Integer.parseInt(data.get("ExpectedStatusCode")));
        if (!data.get("ExpectedErrorMessage").equals("NO_DATA")){
            createUser.setExpectedErrormessage(data.get("ExpectedErrorMessage"));
        }
        if (!data.get("userName").equals("NO_DATA")){
            createUser.setUserName(data.get("userName"));
        }
        if (!data.get("password").equals("NO_DATA")){
            createUser.setPassword(data.get("password"));
        }
        return createUser;
    }
}
