package hw5_main;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;


public class BaseSteps {

    private static final String BASE_URL = "http://github.com";

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Открываем главную страницу")
    public void searchForRepo(final String repository) {
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("Переходим в репозиторий ${repository}")
    public void goToRepositoryFromSearch(final String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Переходим в раздел Issues")
    public void openRepositoryIssues() {
        $(withText("Issues")).click();
    }

    @Step("Проверяем что Issue с номером ${number} существует")
    public void shouldBeIssueWithNumber(final String number) {
        $(withText(number)).should(Condition.exist);
    }
}
