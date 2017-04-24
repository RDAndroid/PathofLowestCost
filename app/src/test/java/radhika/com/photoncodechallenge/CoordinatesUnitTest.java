package radhika.com.photoncodechallenge;

import org.junit.Test;

import radhika.com.photoncodechallenge.utils.Coordinates;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class CoordinatesUnitTest {
    @Test
    public void equalsTest(){
        Coordinates coordinates1=new Coordinates(1,2);
        Coordinates coordinates2=new Coordinates(1,2);
        Coordinates coordinates3=new Coordinates(1,3);
        assertTrue(coordinates1.equals(coordinates2));
        assertFalse(coordinates1.equals(coordinates3));
    }
}
