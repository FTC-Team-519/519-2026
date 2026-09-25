package org.firstinspires.ftc.teamcode.util;

import org.firstinspires.ftc.teamcode.util.commands.command_groups.SequentialCommandGroup;

public abstract class AutoBase extends OpModeBase {

    private SequentialCommandGroup seq;


    public abstract SequentialCommandGroup create_routine();

    @Override
    public void init(){
        super.init();

        this.seq = create_routine();
    }

    @Override
    public void loop() {
        if (!seq.isDone()){
            seq.run();
        }
    }
}
