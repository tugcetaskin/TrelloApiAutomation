package Tests;

import Request.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class TrialTest {

    @Test
    public void startTest() throws ParseException {

        CreatingDashboard.createDashboard("1/boards");
        CreateNewList.createList("1/lists");
        CreateCard.creatingCards("1/cards",2);
        UpdateTheCard.updateRandomCard("1/cards/",2);
        DeleteTheCard.deleteTheCards("1/cards/",2);
        DeleteTheBoard.deleteTheBoard("1/board/");
    }
}
