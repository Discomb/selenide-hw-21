import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll(){
        baseUrl="https://the-internet.herokuapp.com";
        Configuration.browserSize="1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    @Test
    void dragAndDropTest(){
        open("/drag_and_drop");

        SelenideElement leftSquare = $("#column-a");
        SelenideElement rightSquare = $("#column-b");

        leftSquare.shouldHave(text("A"));
        rightSquare.shouldHave(text("B"));

//        не работает
//        actions().clickAndHold(leftSquare).release(rightSquare);

//        работает
        leftSquare.dragAndDrop(DragAndDropOptions.to(rightSquare));

        leftSquare.shouldHave(text("B"));
        rightSquare.shouldHave(text("A"));

    }
}
