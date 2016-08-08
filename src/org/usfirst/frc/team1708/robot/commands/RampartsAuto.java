package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RampartsAuto extends CommandGroup {
    
    public  RampartsAuto() {
    	
    	addSequential(new CLawUpForward(2));
    	//addSequential(new StraightenBot());
    	//addSequential(new HalfPowerAuto());
    	
    }
}
