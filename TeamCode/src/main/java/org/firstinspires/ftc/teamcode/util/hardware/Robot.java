package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.hardware.rev.*;
import com.qualcomm.robotcore.hardware.*;
import org.firstinspires.ftc.robotcore.external.navigation.*;

public class Robot {
    private final DcMotor leftFrontDrive,leftBackDrive,rightFrontDrive,rightBackDrive;

    IMU imu;

    public Robot(HardwareMap hardwareMap) {
        leftFrontDrive = hardwareMap.get(DcMotor.class,"leftFront");
        leftBackDrive = hardwareMap.get(DcMotor.class,"leftBack");
        rightFrontDrive = hardwareMap.get(DcMotor.class,"rightFront");
        rightBackDrive = hardwareMap.get(DcMotor.class,"rightBack");

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);

        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.DOWN, RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD)));
    }
    public void setLeftFrontPower(double power) {
        leftFrontDrive.setPower(power);
    }
    public void setLeftBackPower(double power) {
        leftBackDrive.setPower(power);
    }
    public void setRightFrontPower(double power) {
        rightFrontDrive.setPower(power);
    }
    public void setRightBackPower(double power) {
        rightBackDrive.setPower(power);
    }
    public DcMotor getLeftFrontDrive() {
        return leftFrontDrive;
    }
    public DcMotor getLeftBackDrive() {
        return leftBackDrive;
    }
    public DcMotor getRightFrontDrive() {
        return rightFrontDrive;
    }
    public DcMotor getRightBackDrive() {
        return rightBackDrive;
    }

    //IMU
    public YawPitchRollAngles getOrientation(){
        assert imu != null;
        return imu.getRobotYawPitchRollAngles();
    }

    public double getYaw(){
        return getOrientation().getYaw();
    }

    public void resetYaw(){
        imu.resetYaw();
    }



    //Drive motor stuff
    public boolean isTargetPositionsForDriveMotorsSet(int position) {
        return(leftFrontDrive.getTargetPosition()==position && leftBackDrive.getTargetPosition()==position &&
                rightFrontDrive.getTargetPosition()==position && rightBackDrive.getTargetPosition()==position);
    }

    public static double getCountsPerInchForDriveMotors() {
        final double     COUNTS_PER_MOTOR_REV    = 384.5  ;    // eg: Using 5203 Yellowjacket 435 RPM w/ given encoder
        final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // Simple Bevel Gear ratio is 2:1
        final double     WHEEL_DIAMETER_INCHES   = 4;     // For figuring circumference
        return (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);
    }

    public void setDriveMode(DcMotor.RunMode mode) {
        leftFrontDrive.setMode(mode);
        rightFrontDrive.setMode(mode);
        leftBackDrive.setMode(mode);
        rightBackDrive.setMode(mode);
    }

    public void setLeftDrivePower(double power) {
        leftFrontDrive.setPower(power);
        leftBackDrive.setPower(power);
    }

    public void setRightDrivePower(double power) {
        rightFrontDrive.setPower(power);
        rightBackDrive.setPower(power);
    }

    public void setAllDrivePower(double power) {
        setLeftDrivePower(power);
        setRightDrivePower(power);
    }

    public void setStrafeLeftPower(double power){
        leftFrontDrive.setPower(-power);
        leftBackDrive.setPower(power);
        rightFrontDrive.setPower(power);
        rightBackDrive.setPower(-power);
    }

    public void setStrafeRightPower(double power){
        leftFrontDrive.setPower(power);
        leftBackDrive.setPower(-power);
        rightFrontDrive.setPower(-power);
        rightBackDrive.setPower(power);
    }

    public void setRotationClockwiseReset(int pos) {
        leftFrontDrive.setTargetPosition(leftFrontDrive.getCurrentPosition()-pos);
        leftBackDrive.setTargetPosition(leftBackDrive.getCurrentPosition()-pos);
        rightFrontDrive.setTargetPosition(rightFrontDrive.getCurrentPosition()+pos);
        rightBackDrive.setTargetPosition(rightBackDrive.getCurrentPosition()+pos);
        setDriveMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void setRotationClockwise(int pos) {
        leftFrontDrive.setTargetPosition(leftFrontDrive.getCurrentPosition()-pos);
        leftBackDrive.setTargetPosition(leftBackDrive.getCurrentPosition()-pos);
        rightFrontDrive.setTargetPosition(rightFrontDrive.getCurrentPosition()+pos);
        rightBackDrive.setTargetPosition(rightBackDrive.getCurrentPosition()+pos);
    }

    public void setDriveTargetPosition(int position) {
        leftFrontDrive.setTargetPosition(position);
        rightFrontDrive.setTargetPosition(position);
        leftBackDrive.setTargetPosition(position);
        rightBackDrive.setTargetPosition(position);
    }

    public void rotateClockwise(double speed) {
        leftFrontDrive.setPower(speed);
        rightFrontDrive.setPower(-speed);
        leftBackDrive.setPower(speed);
        rightBackDrive.setPower(-speed);
    }

    public void rotateCounterClockwise(double speed) {
        leftFrontDrive.setPower(-speed);
        rightFrontDrive.setPower(speed);
        leftBackDrive.setPower(-speed);
        rightBackDrive.setPower(speed);
    }




    public boolean atDriveTargetPosition(int epsilon) {
        return Math.abs(leftFrontDrive.getCurrentPosition()-leftFrontDrive.getTargetPosition())<=epsilon &&
                Math.abs(rightFrontDrive.getCurrentPosition()-rightFrontDrive.getTargetPosition())<=epsilon &&
                Math.abs(leftBackDrive.getCurrentPosition()-leftBackDrive.getTargetPosition())<=epsilon &&
                Math.abs(rightBackDrive.getCurrentPosition()-rightBackDrive.getTargetPosition())<=epsilon;
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
        return(leftFrontDrive.getCurrentPosition() >= leftFrontDrive.getTargetPosition() &&
                rightFrontDrive.getCurrentPosition() >= rightFrontDrive.getTargetPosition() &&
                leftBackDrive.getCurrentPosition() >= leftBackDrive.getTargetPosition() &&
                rightBackDrive.getCurrentPosition() >= rightBackDrive.getTargetPosition());
    }

    public boolean atDriveTargetPositionBackward() {
        return(leftFrontDrive.getCurrentPosition() <= leftFrontDrive.getTargetPosition() &&
                rightFrontDrive.getCurrentPosition() <= rightFrontDrive.getTargetPosition() &&
                leftBackDrive.getCurrentPosition() <= leftBackDrive.getTargetPosition() &&
                rightBackDrive.getCurrentPosition() <= rightBackDrive.getTargetPosition());
    }
}
