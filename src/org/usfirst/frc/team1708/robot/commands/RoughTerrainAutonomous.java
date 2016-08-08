package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RoughTerrainAutonomous extends CommandGroup {
    
    public  RoughTerrainAutonomous() {
     
    	addSequential(new CLawUpForward(1));
    	addSequential(new FastDrive(1));
    }
}
