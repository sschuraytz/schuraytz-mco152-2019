package schuraytz.golf;

import schuraytz.physics.Projectile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GolfCourseComponent extends JComponent {

    private static final int BALL_START_X = 20;
    private static final int BALL_WIDTH = 15;
    private static final int POLE_WIDTH = 4;
    private static final int POLE_HEIGHT = 90;
    private static final int FLAG_WIDTH = 26;

    BufferedImage littleCloud = createCloudBI("cloud1.png");
    BufferedImage bigCloud = createCloudBI("cloud2.png");
    Projectile projectile = new Projectile(80, 45);

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        drawSky(graphics);
        drawLittleClouds(graphics);
        drawBigClouds(graphics);

        drawGrass(graphics);
        drawGround(graphics);

        drawGolfBall(graphics);
        drawFlag(graphics);
        drawFlagPole(graphics);

        moveBall();
    }

    public void drawSky(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        GradientPaint gradient = new GradientPaint(
                0, 0, Color.BLUE.brighter(),
                0, 300, Color.CYAN);
        graphics2d.setPaint(gradient);
        graphics2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public BufferedImage createCloudBI(String imagePath) {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myPicture;
    }

    public void drawLittleClouds(Graphics graphics) {
        int currentWidth = 0;
        int x = 0;
        int y = 20;
        while (currentWidth < getWidth()) {
            if (currentWidth % 2 == 0) {
                x += 300;
                y += 32;
            } else {
                x += 420;
                y -= 20;
            }
            graphics.drawImage(littleCloud, x, y, null);
            currentWidth += 79;
        }
    }

    public void drawBigClouds(Graphics graphics) {
        int currentWidth = 0;
        int x = 0;
        int y = 15;
        while (currentWidth < getWidth()) {
            graphics.drawImage(bigCloud, x, y, null);
            x += 600;
            if (currentWidth % 2 == 0) {
                y += 20;
            } else {
                y -= 30;
            }
            currentWidth += 101;
        }
    }

    public void drawGrass(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        GradientPaint gradient = new GradientPaint(
                0, 0, Color.green.brighter(),
                700, 300, Color.green.darker());
        graphics2d.setPaint(gradient);
        graphics2d.fillRect(0, getHeight() * 2 / 3, getWidth(), getHeight());
    }

    public void drawGround(Graphics graphics) {
        int num = 4;
        int denom = 5;
        for (int ix = 0; ix < 5; ix++) {
            if (ix % 2 == 0) {
                graphics.setColor(new Color(100, 51, 0));
            } else {
                graphics.setColor(new Color(64, 34, 6));
            }
            graphics.fillRect(0, getHeight() * num++ / denom++, getWidth(), getHeight());
        }
    }

    public void drawGolfBall(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setPaint(Color.WHITE);
        int ball_x = (int) projectile.getX();
        int ball_y = getHeight()*2/3 - BALL_WIDTH + (int) -projectile.getY();
        graphics2d.fillOval(ball_x, ball_y, BALL_WIDTH, BALL_WIDTH);
    }

    public void drawFlag(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillPolygon(new int[]{BALL_START_X + BALL_WIDTH + 600,
                        BALL_START_X + BALL_WIDTH + 550,
                        BALL_START_X + BALL_WIDTH + 600},
                new int[]{getHeight() * 2 / 3 - POLE_HEIGHT - FLAG_WIDTH,
                        getHeight() * 2 / 3 - POLE_HEIGHT,
                        getHeight() * 2 / 3 - POLE_HEIGHT + FLAG_WIDTH},
                3);
    }

    public void drawFlagPole(Graphics graphics) {
        graphics.setColor(new Color(229, 180, 155));
        graphics.fillRect(BALL_START_X + BALL_WIDTH + 600, getHeight() * 2 / 3 - POLE_HEIGHT - FLAG_WIDTH, POLE_WIDTH, POLE_HEIGHT + FLAG_WIDTH);
    }

    public void moveBall() {
        projectile.addTime(.1);
        //while()
        repaint();
    }
}
