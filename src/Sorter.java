import java.util.ArrayList;

public class Sorter {
    public static void sort(ArrayList<Row> rows){
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
        sort(leftSide);
        sort(rightSide);
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
            } else if (leftSide.get(leftIndex).RatePerMinOut1 >= rightSide.get(rightIndex).RatePerMinOut1){
                rows.set(i, leftSide.get(leftIndex));
                leftIndex += 1;
                continue;
            } else if (leftSide.get(leftIndex).RatePerMinOut1 <= rightSide.get(rightIndex).RatePerMinOut1){
                rows.set(i, rightSide.get(rightIndex));
                rightIndex += 1;
                continue;
            } 
        }
    }
}
