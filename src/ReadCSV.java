import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {
    // Generates and returns a list where every element is a row of
    // the given CSV, the rows haven't yet been seperated
    // split each string with .split(";")
    public static ArrayList<String> readCsvToStrList(String path) {

        File satisfactoryCSV = new File(path);
        ArrayList<String> stringRows = new ArrayList<>();
        try {
            // Scanner can be used to iterate over every row of a CSV file
            Scanner csvReadScanner = new Scanner(satisfactoryCSV);
            while (csvReadScanner.hasNext()) {
                String row = csvReadScanner.nextLine(); // use nextLine if you want to catch "empty" values
                stringRows.add(row);
            }
            csvReadScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringRows;
    }

    /*
     * Converts a given CSV List to an array containing all the rows
     * 
     * @param path to the CSV file
     * 
     * @return ArrayList containing all the rows of the CSV
     */
    public static ArrayList<Row> csvToList(String path) {
        ArrayList<String> rowStrList = ReadCSV.readCsvToStrList(path);
        ArrayList<Row> rowList = new ArrayList<>();
        rowStrList.remove(0);
        if (!rowStrList.isEmpty()) {
            for (String rowStr : rowStrList) {
                rowList.add(ReadCSV.createRow(rowStr));
            }
        } else {
            System.out.println("You fucked up");
        }
        return rowList;
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
