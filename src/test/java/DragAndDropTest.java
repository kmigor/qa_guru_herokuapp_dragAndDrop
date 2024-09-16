import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropTest(){

        open("/drag_and_drop");

        $("#column-a").$("header").shouldHave(text("A"));

        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(170, 0).release().perform();

        $("#column-a").$("header").shouldHave(text("B"));

        $("#column-a").dragAndDrop(to($("#column-b")));

        $("#column-a").$("header").shouldHave(text("A"));

    }

}
