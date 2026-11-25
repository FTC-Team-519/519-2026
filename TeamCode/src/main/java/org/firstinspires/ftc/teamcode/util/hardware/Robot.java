package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.hardware.rev.*;
import com.qualcomm.robotcore.hardware.*;
import org.firstinspires.ftc.robotcore.external.navigation.*;

//KITBOTTT!!
public class Robot {
    private final DriveTrain driveTrain;
    private final IMU_Wrapper imu_wrapper;
    private final Outtake outtake;
    private final Intake intake;

    public Robot(HardwareMap hardwareMap) {
        imu_wrapper = new IMU_Wrapper(hardwareMap);
        driveTrain = new DriveTrain(hardwareMap, imu_wrapper);
        outtake = new Outtake(hardwareMap);
        intake = new Intake(hardwareMap);
    }


    public DriveTrain getDriveTrain() {
        return driveTrain;
    }

    public IMU_Wrapper getImu_wrapper() {
        return imu_wrapper;
    }

    public Outtake getOuttake() {
        return outtake;
    }

    public Intake getIntake() {
        return intake;
    }
}
