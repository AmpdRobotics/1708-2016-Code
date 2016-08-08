package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.OI;
import org.usfirst.frc.team1708.robot.commands.TechnicalsCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
@SuppressWarnings("unused")
public class Technicals extends Subsystem {
    
   

    public void initDefaultCommand() {
       setDefaultCommand(new TechnicalsCommand());
    }
    
    public static void MainCode(){
    	OI.intake();
    	//OI.Launch();
    	OI.pubGyro();
    	//OI.Pancakes();
    	OI.CustomCompressor();
    	
    }
}


