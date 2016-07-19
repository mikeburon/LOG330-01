import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mike Buron on 7/19/2016.
 */
public class TestCorrelation {


    private  LinkedList<Double[]> list;
    double correlation;


    @Before
    public void setUp(){
        list = new LinkedList();
        list.add(new Double[]{(double)186,(double)15});
        list.add(new Double[]{(double)699,69.9});
        list.add(new Double[] {132.0,65.});
        correlation = MathEquations.correlation(list);
    }

    @Test
    public void superiorInvalidTest() throws Exception{

        assertTrue(0.496>correlation);
    }

    @Test
    public void inferiorInvalidTest() throws Exception{
        assertTrue(0.494<correlation);
    }

    @Test
    public void validTest() throws Exception{

        double correlation2;
        double avgX,avgY,stdX,stdY;

        //initialisation listX
        LinkedList<Double> listX = new LinkedList();
        for(int i =0;i<list.size();i++){
            listX.add(list.get(i)[0]);
        }

        //initialisation listY
        LinkedList<Double> listY = new LinkedList();
        for(int i =0;i<list.size();i++){
            listY.add(list.get(i)[1]);
        }

        //calculate average
        avgX = MathEquations.average(listX);
        avgY = MathEquations.average(listY);

        //calculate standard deviation
        stdX = Math.sqrt(MathEquations.variance(listX));
        stdY = Math.sqrt(MathEquations.variance(listY));

        //calculate correlation
        double sumR  =0;
        for(int i =0; i<list.size();i++){
            sumR += ((list.get(i)[0]-avgX)*(list.get(i)[1]-avgY));
        }

        correlation2 = (sumR/(stdX*stdY));
        correlation2 = correlation2/(list.size()-1);
        assertTrue(correlation2==correlation);
    }

    @Test
    public void invalidTest() throws Exception{
       assertTrue(0.49500!=correlation);
    }

}
