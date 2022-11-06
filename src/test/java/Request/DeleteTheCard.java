package Request;

import Utils.ApiPath;
import Utils.Constants;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.Map;
import static Request.CreatingDashboard.idList;
import static io.restassured.RestAssured.given;

public class DeleteTheCard {

    public static void deleteTheCards(String path,int numberOfCardsToDelete) {

        for(int i=1 ; i<= numberOfCardsToDelete ; i++){
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", Constants.KEY);
            map.put("token", Constants.TOKEN);
            JSONObject request = new JSONObject(map);

                    given().
                            queryParams(map).
                            body(request.toJSONString()).
                            when().
                            delete(ApiPath.BASE_URL + path+idList.get("cardId"+i)).
                            then().
                            statusCode(200).
                            extract().
                            asString();
        }
    }
}
