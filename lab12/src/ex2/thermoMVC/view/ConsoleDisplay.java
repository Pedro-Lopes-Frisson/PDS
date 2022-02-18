package ex2.thermoMVC.view;

import ex2.thermoMVC.model.Thermometer;
import ex2.thermoMVC.model.ThermometerListener;

import javax.swing.*;
import java.awt.*;

public class ConsoleDisplay extends JPanel implements ThermometerListener {
  private static final char DEGREE_SYMBOL = '\u00B0';
  protected Thermometer thermometer;
  
  /**
   * Creates a digital thermometer
   *
   * @param t the thermometer whose temperature is displayed
   */
  public ConsoleDisplay( Thermometer t ) {
    thermometer = t;
  }
  
  /**
   * Create the string to display in the thermometer
   *
   * @return the string to display in the thermometer
   */
  private String getDisplayString() {
    return "" + thermometer.getTemperature() + DEGREE_SYMBOL + "F";
  }
  
  /**
   * Change the temperature displayed
   */
  @Override
  public void temperatureChanged() {
    System.out.println( getDisplayString() );
  }
}
