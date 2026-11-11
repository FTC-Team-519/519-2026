package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.util.OpModeBase;

@TeleOp(name = "Basic Teleop")
public class BasicTeleOp extends OpModeBase {

    public static final double TRIGGER_THRESHOLD = 0.1;
    public static final double NO_POWER = 0.0;
    public static final double LOW_POWER = 0.3;
    public static final double MID_POWER = 0.5;
    public static final double HIGH_POWER = 0.7;
    private double outtake_power = 0;

    @Override
    public void loop() {
        handle_driving();
        handle_intake();
        handle_outtake();
        handle_feeder();
        handle_telemetry();
    }

    private void handle_telemetry() {
        telemetry.addData("Outtake Power", outtake_power);
        telemetry.update();
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
        if (gamepad2.left_trigger > TRIGGER_THRESHOLD) {
            robot.getIntake().turnOn();
        } else {
            robot.getIntake().turnOff();
        }
    }

    void handle_outtake() {
        // power tuner
        if (gamepad2.dpadUpWasPressed()) {
            outtake_power += 0.1;
        }
        if (gamepad2.dpadDownWasPressed()) {
            outtake_power -= 0.1;
        }
        if (gamepad2.dpadRightWasPressed()) {
            outtake_power += 0.01;
        }
        if (gamepad2.dpadLeftWasPressed()) {
            outtake_power -= 0.01;
        }

        // power shortcuts
        if (gamepad2.aWasPressed()) {
            outtake_power = NO_POWER;
        }
        if (gamepad2.xWasPressed()) {
            outtake_power = LOW_POWER;
        }
        if (gamepad2.yWasPressed()) {
            outtake_power = MID_POWER;
        }
        if (gamepad2.bWasPressed()) {
            outtake_power = HIGH_POWER;
        }

        //clamp between 0 and 1
        outtake_power = Math.min(outtake_power, 1);
        outtake_power = Math.max(outtake_power, 0);

        this.robot.getOuttake().setPower(outtake_power);
    }

    void handle_feeder() {
        if (gamepad2.right_trigger > TRIGGER_THRESHOLD) {
            robot.getFeeder().turnOn();
        } else {
            robot.getFeeder().turnOff();
        }

    }
}
