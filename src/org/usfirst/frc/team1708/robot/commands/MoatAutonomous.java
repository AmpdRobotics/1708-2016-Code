package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
 //requires (Robot.command2)
/**
 *
 */
public class MoatAutonomous extends CommandGroup {

    public  MoatAutonomous() {
    	
    	addSequential(new CLawUpForward(.5));
    	addSequential(new FastDrive(1.5));
    }
}
