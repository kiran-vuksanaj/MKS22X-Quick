import java.io.*;
import java.util.*;
public class InsertionBalance{
  public static void main(String[] args){
    while(true){
      int k = (int)(Math.random()*Integer.parseInt(args[0]))+1;
      int[] ary = TypeDriver.makeArray(Integer.parseInt(args[1]),0);
      int[] ary2 = Arrays.copyOfRange(ary,0,ary.length);
      long builtinStart = System.currentTimeMillis();
      Arrays.sort(ary);
      long builtinEnd = System.currentTimeMillis();
      long timeStart = System.currentTimeMillis();
      Quick.quicksort(ary2,k);
      long timeEnd = System.currentTimeMillis();
      if(!(Arrays.equals(ary,ary2))) throw new RuntimeException("FAIL TO SORT");
      double val = (timeEnd-timeStart)/((double)builtinEnd-builtinStart);
      System.out.println(k+","+val);
    }
  }
  private static double sum(double[] ary){
    double out = 0;
    for(double val : ary){
      out += val;
    }
    return out;
  }
}
