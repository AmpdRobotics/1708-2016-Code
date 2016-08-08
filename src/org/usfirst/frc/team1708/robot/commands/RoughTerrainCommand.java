package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * For the Rough Terrain Autonomous mode
 */
public class RoughTerrainCommand extends Command {

    public RoughTerrainCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        setTimeout(3);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriveTrain.TankRoughForward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	DriveTrain.stopFunctions();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	DriveTrain.stopFunctions();
    }
}
