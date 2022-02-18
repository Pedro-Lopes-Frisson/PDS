package ex5;
public class DuInJava {
  private final static String HELP = "Usage:\n"+
    "java ex5.DirSize <flags> <path>\n"+
    "Options:\n"+
    "-h: Displays usage message\n"+
    "-r: Gets size of directories and subdirs\n";
  
  public static void main(String[] args) {
    if(args.length < 0){
      System.out.println(HELP);
      System.exit(-100);
    }
    if(args.length >= 2){
      int j = 0;
      boolean isRecursive = false;
      for(String i : args){
        if(i.startsWith("-") && i.length() == 2){
          j++;
          switch(i){
            case "-h":
              System.out.println(HELP);
              break;
            case "-r":
              isRecursive = true;
              break;
            default:
              System.out.println("Bad flag!");
              System.out.println(HELP);
              System.exit(1);
              break;
          }
        }else{
          break;
        }
      }
      System.out.println("Processing .." + args[j].split("/")[args[j].split("/").length-1]);
      DirectorySize calc = new DirectorySize();
      System.out.println("Total: "+ calc.getSize(args[j],isRecursive) + "kB");
    }
    else{
      if(args[0].equals("-h")){
        System.out.println(HELP);
        System.exit(0);
      }
      
      System.out.println("Processing directory size " + args[0].split("/")[args[0].split("/").length-1]);
      DirectorySize calc = new DirectorySize();
      System.out.println("Dir size -> "+ calc.getSize(args[0],false) + "kB");
    }
  }
  
}