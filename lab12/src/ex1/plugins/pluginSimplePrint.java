package ex1.plugins;

import ex1.IPlugin;

public class pluginSimplePrint implements IPlugin {
  public pluginSimplePrint(){}
  
  @Override public void fazQualQuerCoisa() {
    System.out.println("Print qql coisa");
  
  }
}
