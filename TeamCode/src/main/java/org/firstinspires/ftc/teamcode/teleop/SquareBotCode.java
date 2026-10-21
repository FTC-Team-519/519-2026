package org.firstinspires.ftc.teamcode.teleop;

// Imports
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.*;

@TeleOp(name="SquareBotCode", group="SquareBot")
public class SquareBotCode extends LinearOpMode {

    // Establishing variable for amount of time passed since initial run
    private ElapsedTime runtime = new ElapsedTime();
    // Creating the name for motor 1
    private DcMotor leftMotor = null;
    // Creating the name for motor 2
    private DcMotor rightMotor = null;

    // Main body for running opMode / code
    public void runOpMode() {

        // Establishing motors' names
        leftMotor = hardwareMap.get(DcMotor.class,"leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        // Establishing directions attached to each motor
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);

        // Robot stays inactive till program is initiated to start
        waitForStart();
        runtime.reset();

        // Robot will take input for as long as opMode is active
        while (opModeIsActive()) {

            // Setting up variables to store input data
            double leftPower;
            double rightPower;

            /* Changing the direction and drive of the Robot based the
            the input (drive = -y due to inverse inputs */
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;

            // Ensuring the power/inputs go neither over 1 and under -1
            leftPower = Range.clip(drive + turn, -1, 1);
            rightPower = Range.clip(drive - turn, -1, 1);

            // Establishes the new inputs to the motors
            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);
        }
    }
}
