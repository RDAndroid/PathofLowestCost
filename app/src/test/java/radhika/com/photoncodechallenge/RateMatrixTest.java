package radhika.com.photoncodechallenge;

import org.junit.Test;

import radhika.com.photoncodechallenge.utils.Coordinates;
import radhika.com.photoncodechallenge.utils.RateMatrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;



public class RateMatrixTest {
    private int[][] costMatrixInput = new int[][]{{1, 2, 3}, {4, 5, 2}, {2, 0, 1}};
    private RateMatrix costMatrix = new RateMatrix(costMatrixInput);

    @Test
    public void costMatrixInitTest() {
        assertEquals(1,costMatrix.getItem(new Coordinates(0, 0)).intValue());
        assertEquals(2,costMatrix.getItem(new Coordinates(0, 1)).intValue());
        assertEquals(3,costMatrix.getItem(new Coordinates(0, 2)).intValue());
        assertEquals(4,costMatrix.getItem(new Coordinates(1, 0)).intValue());
        assertEquals(5,costMatrix.getItem(new Coordinates(1, 1)).intValue());
        assertEquals(2,costMatrix.getItem(new Coordinates(1, 2)).intValue());
        assertEquals(2,costMatrix.getItem(new Coordinates(2, 0)).intValue());
        assertEquals(0,costMatrix.getItem(new Coordinates(2, 1)).intValue());
        assertEquals(1,costMatrix.getItem(new Coordinates(2, 2)).intValue());
    }

    @Test
    public void costMatrixNumberOfRowsTest() {
        assertEquals(3,costMatrix.getNumberOfRows());
    }
    @Test
    public void costMatrixNumberOfColumnsTest() {
        assertEquals(3,costMatrix.getNumberOfColumns());
    }
    @Test
    public void costMatrixgetInvalidCoordinatesRowTest() {
        assertNull(costMatrix.getItem(new Coordinates(4, 0)));
    }
    @Test
    public void costMatrixgetInvalidCoordinatesColumnTest() {

        assertNull(costMatrix.getItem(new Coordinates(4, 0)));
    }
    @Test
    public void costMatrixGetRightNextTest1() {
        assertTrue(costMatrix.getRightNextCoordinates(new Coordinates(1, 0)).equals(new Coordinates(1,1)));
    }
    @Test
    public void costMatrixGetRightNextTest2() {
        assertNull(costMatrix.getRightNextCoordinates(new Coordinates(1, 2)));
    }
    @Test
    public void costMatrixGetRightNextTest3() {
        assertNull(costMatrix.getRightNextCoordinates(new Coordinates(2, 2)));
    }
    @Test
    public void costMatrixGetRightAboveTest1() {
        assertTrue(costMatrix.getRightAboveCoordinates(new Coordinates(1, 0)).equals(new Coordinates(0,1)));
    }
    @Test
    public void costMatrixGetRightAboveTest2() {
        assertTrue(costMatrix.getRightAboveCoordinates(new Coordinates(0, 0)).equals(new Coordinates(2,1)));
    }
    @Test
    public void costMatrixGetRightAboveTest3() {
        assertNull(costMatrix.getRightAboveCoordinates(new Coordinates(2, 2)));
    }
    @Test
    public void costMatrixGetRightBelowTest1() {
        assertTrue(costMatrix.getRightBelowCoordinates(new Coordinates(1, 0)).equals(new Coordinates(2,1)));
    }
    @Test
    public void costMatrixGetRightBelowTest2() {
        assertTrue(costMatrix.getRightBelowCoordinates(new Coordinates(2, 0)).equals(new Coordinates(0,1)));
    }
    @Test
    public void costMatrixGetRightBelowTest3() {
        assertNull(costMatrix.getRightBelowCoordinates(new Coordinates(2, 2)));
    }
}
