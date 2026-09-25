package org.firstinspires.ftc.teamcode.util.commands.actions;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.util.hardware.DriveTrain;
import org.firstinspires.ftc.teamcode.util.hardware.Robot;
import org.firstinspires.ftc.teamcode.util.commands.Command;

// Uses encoders
public class DriveForward implements Command {
    private final double distance;
    private final DriveTrain driveTrain;
    private double power;

    public DriveForward(double inches, double power, Robot robot) {
        distance = inches*DriveTrain.getCountsPerInchForDriveMotors()/2;

        // init robot
        this.driveTrain = robot.getDriveTrain();
        this.power = power;
    }

    public void init() {
        this.driveTrain.setDriveMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.driveTrain.setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.driveTrain.setDriveTargetPosition((int)distance);
    }
    //    @Override
    public void run() {
        if(distance>=0) {
            this.driveTrain.setAllDrivePower(power);
        } else {
            this.driveTrain.setAllDrivePower(-power);
        }
    }

    public void shutdown() {
        this.driveTrain.setAllDrivePower(0.0);
        this.driveTrain.setDriveMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.driveTrain.setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //    @Override
    public boolean isDone() {
        if(distance>=0) {
            return driveTrain.atDriveTargetPosition(true);
        } else {
            return driveTrain.atDriveTargetPosition(false);
        }
    }
}