import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String csvPath = "data\\SatisfactoryDatenJannesKurzke.CSV";

        System.out.println("***********************************");
        System.out.println("Unsorted");
        System.out.println("***********************************");

        ArrayList<Row> csvRows = ReadCSV.toArrayList(csvPath);
        for (Row myRow : csvRows) {
            System.out.println(myRow.Recipe + " " + myRow.RatePerMinOut1);
        }
        System.out.println(csvRows.size());

        System.out.println("***********************************");
        System.out.println("Sorted by HashMap");
        System.out.println("***********************************");

        csvRows = AggegatorHashMap.aggregate(csvRows);


        System.out.println("***********************************");
        System.out.println("Sorted by ProductionRate");
        System.out.println("***********************************");

        Sorter.mergeSort(csvRows);
        for (Row myRow : csvRows) {
            System.out.println(myRow.Recipe + " " + myRow.RatePerMinOut1);
        }
        System.out.println(csvRows.size());
    }
}
