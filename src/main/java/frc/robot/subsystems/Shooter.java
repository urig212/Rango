// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  CANSparkMax Motor1;
  CANSparkMax Motor2;
  DoubleSolenoid doubleSolenoid;
  public static Shooter shooter;
  
  public Shooter() {
    Motor1 = new CANSparkMax(8,MotorType.kBrushless);
    Motor2 = new CANSparkMax(9,MotorType.kBrushless);
    Motor2.follow(Motor1);
    doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 7, 8);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
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
  public void PowerControl(double power){
    Motor1.set(power);
  }
  public static Shooter getinstance(){
    if (shooter == null){
      shooter = new Shooter();
    }
    return shooter;
  }

}
