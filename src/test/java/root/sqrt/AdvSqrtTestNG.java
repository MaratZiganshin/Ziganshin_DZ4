package root.sqrt;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdvSqrtTestNG {

    @Test(dataProvider = "data")
    public void testSqrt(double a, double expected) throws Exception {
        double result = new root.sqrt.AdvSqrt().sqrt(a);
        if (!Double.isFinite(expected))
            Assert.assertEquals(result, expected);
        else
            Assert.assertTrue(Math.abs(result - expected) < eps);
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                // Обычные тестовые значения, с целочисленным результатом
                {4.0, 2.0},
                {256.0, 16.0},
                {9.0, 3.0},
                {169.0, 13.0},
                {1.0, 1.0},
                {0.0, 0.0},

                // Тестовые значения с делением на ноль
                {0.0 / 0.0, Double.NaN},
                {-2.0 / 0.0, Double.NaN},
                {2.0 / 0.0, Double.POSITIVE_INFINITY},

                // Иррациональный результат
                {2.0, Math.sqrt(2.0)},
                {3.0, Math.sqrt(3.0)},
                {11.0, Math.sqrt(11.0)},
                {211.0, Math.sqrt(211.0)},

                // Отрицательный результат
                {-1, Double.NaN},
                {-2, Double.NaN},
                {-4, Double.NaN},

                // Sqrt от dnrbnd
                {Double.longBitsToDouble(0x0001000000000000L), Math.sqrt(Double.longBitsToDouble(0x0001000000000000L))}
        };
    }

    private static double eps = 0.0000001;
}