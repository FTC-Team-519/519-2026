package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Outtake {
    private HardwareMap hardwareMap;
    private final DcMotor OuttakeMotorForward, OuttakeMotorReverse;

    public Outtake(HardwareMap hardwareMap) {
        //they should be at the same power, but in opposite directions
        OuttakeMotorForward = hardwareMap.get(DcMotor.class, "OuttakeMotorForward");
        OuttakeMotorReverse = hardwareMap.get(DcMotor.class, "OuttakeMotorReverse");

        OuttakeMotorForward.setDirection(DcMotor.Direction.FORWARD);
        OuttakeMotorReverse.setDirection(DcMotor.Direction.REVERSE);
    }

    //set power of the outtake motors
    public void setPower(double power) {
        OuttakeMotorForward.setPower(power);
        OuttakeMotorReverse.setPower(power);
    }
}
