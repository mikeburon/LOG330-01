import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mike Buron on 7/19/2016.
 */
public class TestVariance {

    private LinkedList<Double> list;
    private  LinkedList<Double[]> list2;

    @Before
    public void setUp(){
        list = new LinkedList();
        list.add((double)1);
        list.add((double)2);
    }


    @Test
    public void varianceValidTest() throws Exception {
        double variance = MathEquations.variance(list);
        assertEquals(0.5,variance,0);
    }

    @Test
    public void superiorInvalidTest() throws Exception{
        double variance = MathEquations.variance(list);
        assertTrue(0.51>variance);

    }

    @Test
    public void inferiorInvalidTest() throws Exception{
        double variance = MathEquations.variance(list);
        assertTrue(0.49<variance);
    }

    @Test
    public void invalidTest() throws Exception{
        double variance = MathEquations.variance(list);
        assertTrue(5!=variance);
    }
}
