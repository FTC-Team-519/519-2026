package org.firstinspires.ftc.teamcode.util.commands.actions;

import org.firstinspires.ftc.teamcode.util.commands.Command;
import org.firstinspires.ftc.teamcode.util.hardware.Intake;
import org.firstinspires.ftc.teamcode.util.hardware.Robot;

public class IntakeCommand implements Command {
    private final Intake intake;
    private final boolean is_active;

    public IntakeCommand(boolean is_intaking, Robot robot) {
        this.intake = robot.getIntake();
        this.is_active = is_intaking;
    }


    @Override
    public void init() {
        if (is_active) {
            intake.turnOn();
        } else {
            intake.turnOff();
        }
    }

    @Override
    public void run() {
    }

    @Override
    public boolean isDone() {
        return true;
    }

    @Override
    public void shutdown() {
    }
}
