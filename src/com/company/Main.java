package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();

        ArrayList<Projectile> projectileList = new ArrayList<>();

        for (int sec = 0; sec <= 120; sec++) {
            int totalCount = rand.nextInt(5);
            for (int counter = 0; counter <= totalCount; counter++) {
                Projectile pr = new Projectile((50 + (120 - 50) * rand.nextDouble()), (30 + (150 - 30) * rand.nextDouble()));
                projectileList.add(pr);
            }
            for (int ix = 0; ix <= (projectileList.size() - 1); ix++) {
                projectileList.get(ix).addTime(1);
            }
        }
        for (int ix = 0; ix <= (projectileList.size() - 1); ix++) {
            if (projectileList.get(ix).getY() > 0) {
                System.out.println(projectileList.get(ix).toString());
            }
        }
    }
}