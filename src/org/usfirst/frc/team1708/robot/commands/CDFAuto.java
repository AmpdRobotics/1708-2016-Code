package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CDFAuto extends CommandGroup {
    
    public  CDFAuto() {
        addSequential(new CLawUpForward(0.70));
        addSequential(new DeadCode());
        addSequential(new Smidge());
        addSequential(new ScrewYourself());
        addSequential(new CLawUpForward(2));
        //addParallel(new DelayedDrive());
    }
}
