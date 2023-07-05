import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Animal animal;

    @Test
    public void testEatMeat() throws Exception {
        //Arrange
        Feline feline = new Feline();
        Mockito.when(animal.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expected = animal.getFood("Хищник");
       
        //Act
        List<String> actual = feline.eatMeat();

        //Assert
        Assert.assertEquals("Meat не соответствует", expected, actual);
    }

    @Test
    public void testGetFamily(){
        //Arrange
        Feline feline = new Feline();
        String expected = "Кошачьи";

        //Act
        String actual = feline.getFamily();

        //Assert
        Assert.assertEquals("Family не соответствует",expected, actual);
    }

    @Test
    public void testGetKittensNull(){
        //Arrange
        Feline feline = new Feline();
        int expected = 1;

        //Act
        int actual = feline.getKittens();

        //Assert
        Assert.assertEquals("kittensCount не соответствует", expected, actual);
    }

    @Test
    public void testGetKittensNotNull(){
        //Arrange
        Feline feline = new Feline();
        int expected = 1;

        //Act
        int actual = feline.getKittens(1);

        //Assert
        Assert.assertEquals("kittensCount не соответствует", expected, actual);
    }

}