package ex1;

import java.util.Comparator;
import java.util.stream.IntStream;

public class SortingRoutine {
  private Comparator[] phones;
  private Comparator<Phone> comparer;
  
  protected SortingRoutine( Comparator[] var1, Comparator<Phone> var2 ) {
    this.phones = var1;
    this.comparer = var2;
  }
  // Codigo decompilado dos ficheiros class que tinha
  
  public static void main( String[] var0 ) {
    Phone[] var1 = new Phone[12];
    IntStream.range( 0, 12 ).forEach( ( var1x ) -> {
      var1[var1x] =
        new Phone( 25.234D * (double) var1x + 100.0D, var1x * 4 + var1x + 1, "Some Brand" + var1x, var1x * 12 + 12 );
    } );
    new InsertionSort( (Comparator[]) var1, Phone::compareByBrand );
  }
}
