package radhika.com.photoncodechallenge.utils;

import java.util.ArrayList;

/**
 * Created by User on 4/23/2017.
 */

public class Utils {
    public static final int[][] EXAMPLE_1 = new int[][]{
            { 3, 4, 1, 2, 8, 6 },
            { 6, 1, 8, 2, 7, 4 },
            { 5, 9, 3, 9, 9, 5 },
            { 8, 4, 1, 3, 2, 6 },
            { 3, 7, 2, 8, 6, 4 }
    };


    public static int[][] strintToArray(String items)
    {
        try {
            String[] rows = items.split("\n");
            String[] frstClmns = rows[0].split("\\s+");
            int[][] output = new int[rows.length][frstClmns.length];
            for (int row = 0; row < rows.length; row++) {
                String[] columns = rows[row].split("\\s+");
                for (int column = 0; column < columns.length; column++) {
                    if (column < output[0].length) {
                        output[row][column] = Integer.valueOf(columns[column]);
                    }
                }
            }

            return output;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new int[0][0];
        }

    }

    public static PathResult calculateLowestCostPath(String input)
    {

            int[][] inputArray = Utils.strintToArray(input);
            return findLowestCostPath(inputArray);

    }
    public static PathResult findLowestCostPath(int[][] inputMatrix)
    {
        RateMatrix costMatrix= new RateMatrix(inputMatrix);
        PathResult pathResult=null;
        for(int i=0;i<costMatrix.getNumberOfRows();i++)
        {
            PathResult rowPathResult = findPathForCoordinates(costMatrix,new Coordinates(i,0),0,new ArrayList<Integer>());
            if (pathResult==null||pathResult.lowestCost>rowPathResult.lowestCost)
            {
                if (rowPathResult.lowestCostPath.size()!=0)
                    pathResult = rowPathResult;
            }
        }
        if (pathResult==null)
        {
            pathResult=new PathResult(false,0,new ArrayList<Integer>());
        }
        return pathResult;
    }
    public static PathResult findPathForCoordinates(RateMatrix rateMatrix, Coordinates coordinates, int previousCost, ArrayList<Integer> previousPath)
    {
        int cost = previousCost+rateMatrix.getItem(coordinates);
        ArrayList<Integer> costPath = new ArrayList<>();
        for (int pathIndex:previousPath) {
            costPath.add(pathIndex);
        }
        costPath.add(coordinates.x+1);
        if (cost > 50) {
            return new PathResult(false,previousCost,previousPath);
        } else if (coordinates.y == rateMatrix.getNumberOfColumns()-1) {
            return new PathResult(true,cost,costPath);
        }
        PathResult rightAbovePath = findPathForCoordinates(rateMatrix,rateMatrix.getRightAboveCoordinates(coordinates),cost,costPath);
        PathResult rightbelowPath = findPathForCoordinates(rateMatrix,rateMatrix.getRightBelowCoordinates(coordinates),cost,costPath);
        PathResult rightPath = findPathForCoordinates(rateMatrix,rateMatrix.getRightNextCoordinates(coordinates),cost,costPath);
        if (compareResult(rightPath,rightAbovePath) && compareResult(rightPath,rightbelowPath))
        {
            return rightPath;
        } else if (compareResult(rightAbovePath,rightbelowPath)) {
            return rightAbovePath;
        } else {
            return rightbelowPath;
        }
    }
    public static Boolean compareResult(PathResult pathResult1, PathResult pathResult2)
    {
        if (pathResult1.lowestCostPath.size()==pathResult2.lowestCostPath.size())
        {
            return pathResult2.lowestCost>=pathResult1.lowestCost;
        }
        else
        {
            return pathResult2.lowestCostPath.size()<pathResult1.lowestCostPath.size();
        }
    }

}
