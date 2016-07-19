import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mike Buron on 7/19/2016.
 */
public class TestRegressionLineaire {

    private  LinkedList<Double[]> list2;
    double slope;
    double intercept;

    @Before
    public void setUp(){
        list2 = new LinkedList<>();
        list2.add(new Double[]{(double)1,(double)1});
        list2.add(new Double[]{(double)2,(double)2});
        slope = MathEquations.calculateSlope(list2);
        intercept = MathEquations.calculateIntercept(list2);
    }

    @Test
    public void superiorInvalidTest() throws Exception{
        assertTrue(1.1>slope*1+intercept);
    }

    @Test
    public void inferiorInvalidTest() throws Exception{
        assertTrue(0.9<slope*1+intercept);
    }

    @Test
    public void validTest() throws Exception{
        assertTrue(1==slope*1+intercept);
    }

    @Test
    public void invalidTest() throws Exception{
        assertTrue(5 !=slope*1+intercept);
    }



}
