import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Lion;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    private final String sex;
        private final boolean expected;

        public LionParameterizedTest(String sex, boolean expected) {
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

    @Mock
    Feline feline;
    @Test
    public void testDoesHaveMane(){
        try {
            Lion lion = new Lion(sex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals("HaveMane не соответствует", actual, expected);
        } catch (Exception thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    }
