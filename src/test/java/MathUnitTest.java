import org.apache.xpath.operations.String;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MathUnitTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetResultValue() {
        m.setResult(0);
    }

    Mathematics m = new Mathematics();

    @Test(priority = 0, groups = {"smoke", "fast"}, dataProviderClass = DataProvider.class, dataProvider = "DPAddTxt")
    public void additionMethodTest(int x, int y, int expected) {

        m.add(x, y);
        Assert.assertEquals(expected, m.getResult(),"ERROR: Expected " + expected + ", Actual " + m.getResult());
    }

    @Test(priority = 3, groups = "fast", dataProviderClass = DataProvider.class, dataProvider = "DPDeductTxt")
    @Parameters({"first", "second"})
    public void deductionMethodTest(int x, int y, int expected) {
        m.setResult(1);
        m.deduct(x, y);
        Assert.assertEquals(expected, m.getResult(), "ERROR: Expected " + expected + ", Actual " + m.getResult());
    }

    @Test(priority = 2, groups = "fast", dataProviderClass = DataProvider.class, dataProvider = "DPMultiplyTxt")
    public void multiplicationMethodTest(int x, int y, int expected) {
        m.multiply(x, y);
        Assert.assertEquals(expected, m.getResult(), "ERROR: Expected " + expected + ", Actual " + m.getResult());
    }

    @Test(priority = 1, groups = "fast", dataProviderClass = DataProvider.class, dataProvider = "DPDivideTxt")
    public void divisionMethodTest(int x, int y, int expected){

        m.divide(x, y);
        Assert.assertEquals(expected, m.getResult(), "ERROR: Expected " + expected + ", Actual " + m.getResult());
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "fast", priority = 4, timeOut = 500)
    public void zeroDivisionException(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m.divide(5, 0);
    }

    @Parameters({"first", "second"})
    @Test
    public void dDTTestWithHelpOfTestNGXML(String a, String b) {
        Assert.assertEquals(a, b, "ERROR: Something went wrong!");
    }
}