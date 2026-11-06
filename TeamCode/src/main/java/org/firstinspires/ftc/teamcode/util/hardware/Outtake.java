package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class Outtake {
    private final DcMotor flywheelMotor;

    public Outtake(HardwareMap hardwareMap){
        flywheelMotor = hardwareMap.get(DcMotor.class,"FlywheelMotor");
    }

    public void turnON(){
        flywheelMotor.setPower(0.9);
    }
    public void turnOff(){
        flywheelMotor.setPower(0.0);
    }
}
