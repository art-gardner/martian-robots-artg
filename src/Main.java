import java.awt.*;
import java.util.ArrayList;

public class Main {

    private ArrayList<Scent> scents = new ArrayList<>();

    public static void main(String[] args) {
        String input = "5 3\n1 1 E\nRFRFRFRF\n3 2 N\nFRRFLLFFRRFLL\n0 3 W\nLLFFFLFLFL";
        new Main().run(input);

    }

    public void run(String input) {
        String[] inputs = input.split("\n");
        Limit limit = new Limit(inputs[0]);

        for (int i=1; i< inputs.length-1; i+=2) {
            Robot robot = new Robot(inputs[i], inputs[i+1], limit);
            System.out.println(robot.move());
        }

    }
}