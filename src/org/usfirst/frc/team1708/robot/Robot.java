
package org.usfirst.frc.team1708.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team1708.robot.commands.CDFAuto;
import org.usfirst.frc.team1708.robot.commands.HalfAutoLPower;
import org.usfirst.frc.team1708.robot.commands.HalfPowerAuto;
import org.usfirst.frc.team1708.robot.commands.LowBar;
import org.usfirst.frc.team1708.robot.commands.MoatAutoPositioning;
import org.usfirst.frc.team1708.robot.commands.MoatAutonomous;
import org.usfirst.frc.team1708.robot.commands.NoAutonomous;
import org.usfirst.frc.team1708.robot.commands.OverTheMoon;
import org.usfirst.frc.team1708.robot.commands.RampartsAuto;
import org.usfirst.frc.team1708.robot.commands.RoughTerrainAutonomous;
import org.usfirst.frc.team1708.robot.subsystems.Cam2;
import org.usfirst.frc.team1708.robot.subsystems.CompressorSub;
import org.usfirst.frc.team1708.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1708.robot.subsystems.Low_Arm;
import org.usfirst.frc.team1708.robot.subsystems.Technicals;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
@SuppressWarnings("unused")
public class Robot extends IterativeRobot {
	public static OI oi; 
	SendableChooser chooser;
    public static DriveTrain drive;
    public static Technicals tech;
    public static Low_Arm ram;
  //  public static NetworkTable nettable;
    public static CompressorSub compress;
    public static Cam2 cam;
    Command command;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	oi = new OI();	
		drive = new DriveTrain();
        tech = new Technicals();
        ram = new Low_Arm();
        cam = new Cam2();       
        chooser = new SendableChooser();
        chooser.addObject("Drive Up to Defense", new HalfPowerAuto());
        chooser.addObject("Moat Autonomous", new MoatAutonomous());
        chooser.addObject("Rough Terrain Autonomous", new RoughTerrainAutonomous());
        chooser.addObject("No Autonomous", new NoAutonomous());
        chooser.addObject("Cheval De Fris Auto", new CDFAuto());
        chooser.addObject("RampartsAutoShoot", new RampartsAuto());
        chooser.addObject("LowBar", new LowBar());
        //chooser.addObject("Over & Back", new OverTheMoon());
        SmartDashboard.putData("Auto mode", chooser);
       /* nettable = NetworkTable.getTable("GRIP/Zohaib'sContoursReport");
      double[] defaultValue = new double[0];
   	 while(true){
   	  double[] areas =  nettable.getNumberArray("area", defaultValue);
   	  System.out.println("areas: ");
   	 for(double area : areas){
   		 System.out.println(area + " ");
   	 }
   	 System.out.println();
   	 Timer.delay(1);
   	 
   	 }
     */
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
   OI.resetGyro();
   OI.showPressure();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	//	OI.returnEncoder().reset();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparison s to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
      command = (Command) chooser.getSelected();
      OI.resetGyro();
      //command2 = (Command) chooser2.getSelected();
      command.start(); //<--------------------------------------Toggle Autonomous on or off
      
        //Camera.camerainit();
      	
       /*String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
      //  if (command!= null) command.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	OI.returnArm().set(false);
        if (command != null) command.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
