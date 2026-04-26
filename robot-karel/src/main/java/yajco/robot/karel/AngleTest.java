package yajco.robot.karel;

public class AngleTest {
    public static void main(String[] args) {
        int angle = 0;
        for (int i = 0; i < 360; i += 90) {
            testAngle(angle + i);
        }
    }

    public static void testAngle(int angle) {
        int x = (180 - angle) % 180 / 90;
        int y = (angle - 90) % 180 / 90;
        System.out.println("angle=" + angle + " x=" + x + " y=" + y);
    }
}
