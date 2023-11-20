// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final DriveSubsystem m_drivetrain = new DriveSubsystem(0);
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);


  public RobotContainer() {
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via  named factories in the {@link
   * CommandXboxController Xbox} class.
   */
  private void configureBindings() {
    m_driverController.x().onTrue(m_Drivesubsystem.moverobot());
    m_driverController.y().onTrue(m_Drivesubsystem.moverobot());
    //YOUR BINDINGS HERE

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_drivetrain.exampleMethodCommand());
  }

}
