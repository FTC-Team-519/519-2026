package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Feeder {
    public static final double POWER = 0.9;
    private CRServo feeder;

    public Feeder(HardwareMap hardwareMap){
       feeder = hardwareMap.crservo.get("feederServo");
    }

    public void turnOn() {
        feeder.setPower(POWER);
    }
    public void turnOff() {
        feeder.setPower(0.0);
    }
}
