package com.karev.kvantron;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;

public class GateController {
    private SerialPort serialPort;

    public void connect() {
        serialPort = new SerialPort("COM5");
        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (serialPort != null) {
            try {
                serialPort.closePort();
            } catch (SerialPortException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendString(byte[] string) throws SerialPortException, SerialPortTimeoutException {
        serialPort.writeBytes(string);
        serialPort.readIntArray(64, 500);
    }

    public void setInitialPoint() {

    }

    public void setStep(double step) {

    }

    private class Request {
        private int[] buffer;
        private final int SIZE = 64;
//        buffer[0] - comand
//        buffer[60 - 63] - src if need

        public Request() {
            buffer = new int[SIZE];
        }


    }

    private class Response {
        private int[] buffer;
    }
}
