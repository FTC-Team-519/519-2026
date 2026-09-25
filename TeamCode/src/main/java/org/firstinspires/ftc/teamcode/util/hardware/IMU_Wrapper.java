package org.firstinspires.ftc.teamcode.util.hardware;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class IMU_Wrapper {
    private final IMU imu;

    public IMU_Wrapper(HardwareMap hardwareMap) {
        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.DOWN, RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD)));
    }
    
    public YawPitchRollAngles getOrientation(){
        assert imu != null;
        return imu.getRobotYawPitchRollAngles();
    }

    public double getYaw(){
        return getOrientation().getYaw();
    }

    public void resetYaw(){
        imu.resetYaw();
    }
}
