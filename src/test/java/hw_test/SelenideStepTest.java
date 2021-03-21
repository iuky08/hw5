package hw_test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class SelenideStepTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";
    private static final String ISSUES_LIST = "Issues";

    @Test
    @Tags({@Tag("Web"), @Tag("critical")})
    @DisplayName("Поиск Issues по номеру в репозитории")
    public void testIssueSearch() {
        step("Открываем главную страницу", () -> {
            open(BASE_URL);
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();

        });
        step("Переходим в раздел " + ISSUES_LIST, () -> {
            $(withText(ISSUES_LIST)).click();
        });
        step("Проверяем, что Issue c номером " + ISSUE_NUMBER + " существует", () -> {
            $(withText(ISSUE_NUMBER)).should(visible);
        });
    }
}
