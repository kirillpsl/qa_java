import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

     @Mock
    Feline feline;

    @Test
    public void testGetKittensNull() throws Exception {
        //Arrange
        Lion lion = new Lion("Самец", feline);
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);

        //Act
        int actual = lion.getKittens();

        //Assert
        Assert.assertEquals("kittensCount не соответствует", expected, actual);
    }


    @Test
    public void testGetFood() throws Exception {
        //Arrange
        Lion lion = new Lion("Самка", feline);

        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expected = feline.getFood("Хищник");

        //Act
        List<String> actual = lion.getFood();

        //Assert
        Assert.assertEquals("Food не соответствует", expected, actual);
    }

}