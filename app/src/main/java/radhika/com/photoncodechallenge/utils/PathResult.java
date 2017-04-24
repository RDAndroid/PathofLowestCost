package radhika.com.photoncodechallenge.utils;

import java.util.ArrayList;

/**
 * Created by User on 4/23/2017.
 */

public class PathResult {
    ArrayList<Integer> lowestCostPath;
    Boolean isValidPath;
    int lowestCost;

    public PathResult(Boolean isValidPath,int lowestCost,ArrayList<Integer> lowestCostPath)
    {
        this.isValidPath=isValidPath;
        this.lowestCost=lowestCost;
        this.lowestCostPath=lowestCostPath;
    }
    public boolean equals(PathResult pathResult)
    {
        return (isValidPath==pathResult.isValidPath)&&(lowestCost==pathResult.lowestCost)&&(lowestCostPath.toString().equalsIgnoreCase(pathResult.lowestCostPath.toString()));
    }

    public ArrayList<Integer> getLowestCostPath() {
        return lowestCostPath;
    }

    public void setLowestCostPath(ArrayList<Integer> lowestCostPath) {
        this.lowestCostPath = lowestCostPath;
    }

    public Boolean getValidPath() {
        return isValidPath;
    }

    public void setValidPath(Boolean validPath) {
        isValidPath = validPath;
    }

    public int getLowestCost() {
        return lowestCost;
    }

    public void setLowestCost(int lowestCost) {
        this.lowestCost = lowestCost;
    }
}
