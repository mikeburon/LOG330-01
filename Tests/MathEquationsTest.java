import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Mike Buron on 5/17/2016.
 */
public class MathEquationsTest {

    private  LinkedList<Double> list;
    private  LinkedList<Double[]> list2;

    @Before
    public void setUp(){
        list = new LinkedList<Double>();
        list.add((double)1);
        list.add((double)2);
        list2 = new LinkedList<Double[]>();
        list2.add(new Double[]{(double)1,(double)1});
        list2.add(new Double[]{(double)2,(double)2});
            }


    @Test
    public void average() throws Exception {
        double avg = MathEquations.average(list);
        assertEquals(1.5,avg,0);
    }

    @Test
    public void distanceSquare() throws Exception {
        double distance = MathEquations.distanceSquare(1,3);
        assertEquals(4,distance,0);
    }

    @Test
    public void variance() throws Exception {
        double variance = MathEquations.variance(list);
        assertEquals(0.5,variance,0);
    }

    @Test
    public void calculateIntercept() throws Exception {


        double intercept = MathEquations.calculateIntercept(list2);
        assertEquals(0,intercept,0);
    }

    @Test
    public void calculateSlope() throws Exception {
        double slope = MathEquations.calculateSlope(list2);
        assertEquals(1,slope,0);
    }

}