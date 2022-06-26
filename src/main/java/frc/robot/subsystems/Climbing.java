// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climbing extends SubsystemBase {
  TalonFX Tilt1;
  TalonFX Tilt2;
  TalonFX PullMotor;
  CANSparkMax ClawsMotor;
  public static Climbing climbing;

  public Climbing() {
    Tilt1 = new TalonFX(12);
    Tilt2 = new TalonFX(13);
    Tilt2.follow(Tilt1);
    PullMotor = new TalonFX(11);
    ClawsMotor = new CANSparkMax(14,MotorType.kBrushless);

  }
  public void ControlTilt(double power){
    Tilt1.set(ControlMode.PercentOutput, power);
  }
  public void ControlPull(double power){
    PullMotor.set(ControlMode.PercentOutput, power);
  }
  public void ControlCLaws(double power){
    ClawsMotor.set(power);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public static Climbing getinstance(){
    if (climbing == null){
      climbing = new Climbing();
    }
    return climbing;
  }
}
