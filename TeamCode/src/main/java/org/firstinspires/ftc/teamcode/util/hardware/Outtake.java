package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class Outtake {
    private static final double TICKS_PER_REVOLUTION = 28;
    private final DcMotor flywheelMotor1, flywheelMotor2;

    public Outtake(HardwareMap hardwareMap){
        flywheelMotor1 = hardwareMap.get(DcMotor.class,"FlywheelMotorA");
        flywheelMotor2 = hardwareMap.get(DcMotor.class,"FlywheelMotorB");
        flywheelMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        flywheelMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        flywheelMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        flywheelMotor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheelMotor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void set_power(double power){
        flywheelMotor1.setPower(power);
        flywheelMotor2.setPower(power);
    }
    public double getRevolutionPosition() {
        return flywheelMotor1.getCurrentPosition() / TICKS_PER_REVOLUTION;
    }
}
