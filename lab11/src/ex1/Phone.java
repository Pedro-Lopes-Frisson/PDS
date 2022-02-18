package ex1;

public class Phone {
  private double price;
  private int memory;
  private String brand;
  private int camera;
  
  public Phone( double var1, int var3, String var4, int var5 ) {
    this.price = var1;
    this.memory = var3;
    this.brand = var4;
    this.camera = var5;
  }
  
  public int compare( Phone var1, Phone var2 ) {
    return (int) ( var1.price - var2.price );
  }
  
  public static int compareByPrice( Phone var0, Phone var1 ) {
    return (int) ( var0.price - var1.price );
  }
  
  public static int compareByMem( Phone var0, Phone var1 ) {
    return var0.memory - var1.memory;
  }
  
  public static int compareByBrand( Phone var0, Phone var1 ) {
    return var0.brand.compareTo( var1.brand );
  }
  
  public static int compareByCamera( Phone var0, Phone var1 ) {
    return var0.camera - var1.camera;
  }
}
