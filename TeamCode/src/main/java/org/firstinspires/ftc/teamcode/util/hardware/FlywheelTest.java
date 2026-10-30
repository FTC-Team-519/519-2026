package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FlywheelTest {
    private static final double TICKS_PER_REVOLUTION = 28;
    private DcMotor flywheel;

    public FlywheelTest(HardwareMap hardwareMap) {
        flywheel = hardwareMap.dcMotor.get("flywheel");
    }

    public void setSpeed(double speed) {
        flywheel.setPower(speed);
    }

    public double getRevolutionPosition() {
        return flywheel.getCurrentPosition() / TICKS_PER_REVOLUTION;
    }
}
