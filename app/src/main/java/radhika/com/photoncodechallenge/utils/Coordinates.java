package radhika.com.photoncodechallenge.utils;

/**
 * Created by User on 4/23/2017.
 */

public class Coordinates {
    int x,y;
    public Coordinates(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public boolean equals(Coordinates coordinates)
    {
        return (this.x==coordinates.x)&&(this.y==coordinates.y);
    }
}
