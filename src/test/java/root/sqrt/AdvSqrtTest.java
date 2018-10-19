package root.sqrt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AdvSqrtTest {

    @Parameterized.Parameters(name = "{index}: sqrt({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
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
        });
    }

    @Parameterized.Parameter(0)
    public double a;

    @Parameterized.Parameter(1)
    public double expected;

    @Test
    public void testSqrt(){
        double sqrt = new AdvSqrt().sqrt(a);
        Assert.assertEquals(expected, sqrt, eps);
    }

    private static double eps = 0.0000001;
}