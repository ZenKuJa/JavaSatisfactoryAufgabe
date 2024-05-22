import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aggregator {
    public static ArrayList<Row> aggregate(ArrayList<Row> rows) {

        ArrayList<Row> aggregatedRows = new ArrayList<>();
        HashMap<String, ArrayList<Row>> uniqueRecipes = new HashMap<>();

        for (Row row : rows) {
            if (!uniqueRecipes.containsKey(row.Recipe)) {
                uniqueRecipes.put(row.Recipe, new ArrayList<>());
            }
            uniqueRecipes.get(row.Recipe).add(row);
        }

        for (Map.Entry<String, ArrayList<Row>> entry: uniqueRecipes.entrySet()) {
            Row highestProdRate = new Row();
            if (entry.getValue().size() > 1){
                highestProdRate = Aggregator.getHighRate(entry.getValue());
            } else {
                highestProdRate = entry.getValue().get(0);
            }
            aggregatedRows.add(highestProdRate);
        }
        return aggregatedRows;
    }

    private static Row getHighRate(ArrayList<Row> rows){
        Row maxRow = new Row();
        
        for (Row row: rows){
            if (row.RatePerMinOut1 > maxRow.RatePerMinOut1){
                maxRow = row;
            }
        }
        return maxRow;
    }
}
