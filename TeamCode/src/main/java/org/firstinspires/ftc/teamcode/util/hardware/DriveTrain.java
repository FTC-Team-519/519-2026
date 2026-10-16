package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {
    private final DcMotor leftDrive, rightDrive;

    public DriveTrain(HardwareMap hardwareMap) {
        //TODO: figure out the actual names
        leftDrive = hardwareMap.get(DcMotor.class, "left");
        rightDrive = hardwareMap.get(DcMotor.class, "right");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public static double getCountsPerInchForDriveMotors() {
        final double     COUNTS_PER_MOTOR_REV    = 384.5  ;    // eg: Using 5203 Yellowjacket 435 RPM w/ given encoder
        final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // Simple Bevel Gear ratio is 2:1
        final double     WHEEL_DIAMETER_INCHES   = 4;     // For figuring circumference
        return (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);
    }

    public void setDriveMode(DcMotor.RunMode mode) {
        leftDrive.setMode(mode);
        rightDrive.setMode(mode);
    }
    public void setAllDrivePower(double power) {
        leftDrive.setPower(power);
        rightDrive.setPower(power);
    }

    public boolean atDriveTargetPosition(boolean isGoingForward) {
        if (isGoingForward) {
            return atDriveTargetPositionForward();
        }
        else {
            return atDriveTargetPositionBackward();
        }
    }

    public boolean atDriveTargetPositionForward() {
        return(leftDrive.getCurrentPosition() >= leftDrive.getTargetPosition() &&
                rightDrive.getCurrentPosition() >= rightDrive.getTargetPosition());
    }

    public boolean atDriveTargetPositionBackward() {
        return(leftDrive.getCurrentPosition() <= leftDrive.getTargetPosition() &&
                rightDrive.getCurrentPosition() <= rightDrive.getTargetPosition());
    }

    public void drive(double y, double rot){
        double l_power = y + rot;
        double r_power = y - rot;

        double max = 0.0;
        max = Math.max(Math.abs(l_power), Math.abs(r_power));

        if (max > 1.0) {
            l_power /= max;
            r_power /= max;
        }

        this.leftDrive.setPower(l_power);
        this.rightDrive.setPower(r_power);
    }
}
