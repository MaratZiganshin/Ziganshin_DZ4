package root.gcd;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GCDTestNG {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                // Обычные тестовые знкачения, без пограничных значений
                {12, 16, 4},
                {565, 35, 5},
                {891, 9, 9},
                {763, 234, 1},
                {37, 111, 37},
                {23, 457, 1},

                // Тесты с первым парамертом = 0
                {0, 0, 0},
                {0, 5, 5},
                {0, -7, 7},

                // Тесты с первым параментом = Integer.MAX_VALUE (простое число)
                {Integer.MAX_VALUE, 1, 1},
                {Integer.MAX_VALUE, 13, 1},
                {Integer.MAX_VALUE, 2, 1},
                {Integer.MAX_VALUE, -1, 1},
                {Integer.MAX_VALUE, -13, 1},
                {Integer.MAX_VALUE, -2, 1},
                {Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
    }

    @Test(dataProvider = "data")
    public void testGcdResult(int a, int b, int expected) throws Exception {
        int gcd = new GCD().gcd(a, b);
        Assert.assertEquals(expected, gcd);
        if (gcd != 0) {
            Assert.assertEquals(0,a % gcd);
            Assert.assertEquals(0,b % gcd);
        }
        Assert.assertTrue(gcd >= 0);
    }
}