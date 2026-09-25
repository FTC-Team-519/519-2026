package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.util.OpModeBase;
import org.firstinspires.ftc.teamcode.util.hardware.DriveTrain;

@TeleOp(name = "Basic Driving Teleop")
public class DriveTeleOp extends OpModeBase {
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
        robot.getDriveTrain().drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}
