import com.example.Animal;
import com.example.Lion;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

//тест hasMane
@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean expected;

    public LionTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец",true},
                {"Самка",false},
                {"Самей",true},
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        try {
            Lion lion = new Lion(sex);
            boolean actual = lion.doesHaveMane();
            assertEquals("HaveMane не соответствует", actual, expected);
        } catch (Exception thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void testGetKittensNull() throws Exception {
        //Arrange
        Lion lion = new Lion("Самец");
        int expected = 1;

        //Act
        int actual = lion.getKittens();

        //Assert
        Assert.assertEquals("kittensCount не соответствует", expected, actual);
    }

    @Test
    public void testGetKittensNotNull() throws Exception {
        //Arrange
        Lion lion = new Lion("Самка");
        int expected = 1;

        //Act
        int actual = lion.getKittens(1);

        //Assert
        Assert.assertEquals("kittensCount не соответствует", expected, actual);
    }

    @Mock
    Animal animal;

    @Test
    public void testGetFood() throws Exception {
        MockitoAnnotations.openMocks(this);
        //Arrange
        Lion lion = new Lion("Самка");

        Mockito.when(animal.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expected = animal.getFood("Хищник");

        //Act
        List<String> actual = lion.getFood();

        //Assert
        Assert.assertEquals("Food не соответствует", expected, actual);
    }

}