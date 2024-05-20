import java.util.ArrayList;

public class Aggregator {
    public static ArrayList<Row> aggregate(ArrayList<Row> rows){
        ArrayList<Row> aggregatedRows = new ArrayList<>();
        Row currentRecipe = rows.get(0);
        int uniqueRecipes = 1;
        for (int i = 0; i < rows.size(); i++) {
            if (0 == currentRecipe.Recipe.compareTo(rows.get(i).Recipe)){
                System.out.println(rows.get(i).Recipe + " == " + currentRecipe.Recipe);
                System.out.println("***********************************");
            } else if (0 > currentRecipe.Recipe.compareTo(rows.get(i).Recipe)){
                System.out.println(rows.get(i).Recipe + " != " + currentRecipe.Recipe);
                currentRecipe = rows.get(i);
                uniqueRecipes += 1;
                System.out.println(rows.get(i).Recipe + " == " + currentRecipe.Recipe);
                System.out.println("***********************************");
            }
        }

        System.out.println(uniqueRecipes);
        
        return aggregatedRows;
    }
}
