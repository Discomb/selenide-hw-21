import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests {

    @BeforeAll
    static void beforeAll(){
        baseUrl="https://github.com/";
        Configuration.browserSize="1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    @Test
    void checkJUnit5CodeExample(){
// Откройте страницу Selenide в Github
        open("selenide/selenide");
// Перейдите в раздел Wiki проекта
        $("a#wiki-tab").click();
        $("div#wiki-pages-box li.wiki-more-pages-link button").click();
// Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("div#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("div#wiki-pages-box").$(byText("SoftAssertions")).click();
// Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("a#user-content-3-using-junit5-extend-test-class").parent().sibling(0).shouldHave(text("SoftAssertsExtension"));
        $("a#user-content-3-using-junit5-extend-test-class").parent().sibling(2).shouldHave(text("SoftAssertsExtension"));
    }

}
