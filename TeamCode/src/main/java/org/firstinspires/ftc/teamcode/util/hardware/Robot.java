package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.hardware.rev.*;
import com.qualcomm.robotcore.hardware.*;
import org.firstinspires.ftc.robotcore.external.navigation.*;

//KITBOTTT!!
public class Robot {
    private final DriveTrain driveTrain;
    private final IMU_Wrapper imu_wrapper;

    public Intake getIntake() {
        return intake;
    }

    private final Intake intake;
    private final Feeder feeder;

    public Outtake getOuttake() {
        return outtake;
    }

    private final Outtake outtake;

    public Robot(HardwareMap hardwareMap) {
        driveTrain = new DriveTrain(hardwareMap);
        imu_wrapper = new IMU_Wrapper(hardwareMap);
        intake = new Intake(hardwareMap);
        feeder = new Feeder(hardwareMap);
        outtake = new Outtake(hardwareMap);
    }


    public DriveTrain getDriveTrain() {
        return driveTrain;
    }

    public IMU_Wrapper getImu_wrapper() {
        return imu_wrapper;
    }

    public Feeder getFeeder() { return feeder; }
}
