package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private final CRServo intakeServoLeft;
    private final CRServo intakeServoRight;
    private final DcMotor intakeMotor;

    public Intake (HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        intakeServoLeft = hardwareMap.get(CRServo.class, "intakeServoLeft");
        intakeServoRight = hardwareMap.get(CRServo.class, "intakeServoRight");

    }

    public void turnOn(){
        intakeMotor.setPower(0.5);
        intakeServoLeft.setPower(0.5);
        intakeServoRight.setPower(0.5);
    }

    public void turnOff(){
        intakeMotor.setPower(0);
        intakeServoLeft.setPower(0);
        intakeServoRight.setPower(0);
    }
}