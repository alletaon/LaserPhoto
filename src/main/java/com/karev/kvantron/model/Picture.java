package com.karev.kvantron.model;

import com.karev.kvantron.util.ImageAdapter;
import javafx.beans.property.*;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.paint.Color;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Picture {
    private Image image;
    private StringProperty name;
    private DoubleProperty height;
    private DoubleProperty offsetX;
    private DoubleProperty offsetY;
    private ListSliceWrapper slices;
    private int xStart;
    private int xEnd;
    private int yStart;
    private int yEnd;


    public Picture() {
        this(null, "", 0.0, 0.0, 0.0);
    }

    public Picture(Image image, String name, double height, double offsetX, double offsetY) {
        this.image =  image;
        if (this.image != null) {
            new Thread(this::calculate).start();
        }
        this.name = new SimpleStringProperty(name);
        this.height = new SimpleDoubleProperty(height);
        this.offsetX = new SimpleDoubleProperty(offsetX);
        this.offsetY = new SimpleDoubleProperty(offsetY);
        slices = new ListSliceWrapper();

    }

    @XmlJavaTypeAdapter(ImageAdapter.class)
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        if (this.image != null) {
            new Thread(this::calculate).start();
        }
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

    @XmlElement(name = "xStart")
    public int getxStart() {
        return xStart;
    }

    @XmlElement(name = "xEnd")
    public int getxEnd() {
        return xEnd;
    }

    @XmlElement(name = "yStart")
    public int getyStart() {
        return yStart;
    }

    @XmlElement(name = "yEnd")
    public int getyEnd() {
        return yEnd;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    }

    @XmlElement(name = "slices")
    public ListSliceWrapper getSlices() {
        return slices;
    }

    private void calculate() {
        PixelReader reader = image.getPixelReader();
        int minX, maxX;
        xEnd = yStart = yEnd = -1;
        xStart = Integer.MAX_VALUE;
        for (int y = 0; y < image.getHeight(); y++) {
            minX = Integer.MAX_VALUE;
            maxX = -1;
            for (int x = 0; x < image.getWidth(); x++) {
                if (reader.getColor(x, y).equals(Color.WHITE)) {
                    if (yStart == -1) {
                        yStart = y;
                    }
                    if (yEnd != y) {
                        yEnd = y;
                    }
                    if (minX == Integer.MAX_VALUE) {
                        minX = x;
                    }
                    maxX = x;
                }
            }
            xStart = Math.min(xStart, minX);
            xEnd = Math.max(xEnd, maxX);
        }
        if (xStart == Integer.MAX_VALUE) {
            xStart = -1;
        }
        System.out.println("xStart - " + xStart +
                " xEnd - " + xEnd +
                " yStart - " + yStart +
                " yEnd - " + yEnd);
        setSlices();
    }

//    private void setSlices() {
//        PixelReader reader = image.getPixelReader();
//        int height = yEnd.get() - yStart.get();
//        int width = (xEnd.get() - xStart.get()) % 32 == 0 ? xEnd.get() - xStart.get() : xEnd.get() - xStart.get() + 1;
//        int[][] data = new int[height][width];
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                for (int i = 0; i < 32 && (x + i) < width; i++) {
//                    System.out.println(y + " - " + (x + i));
//                    data[y][x] = reader.getColor(xStart.get() + x + i, yStart.get() + y).equals(Color.WHITE) ?
//                            data[y][x] | (1 << i) : data[y][x] & ~(1 << i);
//                }
//            }
//        }
//        for (int[] aData : data) {
//            for (int anAData : aData) {
//                System.out.print(anAData + " ");
//            }
//            System.out.println();
//        }
//    }

    private void setSlices() {
        PixelReader reader = image.getPixelReader();
        List<Slice> list = new ArrayList<>();
        for (int y = yStart; y <= yEnd; y++) {
            Slice newLine = new Slice(xEnd - xStart);
            for (int x = xStart, i = 0; x <= xEnd; x++, i++) {
                if (reader.getColor(x, y).equals(Color.WHITE)) {
                    newLine.getData().set(i);
                } else {
                    newLine.getData().clear(i);
                }
            }
            list.add(newLine);
        }

        for (Slice slice : list) {
            System.out.println(Arrays.toString(slice.getData().toByteArray()));
        }
        slices.setSlices(list);
    }

    private void tstMethod() {
        PixelReader reader = image.getPixelReader();
        int scanlineStride = (int) image.getWidth();
        int[] pixels = new int[(int)((image.getWidth() + scanlineStride) * image.getHeight())];
        reader.getPixels(0, 0, (int) image.getWidth(), (int) image.getHeight(),
                WritablePixelFormat.getIntArgbInstance(), pixels, 0, scanlineStride);
        IntStream stream = Arrays.stream(pixels);
        stream.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return name.get();
    }

}
