package ru.lanit.framework.steps;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.testng.Math;

public class MathTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Подготовка перед тестами");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Подчищаем после тестов");
    }

    @DataProvider
    public Object[][] testEquals() {
        return new Object[][]{
                {4, 2, 2},
                {0, -1, 1},
                {8, 4, 4},
                {-1, 0, -1},
                {5, 2, 3}
        };
    }

    @Test(dataProvider = "testEquals")
    public void testEqualsFive(int one, int two, int tree) {
        Assert.assertEquals(one, two + tree, "Значения не равны!");
    }

    @DataProvider(parallel = true)
    public Object[][] testEqualsNegative() {
        return new Object[][]{
                {5, 2, 2},
                {1, -1, 1},
                {100, 4, 4},
                {7, 0, -1},
                {3, 2, 3}
        };
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsNegative(int one, int two, int tree) {
        Assert.assertNotEquals(one, new Math().sumTest(two, tree), "Значения равны!");
    }

    @Test(dataProvider = "testEquals")
    public void newTest(int one, int two, int tree) {
        Assert.assertEquals(one, new Math().sumTest(two, tree), "Значения не равны!");
    }
    @DataProvider
    public Object[][] testObject() {
        return new Object[][]{
                {"five", 2, 2},
                {1, -1, "one"},
                {100, "four", 4},
                {"seven", "0", -1},
                {3, null, 3}
        };
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void testNegativeObject(Object one, Object two, Object tree) {
        Assert.assertEquals(one, new Math().sumTest(two, tree), "Значения не равны!");
    }

    @Test
    public void testNotEquals() {
        assert 2 * 2 == 4 : "two times two is not five!";
        Assert.assertFalse(5 == 2 + 2);
    }
}
