package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.util.OpModeBase;

@TeleOp(name = "FlyWheelTest")
public class FlyWheelTest extends OpModeBase {
    private double power = 0.0;
    private double last_wheel_pos = 0.0;

    @Override
    public void loop() {
        if (gamepad1.dpadUpWasPressed()){
            power += 0.1;
        }
        if (gamepad1.dpadDownWasPressed()){
            power -= 0.1;
        }
        if (gamepad1.dpadLeftWasPressed()){
            power += 0.01;
        }
        if (gamepad1.dpadRightWasPressed()){
            power -= 0.01;
        }

        robot.getFlywheelTest().setSpeed(power);

        telemetry.addData("Power", power);
        telemetry.addData("Revolution per Minute", (robot.getFlywheelTest().getRevolutionPosition() - last_wheel_pos) * 60.0);
        telemetry.update();

        last_wheel_pos =  robot.getFlywheelTest().getRevolutionPosition();
    }
}
