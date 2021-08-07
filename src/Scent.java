import direction.Direction;

public class Scent {
    int x;
    int y;
    Direction direction;

    public Scent(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public boolean pickUpScent(int x, int y, Direction direction) {
        return this.x == x
                && this.y == y
                && this.direction.equals(direction);
    }
}
