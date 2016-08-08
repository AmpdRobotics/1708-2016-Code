package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1708.robot.subsystems.Technicals;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TechnicalsCommand extends Command {

    public TechnicalsCommand() {
        requires(Robot.tech);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Technicals.MainCode();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
