package com.karev.kvantron.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "glass")
public class Glass {
    private DoubleProperty length;
    private DoubleProperty width;
    private DoubleProperty thickness;

    public Glass() {
        this(0.0, 0.0, 0.0);
    }

    public Glass(double length, double width, double thickness) {
        this.length = new SimpleDoubleProperty(length);
        this.width = new SimpleDoubleProperty(width);
        this.thickness = new SimpleDoubleProperty(thickness);
    }

    public double getLength() {
        return length.get();
    }

    public DoubleProperty lengthProperty() {
        return length;
    }

    public void setLength(double length) {
        this.length.set(length);
    }

    public double getWidth() {
        return width.get();
    }

    public DoubleProperty widthProperty() {
        return width;
    }

    public void setWidth(double width) {
        this.width.set(width);
    }

    public double getThickness() {
        return thickness.get();
    }

    public DoubleProperty thicknessProperty() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness.set(thickness);
    }
}
