package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.util.OpModeBase;

@TeleOp(name = "FlyWheelTest")
public class FlyWheelTest extends OpModeBase {
    private double power = 0.0;
    private double last_wheel_pos = 0.0;
    private boolean shooterEnabled = false;
    private boolean intakeEnabled = false;
    public static final double INTAKE_SPEED = 0.66;

    @Override
    public void init() {
        super.init();
        power = 0.0;
        last_wheel_pos = robot.getOuttake().getRevolutionPosition();
        shooterEnabled = false;
        intakeEnabled = false;
    }

    @Override
    public void loop() {
        if (gamepad1.dpadUpWasPressed()) {
            power += 0.1;
        }
        if (gamepad1.dpadDownWasPressed()) {
            power -= 0.1;
        }
        if (gamepad1.dpadLeftWasPressed()) {
            power -= 0.01;
        }
        if (gamepad1.dpadRightWasPressed()) {
            power += 0.01;
        }

        if (shooterEnabled) {
            robot.getOuttake().set_power(power);
        } else {
            robot.getOuttake().set_power(0);
        }
        if (gamepad1.aWasReleased()) {
            shooterEnabled = !shooterEnabled;
        }

        if (intakeEnabled) {
            robot.getIntake().setPower(INTAKE_SPEED);
        } else {
            robot.getIntake().setPower(0);
        }
        if (gamepad1.bWasPressed()) {
            intakeEnabled = !intakeEnabled;
        }

        telemetry.addData("Power", power);
        telemetry.addData("Revolution per Minute", (robot.getOuttake().getRevolutionPosition() - last_wheel_pos) * 60.0);
        telemetry.update();

        last_wheel_pos =  robot.getOuttake().getRevolutionPosition();
    }
}