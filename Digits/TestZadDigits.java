import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


import org.junit.Assert;
        import org.junit.Test;

        import java.awt.geom.Dimension2D;
        import java.util.ArrayList;
        import java.util.Arrays;

public class TestZadDigits {

    @Test
    public void test(){
        Assert.assertEquals(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5, 6), Digits.digits(123, 43, 654, 23));
    }
}
