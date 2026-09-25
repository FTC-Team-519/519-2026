package org.firstinspires.ftc.teamcode.util.commands.actions;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.util.hardware.DriveTrain;
import org.firstinspires.ftc.teamcode.util.hardware.Robot;
import org.firstinspires.ftc.teamcode.util.commands.Command;

public class DriveSideways implements Command {
    private final double distance;
    private final DriveTrain driveTrain;

    //drive left is Negative <- mathew said this after he was wrong the first time
    public DriveSideways(double inches, Robot robot) {
        distance = inches*DriveTrain.getCountsPerInchForDriveMotors();

        // init robot
        this.driveTrain = robot.getDriveTrain();
    }

    public void init() {
        this.driveTrain.setDriveMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.driveTrain.setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.driveTrain.setDriveTargetPosition((int)distance);
    }

    public void run() {
        if(distance>0) {
            this.driveTrain.setStrafeRightPower(1.0);
        }
        else if(distance<0) {
            this.driveTrain.setStrafeLeftPower(1.0);
        }
    }

    public void shutdown() {
        this.driveTrain.setAllDrivePower(0.0d);
        this.driveTrain.setDriveMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.driveTrain.setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public boolean isDone() {
        if(this.driveTrain.getLeftFrontDrive().getTargetPosition()>0) {
            return this.driveTrain.getLeftFrontDrive().getCurrentPosition() >= this.driveTrain.getLeftFrontDrive().getTargetPosition();
        }
        else {
            return this.driveTrain.getLeftFrontDrive().getCurrentPosition() <= this.driveTrain.getLeftFrontDrive().getTargetPosition();
        }
    }
}