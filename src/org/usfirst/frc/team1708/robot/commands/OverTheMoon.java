package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * this class helps to position the robot and drive it 
 * over the 2016 defenses. Make the Boulder go into
 * the lower center goal.It then turns around to 
 * either cross the same defense or position
 * and then go over a different defense.
 * 
 * Author: Ryan Jacobs, Zohaib Wasim
 */
public class OverTheMoon extends CommandGroup {
    
    public  OverTheMoon() {
    		addSequential(new HalfForward());//This is just moat(still untweeked)
    		addSequential(new MoveForward());
    		//addSequential(new GyroTank()); //add the Command for the Drive with the Gyroscope.
    		
    		addSequential(new StraightenBot());// straighten the robot so it faces 0. Drive to lower goals.
    		addSequential(new MoveForward());
    		//addSequential(new GyroTank()); //add the Command for the Drive with the Gyroscope.
    		//addSequential(new ReverseBack()) // add this command and the method in the DriveTrain subsystem
    		addSequential(new RyanCahoon());
    		addSequential(new HalfForward());
    		addSequential(new MoveForward());
    		//addSequential(new GyroTank()); //add the Command for the Drive with the Gyroscope.
    		addSequential(new StraightenBot());
    }
}
