import java.util.ArrayList;

public class AggregateSorter {
    public static void mergeSort(ArrayList<Row> rows){
        int length = rows.size();
        if (length < 2){
            return;
        }
        int middleIndex = length / 2;
        ArrayList<Row> leftSide = new ArrayList<>();
        ArrayList<Row> rightSide = new ArrayList<>();
        for (int i = 0; i < length; i++){
            if (i < middleIndex){
                leftSide.add(rows.get(i));
            } else {
                rightSide.add(rows.get(i));
            }
        }
        mergeSort(leftSide);
        mergeSort(rightSide);
        merge(rows, leftSide, rightSide);
    }

    private static void merge(ArrayList<Row> rows, ArrayList<Row> leftSide, ArrayList<Row> rightSide) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < rows.size(); i++) {
            if (leftIndex >= leftSide.size()){
                rows.set(i, rightSide.get(rightIndex));
                rightIndex += 1;
                continue;
            } else if (rightIndex >= rightSide.size()){
                rows.set(i, leftSide.get(leftIndex));
                leftIndex += 1;
                continue;
            } else if (0 >= leftSide.get(leftIndex).Recipe.compareTo(rightSide.get(rightIndex).Recipe)){
                rows.set(i, leftSide.get(leftIndex));
                leftIndex += 1;
                continue;
            } else if (0 < leftSide.get(leftIndex).Recipe.compareTo(rightSide.get(rightIndex).Recipe)){
                rows.set(i, rightSide.get(rightIndex));
                rightIndex += 1;
                continue;
            } 
        }
    }
}
