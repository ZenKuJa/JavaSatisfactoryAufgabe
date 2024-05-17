import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String csvPath = "data\\SatisfactoryDatenJannesKurzke.CSV";
        ArrayList<Row> csvRows = ReadCSV.csvToList(csvPath);
        for (Row myRow : csvRows) {
            System.out.println(myRow.Recipe + " " + myRow.RatePerMinOut1);
        }
        System.out.println(csvRows.size());

        AggegatorHashMap.aggregate(csvRows);
    }
}
