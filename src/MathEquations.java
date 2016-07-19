
import java.util.LinkedList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


/**
 * Created by Mike Buron on 5/14/2016.
 */
public class MathEquations {

    public static double average(LinkedList<Double> values){
        double avg;
        double sum =0;

        //for each number in the list add them
        for(int i =0;i <values.size();i++){
            sum += values.get(i);
            }

        avg = sum/values.size();

        return avg;

    }

    public static double distanceSquare(double number,double avg){
        return ((number-avg)*(number-avg));
    }

    public static double variance(LinkedList<Double> values){
        double squareSum = 0;
        double avg;
        double variance;

        avg = average(values);

        for(int i = 0;i < values.size();i++) {
            squareSum += distanceSquare(values.get(i), avg);
        }

        double size = values.size();

        variance = (1/(size-1)*squareSum);

        return variance;
    }

    public static double correlation(LinkedList<Double[]> list){
        double correlation;
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

        correlation = (sumR/(stdX*stdY));
        correlation = correlation/(list.size()-1);

        return correlation;
    }

    public static double calculateSlope(LinkedList<Double[]> list){
        double sumXY=0;
        double sumX =0;
        double sumY=0;
        double sumX2=0;
        double slope;

        //calculation de la sum des x et sum des y et sum des xy
        for(int i = 0; i<list.size(); i++){
            sumX += list.get(i)[0];
            sumX2 += list.get(i)[0]*list.get(i)[0];
            sumY += list.get(i)[1];
            sumXY += list.get(i)[0]*list.get(i)[1];
        }


        slope = (list.size()*sumXY-sumX*sumY)/(list.size()*sumX2-(sumX*sumX));
        return slope;
    }

    public static double calculateIntercept(LinkedList<Double[]> list){
        double sumY =0;
        double sumX =0;
        double slope;
        double intercept;

        //calculate sumX and SumY
        for (int i =0;i<list.size();i++){
            sumX += list.get(i)[0];
            sumY += list.get(i)[1];
        }

        //calculate slope and intercept
        slope = MathEquations.calculateSlope(list);
        intercept = (sumY - slope*sumX)/list.size();
        return intercept;
    }

    public static double calculateInterval(LinkedList<Double[]> list,double tValue,double estimate){
        double sumXY =0;
        double sumXX = 0;
        double b1,b0;
        double toSquare = 0;
        double var,std;
        double toSquare2 =0;

        LinkedList<Double> listX = new LinkedList();
        LinkedList<Double> listY = new LinkedList();

        for(int i=0;i<list.size();i++){
            double x,y;
            x =list.get(i)[0];
            y = list.get(i)[1];

            listX.add(x);
            listY.add(y);

            sumXY += x*y;
            sumXX += x*x;
        }

        b1= (sumXY-list.size()*MathEquations.average(listX)*MathEquations.average(listY))/((sumXX)-(list.size()*pow(MathEquations.average(listX),2)));
        b0 = MathEquations.average(listY)-b1*MathEquations.average(listX);



        for(int i=0; i<list.size(); i++){
         toSquare += pow((list.get(i)[1]-b0-b1*list.get(i)[0]),2);
        }
        var = (toSquare/(list.size()-2));
        std = sqrt(var);

        for(int i=0;i<list.size();i++){
            toSquare2 += pow(list.get(i)[0]-MathEquations.average(listX),2);
        }

        double racine = sqrt(1+(1/list.size())+((estimate-MathEquations.average(listX))*(estimate-MathEquations.average(listX))/toSquare2));


        return (racine*tValue*std);


    }


}
