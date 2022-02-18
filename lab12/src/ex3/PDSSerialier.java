package ex3;

public class PDSSerializer {
  public static String fromObject( Object o ) {
		Class cl = o.getClass();
		//Explore os metodos
		cl.getMethods();
		cl.getFields();
		//Veja o javadoc das classes: Class, Method, Field, Modifier
  }
  
  public static void main( String[] args ) {
    Ship s = new Ship( "BelaRia", 200 );
    s.setOwner( new Owner( "Manuel" ) );
    s.setPassageiros( new String[]{“Manuel”, “Amilcar”});
    System.out.println( PDSSerializer.fromObject( s ) );
  }
  
}