package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    public static final double INTAKE_POWER = 1.0;
    private final CRServo intakeServoLeft;
    private final CRServo intakeServoRight;
    private final DcMotor intakeMotor;

    public Intake (HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        intakeServoLeft = hardwareMap.get(CRServo.class, "intakeServoLeft");
        intakeServoRight = hardwareMap.get(CRServo.class, "intakeServoRight");
        intakeServoLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void turnOn(){
        intakeMotor.setPower(INTAKE_POWER);
        intakeServoLeft.setPower(INTAKE_POWER);
        intakeServoRight.setPower(INTAKE_POWER);
    }

    public void turnOff(){
        intakeMotor.setPower(0);
        intakeServoLeft.setPower(0);
        intakeServoRight.setPower(0);
    }
}