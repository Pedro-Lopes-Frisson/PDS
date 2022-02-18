package ex1.plugins;

import ex1.IPlugin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.util.concurrent.TimeUnit;

public class pluginDoAFlip implements IPlugin {
  public pluginDoAFlip(){}
  
  
  public class Reta extends JFrame {
    private double tamanho;
    private double angulo;
    private double centroX;
    private double centroY;
    private double endX;
    private double endY;
    JPanel panel;
    
    public Reta( double tamanho, double angulo, double centroX, double centroY, String s ) {
      super( s );
      this.tamanho = tamanho;
      this.angulo = ( angulo * 2 * Math.PI ) / 360;
      this.centroX = centroX;
      this.centroY = centroY;
      this.endX = this.centroX + this.tamanho * Math.cos( this.angulo );
      this.endY = this.centroY + this.tamanho * Math.sin( this.angulo );
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.panel = new JPanel();
      Border border = BorderFactory.createTitledBorder( s );
      panel.setBorder( border );
      getContentPane().add( panel );
      setSize( 450, 450 );
      //JButton button = new JButton( "press" );
      //panel.add( button );
      
    }
    
    public void paint( Graphics g ) {
      super.paint( g );  // fixes the immediate problem.
      Graphics2D g2 = (Graphics2D) g;
      Line2D lin = new Line2D.Double( this.centroX, this.centroY, this.endX, this.endY );
      g2.draw( lin );
      
      try {
        TimeUnit.SECONDS.sleep( 1 );
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
      g2.clearRect( 0, 0, 450, 450 );
      
      for (int i = 0 ; i < 6 ; i++) {
        g2.draw( new Line2D.Double( this.centroX, this.centroY,
          this.centroX + this.tamanho * Math.cos( this.angulo + ( i * 12 * Math.PI ) / 360 ),
          this.centroY + this.tamanho * Math.sin( this.angulo + ( i * 12 * Math.PI ) / 360 ) ) );
        try {
          TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        g2.clearRect( 0, 0, 450, 450 );
      }
      dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    @Override public String toString() {
      return "Reta{" +
        "tamanho=" + tamanho +
        ", angulo=" + angulo +
        ", centroX=" + centroX +
        ", centroY=" + centroY +
        ", endX=" + endX +
        ", endY=" + endY +
        '}';
    }
    
    
  }
  
  @Override public void fazQualQuerCoisa() {
    Reta r = new Reta( 100, - 90, 100, 100, "60 graus" );
    r.setVisible( true );
  }
}
