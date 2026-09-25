package org.firstinspires.ftc.teamcode.util.commands.actions;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.util.hardware.DriveTrain;
import org.firstinspires.ftc.teamcode.util.hardware.Robot;
import org.firstinspires.ftc.teamcode.util.RobotMath;
import org.firstinspires.ftc.teamcode.util.commands.Command;

//the distance that the motors report they have driven might not be the actual amount we have driven due to slippage
//I am not sure if this will drive exactly the prescribed amount so we will need to test it out
public class DriveInDirection implements Command {
    private final double distance;

    //from 0 to 2PI
    private final double direction;
    private final DriveTrain driveTrain;

    public DriveInDirection(double inches, double direction, Robot robot) {
        this.direction = RobotMath.trueMod(direction, (Math.PI * 2));
        this.driveTrain = robot.getDriveTrain();
        this.distance = inches * DriveTrain.getCountsPerInchForDriveMotors();
    }

    @Override
    public void init() {
        this.driveTrain.setDriveMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.driveTrain.setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.driveTrain.setDriveTargetPosition((int) distance); //we might need to tweak this value a bit
    }

    @Override
    public void run() {
        double y = Math.sin(direction);
        double x = Math.cos(direction);

        double lf_power = y + x;
        double rf_power = y - x;
        double lb_power = y - x;
        double rb_power = y + x;

        double scale = Math.abs(y) + Math.abs(x);

        lf_power /= scale;
        rf_power /= scale;
        lb_power /= scale;
        rb_power /= scale;

        driveTrain.setLeftFrontPower(lf_power);
        driveTrain.setRightFrontPower(rf_power);
        driveTrain.setLeftBackPower(lb_power);
        driveTrain.setRightBackPower(rb_power);
    }

    @Override
    public boolean isDone() {
        return Math.abs(driveTrain.getLeftFrontDrive().getCurrentPosition()) >= Math.abs(driveTrain.getLeftFrontDrive().getTargetPosition()) ||
                Math.abs(driveTrain.getRightFrontDrive().getCurrentPosition()) >= Math.abs(driveTrain.getRightFrontDrive().getTargetPosition()) ||
                Math.abs(driveTrain.getLeftBackDrive().getCurrentPosition()) >= Math.abs(driveTrain.getLeftBackDrive().getTargetPosition()) ||
                Math.abs(driveTrain.getRightBackDrive().getCurrentPosition()) >= Math.abs(driveTrain.getRightBackDrive().getTargetPosition());
    }

    @Override
    public void shutdown() {
        this.driveTrain.setAllDrivePower(0.0);
        this.driveTrain.setDriveMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.driveTrain.setDriveMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public final static double FORWARDS = (Math.PI / 2.0);
    public final static double BACKWARDS = (Math.PI * 3.0 / 2.0);
    public final static double LEFT = (0.0);
    public final static double RIGHT = (Math.PI);

}
