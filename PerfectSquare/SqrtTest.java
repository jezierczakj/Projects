import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class SqrtTest {
    @Test
    public void test(){
        List<Integer> a  = (Arrays.asList(4, 2));
        Assert.assertEquals( a, Sqrt.sqrt(20));
    }
}