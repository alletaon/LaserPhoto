package com.karev.kvantron.model;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class PictureTest {
    private Picture picture;
    private WritableImage image;
    private PixelWriter writer;
    @Before
    public void setUp() throws Exception {
        picture = new Picture();
        WritableImage image = new WritableImage(10, 10);

        writer = image.getPixelWriter();
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                writer.setColor(x, y, Color.BLACK);
            }
        }

        picture.setImage(image);

    }
    private void setFromArray(int[][] array) {
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                writer.setColor(x, y, array[y][x] == 0 ? Color.BLACK : Color.WHITE);
            }
        }
    }
    private void clear(){
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                writer.setColor(x, y, Color.BLACK);
            }
        }
    }

    @Test
    public void getStartX() throws Exception {
        //no white pixels
        assertEquals(-1, picture.getStartX());

        //left top
        writer.setColor(0, 0, Color.WHITE);
        assertEquals(0, picture.getStartX());
        writer.setColor(0, 0, Color.BLACK);

        //right top
        writer.setColor(9, 0, Color.WHITE);
        assertEquals(9, picture.getStartX());
        writer.setColor(9, 0, Color.BLACK);

        //left bottom
        writer.setColor(0, 9, Color.WHITE);
        assertEquals(0, picture.getStartX());
        writer.setColor(0, 9, Color.BLACK);

        //right bottom
        writer.setColor(9, 9, Color.WHITE);
        assertEquals(9, picture.getStartX());
        writer.setColor(9, 9, Color.BLACK);

        //random pixel
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        writer.setColor(x, y, Color.WHITE);
        assertEquals(x, picture.getStartX());
        writer.setColor(x, y, Color.BLACK);

//        setFromArray(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                                {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
//                                {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
//                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});

    }

    @Test
    public void getStartY() throws Exception {
        //no white pixels
        assertEquals(-1, picture.getStartY());

        //left top
        writer.setColor(0, 0, Color.WHITE);
        assertEquals(0, picture.getStartY());
        writer.setColor(0, 0, Color.BLACK);

        //right top
        writer.setColor(9, 0, Color.WHITE);
        assertEquals(0, picture.getStartY());
        writer.setColor(9, 0, Color.BLACK);

        //left bottom
        writer.setColor(0, 9, Color.WHITE);
        assertEquals(9, picture.getStartY());
        writer.setColor(0, 9, Color.BLACK);

        //right bottom
        writer.setColor(9, 9, Color.WHITE);
        assertEquals(9, picture.getStartY());
        writer.setColor(9, 9, Color.BLACK);

        //random pixel
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        writer.setColor(x, y, Color.WHITE);
        assertEquals(y, picture.getStartY());
        writer.setColor(x, y, Color.BLACK);

    }

    @Test
    public void getEndY() throws Exception {
        //no white pixels
        assertEquals(-1, picture.getEndY());

        //left top
        writer.setColor(0, 0, Color.WHITE);
        assertEquals(0, picture.getEndY());
        writer.setColor(0, 0, Color.BLACK);

        //right top
        writer.setColor(9, 0, Color.WHITE);
        assertEquals(0, picture.getEndY());
        writer.setColor(9, 0, Color.BLACK);

        //left bottom
        writer.setColor(0, 9, Color.WHITE);
        assertEquals(9, picture.getEndY());
        writer.setColor(0, 9, Color.BLACK);

        //right bottom
        writer.setColor(9, 9, Color.WHITE);
        assertEquals(9, picture.getEndY());
        writer.setColor(9, 9, Color.BLACK);

        //random pixel
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        writer.setColor(x, y, Color.WHITE);
        assertEquals(y, picture.getEndY());
        writer.setColor(x, y, Color.BLACK);
    }

    @Test
    public void getEndX() throws Exception {
        //no white pixels
        assertEquals(-1, picture.getStartX());

        //left top
        writer.setColor(0, 0, Color.WHITE);
        assertEquals(0, picture.getStartX());
        writer.setColor(0, 0, Color.BLACK);

        //right top
        writer.setColor(9, 0, Color.WHITE);
        assertEquals(9, picture.getStartX());
        writer.setColor(9, 0, Color.BLACK);

        //left bottom
        writer.setColor(0, 9, Color.WHITE);
        assertEquals(0, picture.getStartX());
        writer.setColor(0, 9, Color.BLACK);

        //right bottom
        writer.setColor(9, 9, Color.WHITE);
        assertEquals(9, picture.getStartX());
        writer.setColor(9, 9, Color.BLACK);

        //random pixel
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        writer.setColor(x, y, Color.WHITE);
        assertEquals(x, picture.getStartX());
        writer.setColor(x, y, Color.BLACK);
    }

}