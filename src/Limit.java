import java.awt.*;

public class Limit {

    int xlimit;
    int ylimit;

    public Limit(String input) {
        String[] coords = input.split("\s");
        xlimit = Integer.parseInt(coords[0]);
        ylimit = Integer.parseInt(coords[1]);
    }

    public boolean isXInBounds(int x) {
        return x >= 0 && x <= xlimit;
    }

    public boolean isYInBounds(int y) {
        return y >= 0 && y <= ylimit;
    }
}