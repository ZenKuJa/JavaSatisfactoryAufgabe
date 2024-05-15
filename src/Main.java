import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String csvPath = "data\\SatisfactoryDatenJannesKurzke.CSV";
        ArrayList<Row> csvRows = ReadCSV.readCsvToList(csvPath);

    }
}
