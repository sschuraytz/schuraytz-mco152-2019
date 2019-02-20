package schuraytz.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {

    @Test
    public void getLocationAfter3Seconds() {
        // given
        Projectile p = new Projectile(67, 48);

        // when
        p.addTime(3);

        // then
        double x = p.getX();
        double y = p.getY();
        assertEquals(134.49, x, .01);
        assertEquals(105.27, y, .01);
        //assertEquals(134.4952518781305, x);
        //assertEquals(105.27210992095624, y);

    }

}

//tests are divided into 3 parts - each test method only tests one thing
// 1) given - set up the parameters of test
// 2) when - actually trigger thing you want to test (2-3 lines)
// 3) then - put in all your assertions to check it did what you think it did
// do not use keyword "assert" in tests