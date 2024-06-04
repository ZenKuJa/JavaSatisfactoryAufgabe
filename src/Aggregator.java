import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aggregator {

    /** Erzeugt ArrayList<Row> mit Rezept-Varianten mit höchster
     * RatePerMinOut1 für jedes Item
     * @param rows zu sortierende Datei**/
    public static ArrayList<Row> aggregate(ArrayList<Row> rows) {

        ArrayList<Row> aggregatedRows = new ArrayList<>();
        HashMap<String, ArrayList<Row>> uniqueRecipes = new HashMap<>();

        //Rezepte werden nach Output-Item in HashMap sortiert
        for (Row row : rows) {
            if (!uniqueRecipes.containsKey(row.Recipe)) {
                uniqueRecipes.put(row.Recipe, new ArrayList<>());
            }
            uniqueRecipes.get(row.Recipe).add(row);
        }

        //Aus der HashMap wird für jedes Rezept das beste ausgewählt
        for (Map.Entry<String, ArrayList<Row>> entry: uniqueRecipes.entrySet()) {
            Row highestProdRate = new Row();
            if (entry.getValue().size() > 1){ //Wenn mehrere Rezept-Varianten
                highestProdRate = Aggregator.getHighRate(entry.getValue());
            } else { //Wenn nur ein Rezept
                highestProdRate = entry.getValue().get(0);
            }
            aggregatedRows.add(highestProdRate);
        }
        return aggregatedRows;
    }

    /**Wählt das Rezept mit höchster RatePerMinOut1 aus ArrayList<Row> aus**/
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
