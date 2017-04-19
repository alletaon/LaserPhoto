package com.karev.kvantron;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Servocon {
    private static Servocon ourInstance = new Servocon();

    public static Servocon getInstance() {
        return ourInstance;
    }

    private Servocon(){
        try {
            String[] name = {"-ORBInitRef", "NameService=corbaloc::192.168.0.211:3000/NameService"};
            ORB orb = ORB.init(name, null);
            Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent[] path = {new NameComponent("ServoConController", "POA")};
            Object tmp = ncRef.resolve(path);
            ServoConRemote.ICNCHelper.narrow(tmp);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connect() {

    }
}
