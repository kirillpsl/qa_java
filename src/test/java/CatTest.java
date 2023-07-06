import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void testGetSound(){
        //Arrange
        Cat cat = new Cat(null);
        String expected = "Мяу";

        //Act
        String actual = cat.getSound();

        //Assert
        Assert.assertEquals("Sound не соответствует", expected, actual);
    }

    @Mock
    Predator predator;

    @Test
    public void testGetFood() throws Exception {
        //Arrange
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        Mockito.when(predator.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expected = predator.eatMeat();

        //Act
         List<String> actual = cat.getFood();

        //Assert
        Assert.assertEquals("Food не соответствует", expected, actual);
    }
}