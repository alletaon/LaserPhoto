package com.karev.kvantron;

import ServoConRemote.*;
import ServoConRemote.IUserParameterPackage.InvalidValue;
import ServoConRemote.IUserParameterPackage.IsReadOnly;
import ServoConRemote.LongProcessPackage.Status;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;

public enum ServoCon {
    INSTANCE;
    private ICNC icnc;
    private ORB orb;
    private Any jogVel;
    private Any enable;
    private Any disable;

    public boolean connect( ) {
        try {
            String ip = "192.168.0.213";
            String[] name = {"-ORBInitRef", "NameService=corbaloc::" + ip + ":3000/NameService"};
            orb = ORB.init(name, null);
            Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent[] path = {new NameComponent("ServoConController", "POA")};
            Object tmp = ncRef.resolve(path);
            icnc = ServoConRemote.ICNCHelper.narrow(tmp);
            jogVel = orb.create_any();
            enable = orb.create_any();
            enable.insert_long(1);
            disable = orb.create_any();
            disable.insert_long(0);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void goToX(double x) throws CNCError {
        executeCommand(String.format(Locale.ENGLISH, "G0Y%.3f", x));
    }

    public void goToX(double x, double vel) throws CNCError {
        executeCommand(String.format(Locale.ENGLISH, "G1Y%.3fF%.3f", x, vel));
    }

    public void goToY(double y) throws CNCError {
        executeCommand(String.format(Locale.ENGLISH, "G0X%.3f", y));
    }

    public void goToY(double y, double vel) throws CNCError {
        executeCommand(String.format(Locale.ENGLISH, "G1X%.3fF%.3f", y, vel));
    }

    public void goToZ(double z) throws CNCError {
        executeCommand(String.format(Locale.ENGLISH, "G0Z%.3f", z));
    }

    public void goToZ(double z, double vel) throws CNCError {
        executeCommand(String.format(Locale.ENGLISH, "G1Z%.3fF%.3f", z, vel));
    }

    public void goToPoint(double x, double y) throws CNCError {
        executeCommand(String.format(Locale.ENGLISH, "G0X%.3fY%.3f", x, y));
    }

    public void goToPoint(double x, double y, double vel) throws CNCError {
        executeCommand(String.format(Locale.ENGLISH, "G1X%.3fY%.3fF%.3f", x, y, vel));
    }

    public void goToHome() throws CNCError {
        LongProcess process = icnc.StartHoming();
        idleProcess(process);
    }

    public String getStatus() {
        return icnc.State().GetTextValue();
    }

    public void toggleState() throws CNCError {
        icnc.ToggleState();
    }

    public boolean connectState() {
        try {
            InetAddress inetAddress = InetAddress.getByAddress(new byte[]{(byte) 192, (byte) 168, 0, (byte) 213});
            return inetAddress.isReachable(500);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void jogX(double velocity) throws Impossible {
        jogVel.insert_double(velocity);
        setParameter("jogger.pdu-x-enable", enable);
        setParameter("jog-helper.0.vel", jogVel);
    }

    public void jogY(double velocity) throws Impossible {
        jogVel.insert_double(velocity);
        setParameter("jogger.pdu-y-enable", enable);
        setParameter("jog-helper.1.vel", jogVel);
    }

    public void jogZ(double velocity) throws Impossible {
        jogVel.insert_double(velocity);
        setParameter("jogger.pdu-z-enable", enable);
        setParameter("jog-helper.2.vel", jogVel);
    }

    public void jogStop() throws Impossible {
        jogVel.insert_double(0);
        setParameter("jogger.pdu-x-enable", disable);
        setParameter("jogger.pdu-y-enable", disable);
        setParameter("jogger.pdu-z-enable", disable);
        setParameter("jog-helper.0.vel", jogVel);
        setParameter("jog-helper.1.vel", jogVel);
        setParameter("jog-helper.2.vel", jogVel);
    }

    /**
     *
     * @return position double[x, y, z]
     */
    public double[] getPosition() {
        Position position = icnc.GetPartPosition();
        return new double[] {position.X, position.Y, position.Z};
    }

    private void executeCommand(String command) throws CNCError {
        LongProcess process = icnc.ExecuteCommand(command);
        idleProcess(process);
    }

    private void idleProcess(LongProcess process) throws CNCError {
        while (process.Completed() == Status.InProgress);
        if (process.Completed() != Status.Done) {
            throw new CNCError(process.Message());
        }
    }

    private void setParameter(String name, Any value) throws Impossible {
        try {
            icnc.Parameter(name).SetValue(value);
        } catch (IsReadOnly | InvalidValue | NotFound ex) {
            ex.printStackTrace();
        }
    }

}
