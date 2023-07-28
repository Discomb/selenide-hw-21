import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class GitSolutionsTest {

    @BeforeAll
    static void beforeAll(){
        baseUrl="https://github.com/";
        Configuration.browserSize="1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    @Test
    void checkSolutionsPage(){
        open(baseUrl);

        $$("div.HeaderMenu--logged-out button").findBy(text("Solutions")).hover();
        $$("div.HeaderMenu-dropdown a").findBy(text("Enterprise")).click();
        $("div.enterprise-hero h1").shouldHave(text("Build like the best"));
    }
}
