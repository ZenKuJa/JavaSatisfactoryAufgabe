import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {
    public static void main(String[] args) {
        File satisfactoryCSV = new File("data\\SatisfactoryDatenJannesKurzke.CSV");
        ArrayList<String> stringRows = new ArrayList<>();
        try {
            Scanner csvReadScanner = new Scanner(satisfactoryCSV);

            while (csvReadScanner.hasNext()){
                String row = csvReadScanner.next();
                stringRows.add(row);
            }

            csvReadScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

/*         for (String row: stringRows){
            for (String column: row.split(";")){
                System.out.println(column + "------");
            }
            System.out.println("******************************");
        } */
        for (String columnHead: stringRows.get(0).split(";")){
            System.out.println(columnHead);
        }
    }
}
