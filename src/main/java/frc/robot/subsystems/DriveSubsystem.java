// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




public class DriveSubsystem extends SubsystemBase {

  private PWMSparkMax m_leftMotor = new PWMSparkMax(0);
  private PWMSparkMax m_rightMotor = new PWMSparkMax(1);

  public DriveSubsystem() {
    SmartDashboard.putData("Field", m_field);
  }

  public Drivetrain() {
    m_leftEncoder.setDistancePerPulse(2 * Math.PI * kWheelRadius / kEncoderResolution);
    m_rightEncoder.setDistancePerPulse(2 * Math.PI * kWheelRadius / kEncoderResolution);
    }

  public class moveRobot {
    public static void main (String[] args){
      m_left.set(0.5)
      m_right.set(0.5)
    }  

  }

  public class Robot {
    Spark m_left = new Spark(1);
    Spark m_right = new Spark(2);
    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
  
    public void robotInit() {
        m_left.setInverted(true); // if you want to invert motor outputs, you must do so here
    }
  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
          // Set the inputs to the system. Note that we need to convert
      // the [-1, 1] PWM signal to voltage by multiplying it by the
      // robot controller voltage.
    m_driveSim.setInputs(m_leftMotor.get() * RobotController.getInputVoltage(),
    m_rightMotor.get() * RobotController.getInputVoltage());

    // Advance the model by 20 ms. Note that if you are running this
    // subsystem in a separate thread or have changed the nominal timestep
    // of TimedRobot, this value needs to match it.
    m_driveSim.update(0.02);

    // Update all of our sensors.
    m_leftEncoderSim.setDistance(m_driveSim.getLeftPositionMeters());
    m_leftEncoderSim.setRate(m_driveSim.getLeftVelocityMetersPerSecond());
    m_rightEncoderSim.setDistance(m_driveSim.getRightPositionMeters());
    m_rightEncoderSim.setRate(m_driveSim.getRightVelocityMetersPerSecond());
    m_gyroSim.setAngle(-m_driveSim.getHeading().getDegrees());
    private Field2d m_field = new Field2d();
    m_odometry.update(m_gyro.getRotation2d(),
                    m_leftEncoder.getDistance(),
                    m_rightEncoder.getDistance());
    m_field.setRobotPose(m_odometry.getPoseMeters());
  }
}
