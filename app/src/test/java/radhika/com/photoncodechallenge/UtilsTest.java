package radhika.com.photoncodechallenge;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import radhika.com.photoncodechallenge.utils.PathResult;
import radhika.com.photoncodechallenge.utils.Utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;



public class UtilsTest {
    @Test
    public void compareResultTest(){
        PathResult input1=new PathResult(true,5,new ArrayList<Integer>(Arrays.asList(1,2)));
        PathResult input2=new PathResult(true,8,new ArrayList<Integer>(Arrays.asList(3,4)));
        PathResult input3=new PathResult(true,10,new ArrayList<Integer>(Arrays.asList(1,8)));
        PathResult input4=new PathResult(true,4,new ArrayList<Integer>(Arrays.asList(3,2,5)));
        assertTrue(Utils.compareResult(input1,input2));
        assertFalse(Utils.compareResult(input3,input4));
    }
    @Test
    public void calculateLowestCostPathValidInputTest(){
        PathResult result1=new PathResult(true,5,new ArrayList<Integer>(Arrays.asList(1,2)));
        PathResult result2=Utils.calculateLowestCostPath("2 5\n4 3");
        assertTrue(result2.equals(result1));
    }
    @Test
    public void calculateLowestCostPathInValidInputTest() {
        assertNull(Utils.calculateLowestCostPath("1 2\n1"));
    }
    @Test
    public void calculateLowestCostPathSingleValueInputTest() {
        PathResult path=new PathResult(true,11,new ArrayList<Integer>(Arrays.asList(1)));
        assertTrue(Utils.calculateLowestCostPath("11").equals(path));
    }
    @Test
    public void calculateLowestCostPathSingleRowInputTest() {
        PathResult path=new PathResult(true,11,new ArrayList<Integer>(Arrays.asList(1,1,1)));
        assertTrue(Utils.calculateLowestCostPath("1 9 1").equals(path));
    }
    @Test
    public void calculateLowestCostPathSingleColumnInputTest() {
        PathResult path=new PathResult(true,4,new ArrayList<Integer>(Arrays.asList(3)));
        assertTrue(Utils.calculateLowestCostPath("5\n6\n4\n5\n6").equals(path));
    }
    @Test
    public void calculateLowestCostPathNegativeValuesInputTest() {
        PathResult path=new PathResult(true,10,new ArrayList<Integer>(Arrays.asList(1,2,3)));
        assertTrue(Utils.calculateLowestCostPath("1 20 3\n2 12 4\n3 45 -3").equals(path));
    }
    @Test
    public void calculateLowestCostPathSample1Test() {
        PathResult path=new PathResult(true,16,new ArrayList<Integer>(Arrays.asList(1,2,3,4,4,5)));
        assertTrue(Utils.calculateLowestCostPath("3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6\n3 7 2 8 6 4").equals(path));
    }
    @Test
    public void calculateLowestCostPathSample2Test() {
        PathResult pathresult1=new PathResult(true,11,new ArrayList<Integer>(Arrays.asList(1,2,1,5,5,5)));
        PathResult pathresult2=Utils.calculateLowestCostPath("3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6\n3 7 2 1 2 3");
        assertTrue(pathresult1.equals(pathresult2));
    }
    @Test
    public void calculateLowestCostPathSample3Test() {
        PathResult path=new PathResult(false,48,new ArrayList<Integer>(Arrays.asList(1,1,1)));
        assertTrue(Utils.calculateLowestCostPath("19 10 19 10 19\n21 23 20 19 12\n20 12 20 11 10").equals(path));
    }
    @Test
    public void calculateLowestCostPathSample4Test() {
        PathResult path=new PathResult(true,26,new ArrayList<Integer>(Arrays.asList(1,1,1,1,1)));
        assertTrue(Utils.calculateLowestCostPath("5 8 5 3 5").equals(path));
    }
    @Test
    public void calculateLowestCostPathSample5Test() {
        PathResult path=new PathResult(true,3,new ArrayList<Integer>(Arrays.asList(4)));
        assertTrue(Utils.calculateLowestCostPath("5\n8\n5\n3\n5").equals(path));
    }
    @Test
    public void calculateLowestCostPathSample6Test() {
        PathResult path=new PathResult(false,0,new ArrayList<Integer>());
        assertTrue(Utils.calculateLowestCostPath("69 10 19 10 19\n51 23 20 19 12\n60 12 20 11 10").equals(path));
    }
    @Test
    public void calculateLowestCostPathSample7Test() {
        PathResult path=new PathResult(true,10,new ArrayList<Integer>(Arrays.asList(1,2,3)));
        assertTrue(Utils.calculateLowestCostPath("1 20 3\n2 12 4\n3 45 -3").equals(path));
    }
    @Test
    public void calculateLowestCostPathSample8Test() {
        PathResult path=new PathResult(true,10,new ArrayList<Integer>(Arrays.asList(1,2,3)));
        assertTrue(Utils.calculateLowestCostPath("1 20 3\n2 12 4\n3 45 -3").equals(path));
    }
}
