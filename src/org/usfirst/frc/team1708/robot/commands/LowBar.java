package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBar extends CommandGroup {
    
    public  LowBar() {
    	addSequential(new ScrewYourself());
    	addSequential(new HalfForward());
    	addSequential(new MoveForward());
    	//addSequential(new TankTurnRights());
    }
}
