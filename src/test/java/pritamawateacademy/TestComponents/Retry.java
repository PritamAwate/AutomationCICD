package pritamawateacademy.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int count = 0;
    int maxTry = 1;   // how many times you want to retry

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxTry) {
            count++;
            return true;   // retry test
        }

        return false;  // do not retry
    }
}
