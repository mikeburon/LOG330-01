import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mike Buron on 7/19/2016.
 */
public class TestConfidenceInterval {

    double interval;
    private  LinkedList<Double[]> list;
    double delta90;
    double[] result;
    double yEstimate;
    DecimalFormat df = new DecimalFormat("#.####");


    @Before
    public void setUp() {

        list = new LinkedList<>();
        list.add(new Double[]{(double) 1, (double) 2.5});
        list.add(new Double[]{(double) 3, (double) 6.25});
        list.add(new Double[]{8.0, 16.5});
        delta90 = MathEquations.calculateInterval(list,Main.T_VALUE_90,4);
        yEstimate= MathEquations.calculateSlope(list)*4+MathEquations.calculateIntercept(list);
        result = new double[]{yEstimate-delta90,yEstimate+delta90};

    }

    @Test
    public void superiorBoundValidTest() throws Exception {
        assertTrue(Double.valueOf(df.format(result[1]))==8.7852);

    }

    @Test
    public void superiorBoundInvalidTest() throws Exception{
        assertTrue(8.7853>Double.valueOf(df.format(result[1])));
        assertTrue(8.0482>Double.valueOf(df.format(result[0])));

    }

    @Test
    public void inferiorBoundValidTest() throws Exception{
        assertTrue(Double.valueOf(df.format(result[0]))==8.0481);
    }

    @Test
    public void inferiorBoundInvalidTest() throws Exception{
        assertTrue(8.0480<Double.valueOf(df.format(result[0])));
        assertTrue(8.7851<Double.valueOf(df.format(result[1])));
    }

    @Test
    public void invalidTest() throws Exception{
        assertTrue(10!=result[1]);
        assertTrue(10!=result[0]);
    }

}


