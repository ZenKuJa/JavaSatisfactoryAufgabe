import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aggegator {
    public static ArrayList<AggegatedRow> aggregate(ArrayList<Row> rows) {

        ArrayList<AggegatedRow> aggegatedRows = new ArrayList<>();

        HashMap<String, ArrayList<Row>> uniqueRecipes = new HashMap<>();

        for (Row row : rows) {
            if (!uniqueRecipes.containsKey(row.Recipe)) {
                uniqueRecipes.put(row.Recipe, new ArrayList<>());
            }
            uniqueRecipes.get(row.Recipe).add(row);
        }

        for (Map.Entry<String, ArrayList<Row>> entry : uniqueRecipes.entrySet()) {
            System.out.println(entry.getKey());
            for (Row row : entry.getValue()) {
                System.out.println(row.Recipe + " " + row.RatePerMinOut1);
            }

            System.out.println("****************");
        }

        System.out.println(uniqueRecipes.size());

        return aggegatedRows;
    }
}
