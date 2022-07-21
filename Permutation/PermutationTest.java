import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
public class PermutationTest {

    @Test
    public void Test(){
        List<String> b  = (Arrays.asList("d", "b", "c", "a"));
        Assert.assertEquals((b), Permutation.permutation("a", "b", "c", "d"));
    }
}
