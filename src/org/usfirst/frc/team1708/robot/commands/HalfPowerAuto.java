package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HalfPowerAuto extends CommandGroup {
    
    public  HalfPowerAuto() {
       addSequential(new HalfAutoLPower());
    }
}
