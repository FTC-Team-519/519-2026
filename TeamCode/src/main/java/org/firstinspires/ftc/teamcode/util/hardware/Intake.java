package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private final DcMotor intakeMotor;
    public Intake(HardwareMap hardwareMap){
        intakeMotor = hardwareMap.dcMotor.get("intakeMotor");
    }

    public void turnOn(){
        intakeMotor.setPower(1.0);
    }
    public void turnOff() {
        intakeMotor.setPower(0.0);
    }
}
