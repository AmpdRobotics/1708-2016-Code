package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.OI;
import org.usfirst.frc.team1708.robot.commands.RAM;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Low_Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new RAM());
    }
    public static void UseRam(){
    	OI.RamUsed();
    }
}

