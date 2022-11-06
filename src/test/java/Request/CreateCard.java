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

public class CreateCard {

    public static void creatingCards(String path,int cardAmount) throws ParseException {

        for(int i =1; i<=cardAmount; i++ ){
            String listId = idList.get("listId");

            Map<String, String> map = new HashMap<String, String>();
            map.put("idList", listId);
            map.put("key", Constants.KEY);
            map.put("token", Constants.TOKEN);
            map.put("name", i+"AutomationCard");
            JSONObject request = new JSONObject(map);

            String response =
                    given().
                            queryParams(map).
                            body(request.toJSONString()).
                            when().
                            post(ApiPath.BASE_URL + path).
                            then().
                            statusCode(200).
                            extract().
                            asString();

            JSONParser parser = new JSONParser();
            JSONObject responseBody = (JSONObject) parser.parse(response);
            String cardId = (String) responseBody.get("id");
            idList.put("cardId"+ i, cardId);
        }
    }
}
