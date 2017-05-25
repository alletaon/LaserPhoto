package com.karev.kvantron.model;

import com.karev.kvantron.util.ImageAdapter;
import javafx.beans.property.*;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.util.ArrayList;

public class Picture {
    private Image image;
    private StringProperty name;
    private DoubleProperty height;
    private DoubleProperty offsetX;
    private DoubleProperty offsetY;
    private ArrayList<String> slices;

    public Picture() {
        this(null, "", 0.0, 0.0, 0.0);
    }

    public Picture(Image image, String name, double height, double offsetX, double offsetY) {
        this.image =  image;
        this.name = new SimpleStringProperty(name);
        this.height = new SimpleDoubleProperty(height);
        this.offsetX = new SimpleDoubleProperty(offsetX);
        this.offsetY = new SimpleDoubleProperty(offsetY);
        slices = new ArrayList<>();
//        slice();
//        minimize();
    }

    @XmlJavaTypeAdapter(ImageAdapter.class)
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getHeight() {
        return height.get();
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public double getOffsetX() {
        return offsetX.get();
    }

    public DoubleProperty offsetXProperty() {
        return offsetX;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX.set(offsetX);
    }

    public double getOffsetY() {
        return offsetY.get();
    }

    public DoubleProperty offsetYProperty() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY.set(offsetY);
    }

    public int getStartX() {
        PixelReader reader = image.getPixelReader();
        int minX, result;
        result = Integer.MAX_VALUE;
        for (int y = 0; y < image.getHeight(); y++) {
            minX = result;
            for (int x = 0; x < image.getWidth(); x++) {
                if (reader.getColor(x, y).equals(Color.WHITE)) {
                    minX = x;
                    break;
                }
            }
            result = Math.min(minX, result);
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        return result;
    }

    public int getStartY() {
        PixelReader reader = image.getPixelReader();
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (reader.getColor(x, y).equals(Color.WHITE)) {
                    return y;
                }
            }
        }
        return -1;
    }

    public int getEndX() {
        PixelReader reader = image.getPixelReader();
        int result, maxX;
        result = -1;
        for (int y = 0; y < image.getHeight(); y++) {
            maxX = result;
            for (int x = 0; x < image.getWidth(); x++) {
                if (reader.getColor(x, y).equals(Color.WHITE)) {
                    maxX = x;
                }
            }
            result = Math.max(result, maxX);
        }
        return result;
    }

    public int getEndY() {
        PixelReader reader = image.getPixelReader();
        int result = -1;
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (reader.getColor(x, y).equals(Color.WHITE)) {
                    result = y;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return name.get();
    }

    private void slice() {
//        PixelReader reader = image.getValue().getPixelReader();
//        for (int y = 0; y < image.getValue().getHeight(); y++) {
//            StringBuilder sb = new StringBuilder();
//            for (int x = 0; x < image.getValue().getWidth(); x++) {
//                if (reader.getColor(x, y).equals(Color.WHITE)) {
//                    sb.append(1);
//                } else {
//                    sb.append(0);
//                }
//            }
//            slices.add(sb.toString());
//        }
    }

    private void minimize() {
        for (int i = 0; i < slices.size(); i++) {
            System.out.println(slices.get(i));
        }

    }
}
