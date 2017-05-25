package com.karev.kvantron.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "settings")
public class Settings {
    private DoubleProperty cncMaxSpeed;
    private DoubleProperty cncMaxAcc;
    private DoubleProperty stepX;
    private DoubleProperty stepY;
    private BooleanProperty simetricaly;
    private DoubleProperty refractiveIndex;
    private DoubleProperty xZero;
    private DoubleProperty yZero;
    private DoubleProperty zZero;

    public Settings() {
        cncMaxSpeed = new SimpleDoubleProperty(0.0);
        cncMaxAcc = new SimpleDoubleProperty(0.0);
        stepX = new SimpleDoubleProperty(0.0);
        stepY = new SimpleDoubleProperty(0.0);
        simetricaly = new SimpleBooleanProperty(false);
        refractiveIndex = new SimpleDoubleProperty(0.0);
        xZero = new SimpleDoubleProperty(0.0);
        yZero = new SimpleDoubleProperty(0.0);
        zZero = new SimpleDoubleProperty(0.0);
    }

    public double getCncMaxSpeed() {
        return cncMaxSpeed.get();
    }

    public DoubleProperty cncMaxSpeedProperty() {
        return cncMaxSpeed;
    }

    public void setCncMaxSpeed(double cncMaxSpeed) {
        this.cncMaxSpeed.set(cncMaxSpeed);
    }

    public double getCncMaxAcc() {
        return cncMaxAcc.get();
    }

    public DoubleProperty cncMaxAccProperty() {
        return cncMaxAcc;
    }

    public void setCncMaxAcc(double cncMaxAcc) {
        this.cncMaxAcc.set(cncMaxAcc);
    }

    public double getStepX() {
        return stepX.get();
    }

    public DoubleProperty stepXProperty() {
        return stepX;
    }

    public void setStepX(double stepX) {
        this.stepX.set(stepX);
    }

    public double getStepY() {
        return stepY.get();
    }

    public DoubleProperty stepYProperty() {
        return stepY;
    }

    public void setStepY(double stepY) {
        this.stepY.set(stepY);
    }

    public boolean isSimetricaly() {
        return simetricaly.get();
    }

    public BooleanProperty simetricalyProperty() {
        return simetricaly;
    }

    public void setSimetricaly(boolean simetricaly) {
        this.simetricaly.set(simetricaly);
    }

    public double getRefractiveIndex() {
        return refractiveIndex.get();
    }

    public DoubleProperty refractiveIndexProperty() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(double refractiveIndex) {
        this.refractiveIndex.set(refractiveIndex);
    }

    public double getxZero() {
        return xZero.get();
    }

    public DoubleProperty xZeroProperty() {
        return xZero;
    }

    public void setxZero(double xZero) {
        this.xZero.set(xZero);
    }

    public double getyZero() {
        return yZero.get();
    }

    public DoubleProperty yZeroProperty() {
        return yZero;
    }

    public void setyZero(double yZero) {
        this.yZero.set(yZero);
    }

    public double getzZero() {
        return zZero.get();
    }

    public DoubleProperty zZeroProperty() {
        return zZero;
    }

    public void setzZero(double zZero) {
        this.zZero.set(zZero);
    }
}
