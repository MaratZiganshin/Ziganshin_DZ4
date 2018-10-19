package root.gcd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GCDTest {
    @Parameterized.Parameters(name = "{index}: gcd({0}, {1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
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
        });
    }

    @Parameterized.Parameter(0)
    public int a;

    @Parameterized.Parameter(1)
    public int b;

    @Parameterized.Parameter(2)
    public int expected;

    @Test
    public void testGCD(){
        int gcd = new GCD().gcd(a, b);
        Assert.assertEquals(expected, gcd);
        if (gcd != 0) {
            Assert.assertEquals(0, a % gcd);
            Assert.assertEquals( 0, b % gcd);
        }
        Assert.assertTrue(gcd >= 0);
    }

}