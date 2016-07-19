/**
 * Created by Mike Buron on 5/17/2016.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadCSVFile {
    private LinkedList<String[]> listOfNumbers = new LinkedList();

    public ReadCSVFile() {
    }

    public LinkedList<String[]> getList() {
        return this.listOfNumbers;
    }

    public void read(String filePath) {
        BufferedReader br = null;
         try {
            br = new BufferedReader(new FileReader(filePath));

            String line;
            while((line = br.readLine()) != null) {
                this.listOfNumbers.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
         } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException var15) {
                    var15.printStackTrace();

                }
            }

        }

    }
}
