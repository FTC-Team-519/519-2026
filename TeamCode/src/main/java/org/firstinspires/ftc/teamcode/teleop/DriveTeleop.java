package org.firstinspires.ftc.teamcode.teleop;

import org.firstinspires.ftc.teamcode.util.OpModeBase;
import org.firstinspires.ftc.teamcode.util.hardware.DriveTrain;

public class DriveTeleop extends OpModeBase {
    @Override
    public void loop() {
        handle_driving();
    }

    /*
    Driving is done by gamepad1
    The robot moves in the direction of the left stick
    The robot turns in place with the right stick
     */
    void handle_driving(){
        //On the sticks, the y-axis is flipped so down is up and up is down.
        //To fix this, we just put a negative to flip it back to what is normal.
        raw_driving(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
    }

    //This decouples the gamepad input code from the driving code, in case we want different modes of driving
    void raw_driving(double x, double y, double rot){
        double lf_power = y + x + rot;
        double rf_power = y - x - rot;
        double lb_power = y - x + rot;
        double rb_power = y + x - rot;

        double max = 0.0;
        max = Math.max(Math.abs(lf_power), Math.abs(rf_power));
        max = Math.max(max, Math.abs(lb_power));
        max = Math.max(max, Math.abs(rb_power));

        if (max > 1.0) {
            lf_power /= max;
            rf_power /= max;
            lb_power /= max;
            rb_power /= max;
        }

        DriveTrain driveTrain = robot.getDriveTrain();

        driveTrain.setLeftFrontPower(lf_power);
        driveTrain.setRightFrontPower(rf_power);
        driveTrain.setLeftBackPower(lb_power);
        driveTrain.setRightBackPower(rb_power);
    }
}
