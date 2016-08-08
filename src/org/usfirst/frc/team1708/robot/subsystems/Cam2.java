package org.usfirst.frc.team1708.robot.subsystems;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cam2 extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	static CameraServer cam;
		public Cam2(){
			cam = CameraServer.getInstance();
			cam.setQuality(30);
			cam.startAutomaticCapture("cam0");
			
		}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
      //  setDefaultCommand(new MySpecialCommand());
    }
}

