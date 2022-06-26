// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TankDriveCommand;
import frc.robot.subsystems.Chasis;
import frc.robot.subsystems.Climbing;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.IntakeSubSystem;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Chasis m_exampleSubsystem = new Chasis();
  public static XboxController OperatingJoystick = new XboxController(2);
  public static Joystick LeftJoystick = new Joystick(0);
  public static Joystick RighJoystick = new Joystick(1);
  private final TankDriveCommand m_autoCommand = new TankDriveCommand(m_exampleSubsystem);


  private JoystickButton AButton = new JoystickButton(OperatingJoystick, 1);
  private JoystickButton BButton = new JoystickButton(OperatingJoystick, 2);
  private JoystickButton XButton = new JoystickButton(OperatingJoystick, 4);
  private JoystickButton RightTrigger = new JoystickButton(OperatingJoystick, 5);
  private JoystickButton LeftTrigger = new JoystickButton(OperatingJoystick, 6);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    AButton.whileHeld(() -> IntakeSubSystem.Intake.IntakeMotorControl(0.8)).whenReleased(() -> IntakeSubSystem.Intake.IntakeMotorControl(0.8));
    XButton.whileHeld(() ->Conveyor.conveyor.RunAll(0.5)).whenReleased(() -> Conveyor.conveyor.RunAll(0));
    BButton.whileHeld(() ->Shooter.shooter.PowerControl(0.6)).whenReleased(() -> Shooter.shooter.PowerControl(0));
    RightTrigger.whileHeld(() ->Climbing.climbing.ControlCLaws(0.4)).whenReleased(() -> Climbing.climbing.ControlCLaws(0));
    LeftTrigger.whileHeld(() ->Climbing.climbing.ControlCLaws(-0.4)).whenReleased(() -> Climbing.climbing.ControlCLaws(0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
