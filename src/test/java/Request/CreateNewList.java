package Request;

import Utils.ApiPath;
import Utils.Constants;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.HashMap;
import java.util.Map;
import static Request.CreatingDashboard.idList;
import static io.restassured.RestAssured.given;

public class CreateNewList {

    public static void createList(String path) throws ParseException {
        String id =idList.get("boardId");

        Map<String, String> map = new HashMap<String,String>();
        map.put("name", "AutomationCardList");
        map.put("idBoard", id);
        map.put("key", Constants.KEY);
        map.put("token", Constants.TOKEN);

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
        String listId = (String) responseBody.get("id");
        idList.put("listId",listId);
    }
}
