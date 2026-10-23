package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(
        name = "driveteleOp"
)
public class SquarebotDrive extends OpMode {
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void init() {

        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void loop() {

        if (gamepad1.x) {
            leftMotor.setPower(1.0);
            rightMotor.setPower(1.0);
        } else if(gamepad1.b) {
            leftMotor.setPower(-1.0);
            rightMotor.setPower(-1.0);
        }else{
            leftMotor.setPower(0.0);
            rightMotor.setPower(0.0);
        }
    }
}
