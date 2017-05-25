package com.karev.kvantron;

import ServoConRemote.CNCError;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ServoConTest {
    ServoCon servoCon;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        servoCon = ServoCon.INSTANCE;
        servoCon.connect();
    }

    @Test
    public void connect() throws Exception {
    }

    @Test
    public void goToX() throws Exception {
        servoCon.goToX(0);
        assertEquals(0.0, servoCon.getPosition()[1], 0.01);
        servoCon.goToX(200);
        assertEquals(200.0, servoCon.getPosition()[1], 0.01);

    }

    @Test
    public void goToX1() throws Exception {
        servoCon.goToX(0, 1200);
        assertEquals(0.0, servoCon.getPosition()[1], 0.01);
        servoCon.goToX(200, 1200);
        assertEquals(200.0, servoCon.getPosition()[1], 0.01);

    }

    @Test
    public void goToY() throws Exception {
        servoCon.goToY(0);
        assertEquals(0.0, servoCon.getPosition()[0], 0.01);
        servoCon.goToY(200);
        assertEquals(200.0, servoCon.getPosition()[0], 0.01);

    }

    @Test
    public void goToY1() throws Exception {
        servoCon.goToY(0, 1200);
        assertEquals(0.0, servoCon.getPosition()[0], 0.01);
        servoCon.goToY(200, 1200);
        assertEquals(200.0, servoCon.getPosition()[0], 0.01);

    }

    @Test
    public void goToZ() throws Exception {
        servoCon.goToZ(0);
        assertEquals(0.0, servoCon.getPosition()[2], 0.01);
        servoCon.goToZ(50);
        assertEquals(50.0, servoCon.getPosition()[2], 0.01);

    }

    @Test
    public void goToZ1() throws Exception {
        servoCon.goToZ(0, 600);
        assertEquals(0.0, servoCon.getPosition()[2], 0.01);
        servoCon.goToZ(50, 600);
        assertEquals(50.0, servoCon.getPosition()[2], 0.01);

    }

    @Test
    public void goToPoint() throws Exception {
    }

    @Test
    public void goToPoint1() throws Exception {
    }

    @Test
    public void goToHome() throws Exception {
//        servoCon.goToHome();
//        assertArrayEquals(new double[]{-2650.253, -205.317, 64.313}, servoCon.getPosition(), 1.0);
    }

    @Test
    public void getStatus() throws Exception {
        assertEquals("ON", servoCon.getStatus());
    }

    @Test
    public void connectState() throws Exception {
        assertTrue(servoCon.connectState());
    }

    @Test
    public void jogX() throws Exception {
        servoCon.jogX(100);
        Thread.sleep(1000);
        servoCon.jogStop();
        servoCon.jogX(-100);
        Thread.sleep(1000);
        servoCon.jogStop();
    }

    @Test
    public void jogY() throws Exception {
        servoCon.jogY(100);
        servoCon.jogStop();
        servoCon.jogY(-100);
        servoCon.jogStop();
    }

    @Test
    public void jogZ() throws Exception {
        servoCon.jogZ(100);
        servoCon.jogStop();
        servoCon.jogZ(-100);
        servoCon.jogStop();
    }

    @Test
    public void jogStop() throws Exception {
    }

    @Test
    public void getPosition() throws Exception {
    }

}