import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by Mike Buron on 5/14/2016.
 */
public class Main {

    //barème déterminé d'après http://people.duke.edu/~rnau/rsquared.htm afin que le tout soit représentatif au maximum.
    final static double CORRELATION_PASSAGE = 0.9;
    final static double T_VALUE_90 = 1.86;
    final static double T_VALUE_70 = 1.108;
    final static double T_VALUE_80 = 1.397;


    public static void main(String[] args) {
        double estimate, delta90, delta70, yEstimate, slope, intercept,delta80;

        Scanner scanner = new Scanner(System.in);

        //lecture du fichier
        ReadCSVFile reader = new ReadCSVFile();
        System.out.println("SVP entrer le lien du fichier csv: ");
        String filePath = scanner.nextLine().trim();
        reader.read(filePath);
        LinkedList<String[]> listCSV = reader.getList();
        LinkedList<Double[]> listXY = new LinkedList<>();


        if (listCSV.size() != 0){

            for (int i = 0; i < listCSV.size(); i++) {
                double x, y;
                x = Double.parseDouble(listCSV.get(i)[0]);
                y = Double.parseDouble(listCSV.get(i)[1]);
                listXY.add(new Double[]{x, y});
            }


            System.out.println("Svp entrer la taille estimée(LOC)");
            estimate = scanner.nextDouble();

            //calculs
            delta90 = MathEquations.calculateInterval(listXY, T_VALUE_90, estimate);
            delta70 = MathEquations.calculateInterval(listXY, T_VALUE_70, estimate);
            delta80 = MathEquations.calculateInterval(listXY,T_VALUE_80,estimate);

            slope = MathEquations.calculateSlope(listXY);
            intercept = MathEquations.calculateIntercept(listXY);
            yEstimate = slope * estimate + intercept;

            //affichage
            System.out.print(listXY.size() + " donnée(s): ");
            for (int i = 0; i < listCSV.size(); i++) {
                for (int j = 0; j <= listCSV.getFirst().length - 1; j++) {
                    System.out.print(listCSV.get(i)[j]);
                    if (j + 1 <= listCSV.getFirst().length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }

            System.out.println();
            System.out.printf("Yi = %.4f\n",yEstimate);
            System.out.printf("Interval 90 : %.4f - %.4f\n", (yEstimate - delta90), (yEstimate + delta90));
            System.out.printf("Interval 80 : %.4f - %.4f\n", yEstimate - delta80, yEstimate + delta80);
            System.out.printf("Interval 70 : %.4f - %.4f\n", yEstimate - delta70, yEstimate + delta70);
        }else{
            System.out.println("Le fichier est vide");

        }
    }



}