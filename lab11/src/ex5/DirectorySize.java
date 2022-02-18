package ex5;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class DirectorySize {
  
  public AtomicLong getSize( String pathsArray, boolean isRecursive ) {
    Path dir;
    
    try {
      dir = Paths.get( pathsArray );
      AtomicLong size = new AtomicLong( 0 );
      
      Files.walkFileTree( dir, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) {
          String[] pathsArray = ( file + "" ).split( "/" );
          String[] dirsArray = ( dir + "" ).split( "/" );
          String dirName = pathsArray[pathsArray.length - 2];
          
          String fileName = pathsArray[pathsArray.length - 1];
          
          if ( ! dirName.equals( dirsArray[dirsArray.length - 1] ) ) {
            if ( isRecursive ) { fileName = dirName + "/" + fileName; }
            else { return FileVisitResult.CONTINUE; }
          }
          
          long fileSize = attrs.size();
          System.out.println( "    " + fileName + "-" + fileSize + "b" );
          size.addAndGet( attrs.size() / 1024 );
          return FileVisitResult.CONTINUE;
        }
      } );
      
      return size;
      
    } catch (Exception e) {
      System.out.println( "Erro!" );
      System.exit( 1 );
    }
    return null;
  }
}
