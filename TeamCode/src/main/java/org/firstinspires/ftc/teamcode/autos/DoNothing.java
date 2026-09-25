package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.util.AutoBase;
import org.firstinspires.ftc.teamcode.util.OpModeBase;
import org.firstinspires.ftc.teamcode.util.commands.command_groups.SequentialCommandGroup;

// Jonah was here
@Autonomous(name="Do Nothing")
public class DoNothing extends AutoBase {

    @Override
    public SequentialCommandGroup create_routine() {
        return new SequentialCommandGroup();
    }
}
