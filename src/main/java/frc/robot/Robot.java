// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.simulation.AnalogGyroSim;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveSubsystem.moveRobot;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private RobotContainer m_robotContainer;
  // These represent our regular encoder objects, which we would
  // create to use on a real robot.
  private Encoder m_leftEncoder = new Encoder(0, 1);
  private Encoder m_rightEncoder = new Encoder(2, 3);

  // These are our EncoderSim objects, which we will only use in
  // simulation. However, you do not need to comment out these
  // declarations when you are deploying code to the roboRIO.
  private EncoderSim m_leftEncoderSim = new EncoderSim(m_leftEncoder);
  private EncoderSim m_rightEncoderSim = new EncoderSim(m_rightEncoder);

  // Create our gyro object like we would on a real robot.
  private AnalogGyro m_gyro = new AnalogGyro(1);

  // Create the simulated gyro object, used for setting the gyro
  // angle. Like EncoderSim, this does not need to be commented out
  // when deploying code to the roboRIO.
  private AnalogGyroSim m_gyroSim = new AnalogGyroSim(m_gyro);
 

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    m_motorRight.setInverted(true);
    exampleJaguar.setSafetyEnabled(true);
    exampleJaguar.setSafetyEnabled(true);
    exampleJaguar.setSafetyEnabled(false);
    exampleJaguar.setExpiration(.1);
    exampleJaguar.feed()
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {
  
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {


      // Tank drive with a given left and right rates
      myDrive.tankDrive(-leftStick.getY(), -rightStick.getY());
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
