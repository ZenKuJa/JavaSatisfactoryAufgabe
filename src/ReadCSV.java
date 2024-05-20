import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {

    /*goes over every line of the csv file and creates for every line the corespoinding row instance
     */
    public static ArrayList<Row> toArrayList(String path) {

        File csvFile = new File(path);
        ArrayList<Row> rows = new ArrayList<>();

        try {
            Scanner csvReadScanner = new Scanner(csvFile); // Scanner can be used to iterate over every row of a
                                                                   // CSV file
            csvReadScanner.nextLine(); //skip header line
            while (csvReadScanner.hasNext()) {
                String row = csvReadScanner.nextLine(); // use nextLine if you want to catch "empty" values
                rows.add(createRow(row));
            }
            csvReadScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        return rows;
    }

    private static Row createRow(String rowStr) {
        Row newRow = new Row();
        String[] currentRowStr = rowStr.split(";");
        newRow.Recipe = currentRowStr[0];
        newRow.ProductionTime = Double.valueOf(currentRowStr[1].replace(',', '.'));
        newRow.Machine = currentRowStr[2];
        newRow.Output1 = currentRowStr[3];
        newRow.RatePerMinOut1 = Double.valueOf(currentRowStr[4].replace(',', '.'));
        newRow.Output2 = currentRowStr[5];
        newRow.RatePerMinOut2 = Double.valueOf(currentRowStr[6].replace(',', '.'));
        newRow.Input1 = currentRowStr[7];
        newRow.RateIn1 = Double.valueOf(currentRowStr[8].replace(',', '.'));
        newRow.Input2 = currentRowStr[9];
        newRow.RateIn2 = Double.valueOf(currentRowStr[10].replace(',', '.'));
        newRow.Input3 = currentRowStr[11];
        newRow.RateIn3 = Double.valueOf(currentRowStr[12].replace(',', '.'));
        newRow.Input4 = currentRowStr[13];
        newRow.RateIn4 = Double.valueOf(currentRowStr[14].replace(',', '.'));

        return newRow;
    }
}
