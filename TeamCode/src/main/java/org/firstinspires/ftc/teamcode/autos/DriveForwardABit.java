package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.util.AutoBase;
import org.firstinspires.ftc.teamcode.util.commands.actions.DriveForward;
import org.firstinspires.ftc.teamcode.util.commands.command_groups.SequentialCommandGroup;

// Jonah was not here
@Autonomous(name="Drive Forward 1 foot")
public class DriveForwardABit extends AutoBase {

    @Override
    public SequentialCommandGroup create_routine() {
        return new SequentialCommandGroup(
                telemetry,
                new DriveForward(12, 1.0, this.robot, telemetry)
        );
    }
}
