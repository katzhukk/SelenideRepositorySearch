import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @BeforeAll
    static void beforeAll() {/* Всегда пишется со static. Вызывается один перед всеми тестами в этом тестовом классе*/
        Configuration.browserSize = "1920x1080";        /* Задаем разрешение браузера */
        Configuration.pageLoadStrategy = "eager";       /* Не ждем, когда загрузится полностью страница, чтобы долго не ждать*/
        //Configuration.holdBrowserOpen = true;         /* Не дает закрыть тесту браузер. Нужно только для отладки */
    }

    @AfterAll
    static void afterAll() {/* Всегда пишется со static. Вызывается один после всеми тестов в этом тестовом классе*/
        WebDriverRunner.closeWebDriver();
    }

    @Test
    void fillFormTest() {
        // открыть главную страницу selenide/selenide в github
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому аватару из блока contributors
        $("div.Layout-sidebar").$(byText("Contributors"))
                //.closest(".BorderGrid-cell").$$("ul li").first().hover();
                .closest("h2").sibling(0).$$("li").first().hover();
        // проверка: во всплывающем окне есть текст Andrei Solntsev
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}