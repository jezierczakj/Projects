import org.junit.Test;
import org.junit.Assert;

public class DenominatorTest {
    @Test
    public void test(){
        Assert.assertEquals(25, Denominator.denominator(75, 25, 100));
    }
}
