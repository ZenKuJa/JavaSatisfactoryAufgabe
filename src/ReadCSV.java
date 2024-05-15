import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;

public class ReadCSV {
    //Generates and returns a list where every element is a row of
    //the given CSV, the rows haven't yet been seperated
    //split each string with .split(";")
    public static ArrayList<String> readCsvToStrList (String path){

        File satisfactoryCSV = new File(path);
        ArrayList<String> stringRows = new ArrayList<>();

        //the try catch block is necessary, since the given file path
        //could be wrong
        try {
            //Scanner can be used to iterate over every row of a CSV file
            Scanner csvReadScanner = new Scanner(satisfactoryCSV);
            while (csvReadScanner.hasNext()){
                String row = csvReadScanner.nextLine(); //use nextLine if you want to catch "empty" values
                stringRows.add(row);
            }
            //allways close Scanner to reclaim memory
            csvReadScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringRows;
    }

    public static ArrayList<Row> readCsvToList(String path){
        ArrayList<String> rowStrList = ReadCSV.readCsvToStrList(path);
        ArrayList<Row> rowList = new ArrayList<>();

        if (rowStrList.isEmpty() == false){
            /* String[] currentRowList = new String[rowStrList.get(0).split(";").length]; */
            for (String rowStr: rowStrList){
                Row currentRow = new Row();
                String[] currentRowStr = rowStr.split(";");
                currentRow.Recipe = currentRowStr[0];
                currentRow.ProductionTime=Integer.valueOf(currentRowStr[1]);
                currentRow.Machine=currentRowStr[2];
                currentRow.Output1=currentRowStr[3];
                currentRow.RatePerMinOut1=Integer.valueOf(currentRowStr[4]);
                currentRow.Output2=currentRowStr[5];
                currentRow.RatePerMinOut2=Integer.valueOf(currentRowStr[6]);
                currentRow.Input1=currentRowStr[7];
                currentRow.RateIn1=Integer.valueOf(currentRowStr[8]);
                currentRow.Input2=currentRowStr[9];
                currentRow.RateIn2=Integer.valueOf(currentRowStr[10]);
                currentRow.Input3=currentRowStr[11];
                currentRow.RateIn3=Integer.valueOf(currentRowStr[12]);
                currentRow.Input4=currentRowStr[13];
                currentRow.RateIn4=Integer.valueOf(currentRowStr[14]);
                

            }
            

        } else {
            System.out.println("You fucked up");
        }

        return rowList;
    }
}
