package Request;

import Utils.ApiPath;
import Utils.Constants;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreatingDashboard {

    public static HashMap<String,String> idList=new HashMap<>();

    public static void createDashboard(String path) throws ParseException {


        Map<String, String> map = new HashMap<String,String>();
        map.put("name","AutomationDashboard");
        map.put("key", Constants.KEY);
        map.put("token",Constants.TOKEN);
        JSONObject request = new JSONObject(map);

        String response =
                given().
                        queryParams(map).
                        body(request.toJSONString()).
                        when().
                        post(ApiPath.BASE_URL+path).
                        then().
                        statusCode(200).
                        extract().
                        asString();

        JSONParser parser = new JSONParser();
        JSONObject responseBody = (JSONObject) parser.parse(response);
        String boardId = (String) responseBody.get("id");
        idList.put("boardId", boardId);
    }
}
