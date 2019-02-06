package schuraytz.fire;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        final int MIN_VELOCITY = 50;
        final int MAX_VELOCITY = 120;
        final int MIN_DEGREE = 30;
        final int MAX_DEGREE = 150;
        final int TOTAL_SEC = 120;

        ArrayList<Projectile> projectileList = new ArrayList<>();

        for (int sec = 0; sec <= TOTAL_SEC; sec++) {
            int totalCount = rand.nextInt(5);
            for (int counter = 0; counter <= totalCount; counter++) {
                Projectile pr = new Projectile((MIN_VELOCITY + (MAX_VELOCITY - MIN_VELOCITY) * rand.nextDouble()), (MIN_DEGREE + (MAX_DEGREE - MIN_DEGREE) * rand.nextDouble()));
                projectileList.add(pr);
            }
            for (Projectile p : projectileList) {
                p.addTime(1);
            }
        }
        for (int ix = 0; ix <= (projectileList.size() - 1); ix++) {
            if (projectileList.get(ix).getY() > 0) {
                System.out.println(projectileList.get(ix).toString());
            }
        }
    }
}