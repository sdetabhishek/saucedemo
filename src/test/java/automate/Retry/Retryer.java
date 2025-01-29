package automate.Retry;

import automate.basetest.BaseTest;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryer extends BaseTest implements IRetryAnalyzer {

    int count = 0;
    int maxRetry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxRetry) {
            count++;
            return true;
        }
        return false;
    }
}
