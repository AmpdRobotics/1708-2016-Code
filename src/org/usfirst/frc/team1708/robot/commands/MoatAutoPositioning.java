package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoatAutoPositioning extends CommandGroup {
    
    public  MoatAutoPositioning() {
    	//classic moat autonomous
    	addSequential(new HalfForward());
    	addSequential(new MoveForward());
    	
    	
    	//new Addition for positioning
    	addSequential(new StraightenBot());
    	addSequential(new TankTurnRights());
    	addSequential(new HalfForward());
    	addSequential(new TankTurnLefts());
    }
}
