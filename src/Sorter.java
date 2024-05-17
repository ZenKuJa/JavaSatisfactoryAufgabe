import java.util.ArrayList;

public class Sorter {
    public static void sort(ArrayList<Row> rows){
        int length = rows.size();
        if (length < 2){
            return;
        }
        int middleIndex = length / 2;
        Row[] leftSide = new Row[middleIndex];
        Row[] rightSide = new Row[length-middleIndex];
        for (int i = 0; i < length; i++){
            
        }
    }
}
