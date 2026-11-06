package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.util.OpModeBase;

@TeleOp(name = "Basic Teleop")
public class BasicTeleOp extends OpModeBase {
    @Override
    public void loop() {
        handle_driving();
        handle_intake();
        handle_outtake();
        handle_feeder();
    }

    /*
    Driving is done by gamepad1
    The robot moves in the direction of the left stick
    The robot turns in place with the right stick
     */
    void handle_driving() {
        //On the sticks, the y-axis is flipped so down is up and up is down.
        //To fix this, we just put a negative to flip it back to what is normal.
        robot.getDriveTrain().drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
    }

    void handle_intake() {
        if (gamepad1.a) {
            robot.getIntake().turnOn();
        } else {
            robot.getIntake().turnOff();
        }
    }

    void handle_outtake() {
        if (gamepad1.y) {
            robot.getOuttake().turnON();
        } else {
            robot.getOuttake().turnOff();
        }

    }

    void handle_feeder() {
        if (gamepad1.b) {
            robot.getFeeder().turnOn();
        } else {
            robot.getFeeder().turnOff();
        }

    }
}
