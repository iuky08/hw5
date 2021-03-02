package hw_test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {
    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";
    private static final String ISSUES_LIST = "Issues";

    @Test
    @Tags({@Tag("Web"), @Tag("critical")})
    @DisplayName("Поиск Issues по номеру в репозитории")
    public void testIssueSearch() {
        open(BASE_URL);
        $(".header-search-input").setValue(REPOSITORY).submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText(ISSUES_LIST)).click();
        $(withText(ISSUE_NUMBER)).should(Condition.exist);
    }
}
