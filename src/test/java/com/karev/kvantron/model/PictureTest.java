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

}