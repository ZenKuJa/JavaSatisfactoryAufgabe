import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AggegatorHashMap {
    public static ArrayList<Row> aggregate(ArrayList<Row> rows) {

        ArrayList<Row> aggegatedRows = new ArrayList<>();

        HashMap<String, ArrayList<Row>> uniqueRecipes = new HashMap<>();

        for (Row row : rows) {
            if (!uniqueRecipes.containsKey(row.Recipe)) {
                uniqueRecipes.put(row.Recipe, new ArrayList<>());
            }
            uniqueRecipes.get(row.Recipe).add(row);
        }

        for (Map.Entry<String, ArrayList<Row>> entry: uniqueRecipes.entrySet()) {
            System.out.println(entry.getKey());
            for (Row row : entry.getValue()) {
                System.out.println(row.Recipe + " " + row.RatePerMinOut1);
            }
            System.out.println("****************");

            if (entry.getValue().size() > 1){
                aggegatedRows.add(getHighestProductionRate(entry.getValue()));
            } else {
                aggegatedRows.add(entry.getValue().get(0));
            }
        }

        System.out.println(uniqueRecipes.size());

        return aggegatedRows;
    }

    private static Row getHighestProductionRate(ArrayList<Row> rows){
        Row maxRow = new Row();
        
        for (Row row: rows){
            if (row.RatePerMinOut1 > maxRow.RatePerMinOut1){
                maxRow = row;
            }
        }
        return maxRow;
    }
}
