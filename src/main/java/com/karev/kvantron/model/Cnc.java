package com.karev.kvantron.model;

import javafx.beans.property.*;

public class Cnc {
    private DoubleProperty xPosition;
    private DoubleProperty yPosition;
    private DoubleProperty zPosition;
    private BooleanProperty cncConnect;
    private StringProperty cncState;
    private BooleanProperty laserState;
    private DoubleProperty jogVelocity;

    public double getJogVelocity() {
        return jogVelocity.get();
    }

    public DoubleProperty jogVelocityProperty() {
        return jogVelocity;
    }

    public void setJogVelocity(double jogVelocity) {
        this.jogVelocity.set(jogVelocity);
    }

    public Cnc() {
        xPosition = new SimpleDoubleProperty(0.0);
        yPosition = new SimpleDoubleProperty(0.0);
        zPosition = new SimpleDoubleProperty(0.0);
        cncState = new SimpleStringProperty("");
        jogVelocity = new SimpleDoubleProperty(0.0);
        cncConnect = new SimpleBooleanProperty(false);
    }

    public double getxPosition() {
        return xPosition.get();
    }

    public DoubleProperty xPositionProperty() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition.set(xPosition);
    }

    public double getyPosition() {
        return yPosition.get();
    }

    public DoubleProperty yPositionProperty() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition.set(yPosition);
    }

    public double getzPosition() {
        return zPosition.get();
    }

    public DoubleProperty zPositionProperty() {
        return zPosition;
    }

    public void setzPosition(double zPosition) {
        this.zPosition.set(zPosition);
    }

    public boolean isCncConnect() {
        return cncConnect.get();
    }

    public BooleanProperty cncConnectProperty() {
        return cncConnect;
    }

    public void setCncConnect(boolean cncConnect) {
        this.cncConnect.set(cncConnect);
    }

    public String getCncState() {
        return cncState.get();
    }

    public StringProperty cncStateProperty() {
        return cncState;
    }

    public void setCncState(String cncState) {
        this.cncState.set(cncState);
    }

    public boolean isLaserState() {
        return laserState.get();
    }

    public BooleanProperty laserStateProperty() {
        return laserState;
    }

    public void setLaserState(boolean laserState) {
        this.laserState.set(laserState);
    }
}
