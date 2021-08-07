import direction.Direction;
import direction.DirectionImpl;

import java.util.ArrayList;

public class Robot {

    private static ArrayList<Scent> scents = new ArrayList<>();

    int x;
    int y;
    Direction direction;
    Instructions instructions;
    Limit limit;

    public Robot(String start, String instructions, Limit limit) {
        String[] split = start.split("\s");

        this.x = Integer.parseInt(split[0]);
        this.y = Integer.parseInt(split[1]);
        this.direction = DirectionImpl.getDirection(split[2].charAt(0));
        this.instructions = new Instructions(instructions);
        this.limit = limit;
    }

    public String move() {
         while (instructions.hasNext()) {
             Character instruction = instructions.next();

             switch (instruction) {
                 case 'L' -> {
                     this.direction = this.direction.left();
                 }
                 case 'R' -> {
                     this.direction = this.direction.right();
                 }
                 case 'F' -> {
                     if (scents.stream().noneMatch(s -> s.pickUpScent(this.x, this.y, this.direction))) {
                         int[] movement = this.direction.forwards();
                         int newx = this.x + movement[0];
                         int newy = this.y + movement[1];

                         if (!(limit.isXInBounds(newx) && limit.isYInBounds(newy))) {
                             scents.add(new Scent(this.x, this.y, this.direction));
                             return this.x + "\s" + this.y + "\s" + direction.getLetter() + "\sLOST";
                         }

                         this.x = newx;
                         this.y = newy;
                     }
                 }
             }
         }
         return this.x + "\s" + this.y + "\s" + direction.getLetter();
    }
}
