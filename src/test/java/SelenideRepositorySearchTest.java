import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTest {
    @BeforeAll
    static void beforeAll() {/* Всегда пишется со static. Вызывается один перед всеми тестами в этом тестовом классе*/
        Configuration.browserSize = "1920x1080";        /* Задаем разрешение браузера */
        Configuration.pageLoadStrategy = "eager";       /* Не ждем, когда загрузится полностью страница, чтобы долго не ждать*/
        //Configuration.holdBrowserOpen = true;         /* Не дает закрыть тесту браузер. Нужно только для отладки */
    }

    @Test
    void fillFormTest() {
        // открыть главную страницу github
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $("[class='header-search-button placeholder input-button form-control d-flex flex-1 flex-self-stretch flex-items-center no-wrap width-full py-0 pl-2 pr-0 text-left border-0 box-shadow-none']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденных
        $("[data-testid='results-list']").$("a").click();

        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
