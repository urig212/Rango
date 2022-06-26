// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubSystem extends SubsystemBase {
  private TalonFX IntakeMotor;
  public static IntakeSubSystem Intake;
  DoubleSolenoid doubleSolenoid;

  public IntakeSubSystem() {
    IntakeMotor = new TalonFX(6);
    doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 2, 3);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void IntakeMotorControl(double power)
  {
    IntakeMotor.set(ControlMode.PercentOutput, power); 
  }
  public void solenoidControl(Boolean bool)
  {
    if(bool == true){
      doubleSolenoid.set(Value.kForward);
    }
    else{
      doubleSolenoid.set(Value.kReverse);
    }
  }

  public static IntakeSubSystem getinstance(){
    if (Intake == null){
      Intake = new IntakeSubSystem();
    }
    return Intake;
  }
}
