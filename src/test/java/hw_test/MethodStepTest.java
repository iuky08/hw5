package hw_test;

import hw5_main.BaseSteps;
import org.junit.jupiter.api.Test;

public class MethodStepTest {

    final BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";

    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchForRepo(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssues();

        steps.shouldBeIssueWithNumber(ISSUE_NUMBER);
    }
}