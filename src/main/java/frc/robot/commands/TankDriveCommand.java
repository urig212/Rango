// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Chasis;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TankDriveCommand extends CommandBase {

  private Chasis DriveBase;

  public TankDriveCommand(Chasis DB) {
    DriveBase = DB;
    addRequirements(DriveBase);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  @Override
  public void execute() {
    DriveBase.RightControl(RobotContainer.RighJoystick.getY());
    DriveBase.LeftControl(RobotContainer.LeftJoystick.getY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveBase.RightControl(0);
    DriveBase.LeftControl(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
