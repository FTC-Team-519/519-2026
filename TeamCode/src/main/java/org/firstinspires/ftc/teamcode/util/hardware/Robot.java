package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.hardware.rev.*;
import com.qualcomm.robotcore.hardware.*;
import org.firstinspires.ftc.robotcore.external.navigation.*;

public class Robot {
    private final DriveTrain driveTrain;
    private final IMU_Wrapper imu_wrapper;

    public Robot(HardwareMap hardwareMap) {
        driveTrain = new DriveTrain(hardwareMap);
        imu_wrapper = new IMU_Wrapper(hardwareMap);
    }


    public DriveTrain getDriveTrain() {
        return driveTrain;
    }

    public IMU_Wrapper getImu_wrapper() {
        return imu_wrapper;
    }
}
