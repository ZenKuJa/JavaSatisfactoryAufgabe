import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String csvPath = "data\\SatisfactoryDatenJannesKurzke.CSV";

        ArrayList<Row> csvRows = ReadCSV.toArrayList(csvPath);
        csvRows = Aggregator.aggregate(csvRows);
        Sorter.sort(csvRows);

        for (Row myRow : csvRows) {
            System.out.println(myRow.Recipe + " " + myRow.RatePerMinOut1);
        }
    }
}
