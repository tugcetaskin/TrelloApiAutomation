package Request;

import Utils.ApiPath;
import Utils.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static Request.CreatingDashboard.idList;
import static io.restassured.RestAssured.given;

public class UpdateTheCard {


    public static void updateRandomCard(String path, int numberOfCards){

        String updatedCardId ="";
        Random random = new Random();
        int selectedCard = random.nextInt(1) + numberOfCards;

        for(int i=1; i<=numberOfCards; i++){
            if (i == selectedCard) {
                updatedCardId = idList.get("cardId" + i);
            }
        }
        Map<String,String> map = new HashMap<String,String>();
        map.put("key", Constants.KEY);
        map.put("token",Constants.TOKEN);
        map.put("name","TheCardUpdated");

                given().
                        queryParams(map).
                        when().
                        put(ApiPath.BASE_URL+path+updatedCardId).
                        then().
                        statusCode(200).
                        extract().
                        asString();
    }
}
