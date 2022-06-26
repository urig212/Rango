// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyor extends SubsystemBase {
  private TalonFX TopConveyor;
  private WPI_TalonSRX BottomConveyor;
  private DigitalInput Ir1;
  private DigitalInput Ir2;
  public static Conveyor conveyor;

  public Conveyor() {
    TopConveyor = new TalonFX(8);
    BottomConveyor = new WPI_TalonSRX(7);
    Ir1 = new DigitalInput(0);
    Ir2 = new DigitalInput(2);
  }
  public void controlTop(double power){
    TopConveyor.set(ControlMode.PercentOutput, power);
  }
  public void controlBottom(double power){
    BottomConveyor.set(ControlMode.PercentOutput, power);
  }
  public void PrintFirstSensorValue(){
    SmartDashboard.putBoolean("Sensor 1", Ir1.get());
  }
  public void PrintSecondSensorValue(){
    SmartDashboard.putBoolean("Sensor 2", Ir2.get());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public static Conveyor getinstance(){
    if (conveyor == null){
      conveyor = new Conveyor();
    }
    return conveyor;
  }
  public void RunAll(double power)
  {
    conveyor.controlTop(power);
    conveyor.controlBottom(power);
  }
}
