package Request;

import Utils.ApiPath;
import Utils.Constants;
import java.util.HashMap;
import java.util.Map;
import static Request.CreatingDashboard.idList;
import static io.restassured.RestAssured.given;

public class DeleteTheBoard {

    public static void deleteTheBoard(String path){
        String id =idList.get("boardId");

        Map<String, String> map = new HashMap<String,String>();
        map.put("key", Constants.KEY);
        map.put("token",Constants.TOKEN);

        given().
                queryParams(map).
                when().
                delete(ApiPath.BASE_URL+path+id).
                then().
                statusCode(200).
                log().all();
    }
}
