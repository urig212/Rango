// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Chasis extends SubsystemBase {
  private TalonFX LeftFront;
  private TalonFX LeftBack;
  private TalonFX RightFront;
  private TalonFX RightBack;
  private static Chasis chassis;

  /** Creates a new ExampleSubsystem. */
  public Chasis() {
    LeftFront = new TalonFX(1);
    LeftBack = new TalonFX(2);
    RightFront = new TalonFX(3);
    RightBack = new TalonFX(4);
    LeftBack.follow(LeftFront);
    RightBack.follow(RightFront);
  }
  public static Chasis getinstance(){
    if (chassis == null){
      chassis = new Chasis();
    }
    return chassis;
  }

  public void RightControl(double power)
  {
    RightFront.set(ControlMode.PercentOutput, power); 
  }
  public void LeftControl(double power)
  {
    LeftFront.set(ControlMode.PercentOutput, power); 
  }

  @Override
  public void periodic() {

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
