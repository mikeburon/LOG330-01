import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mike Buron on 7/19/2016.
 */
public class TestEffortVsNote {

    private  LinkedList<Double[]> list;
    private  LinkedList<Double[]> list2;

    double correlation;
    double correlation2;

    @Before
    public void setUp(){

        list = new LinkedList<>();
        list.add(new Double[]{(double)1,(double)1});
        list.add(new Double[]{(double)2,(double)2});
        list.add(new Double[]{3.0,3.0});
        correlation = MathEquations.correlation(list);

        list2 = new LinkedList<>();
        list2.add(new Double[]{(double)1,(double)1});
        list2.add(new Double[]{(double)5,(double)120});
        list2.add(new Double[]{-43.0,3.0});
        list2.add(new Double[] {0.0,0.0});
        correlation2 = MathEquations.correlation(list2);
    }

    @Test
    public void superiorInvalidBoundTest() throws Exception{

        assertTrue((Main.CORRELATION_PASSAGE<correlation)==true);
    }

    @Test
    public void inferiorInvalidBoundTest() throws Exception{
        assertTrue((Main.CORRELATION_PASSAGE>correlation2)==true);
    }

    @Test
    public void invalidTest() throws Exception{
        assertTrue((Main.CORRELATION_PASSAGE>correlation)==false);
    }



}
