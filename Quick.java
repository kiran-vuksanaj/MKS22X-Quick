import java.util.Arrays;
public class Quick{
  public static void main(String[] args){
    //testing partition
    /*
    int[] data = {-100,100,-99,99,-88,100,0,3,2};
    int piv = partition(1,4,data);
    System.out.println(piv+" "+Arrays.toString(Arrays.copyOfRange(data,1,4)));
    */
    int[] sorted = {-100,-99,-88,0,2,3,99,100,100};
    /*
    int[] ary = {-100,100,-99,99,-88,100,0,3,2};
    int val = quickSelect(ary,4);
    int success = 0;
    while(val==2){
      success ++;
      //System.out.println("-----");
      val = quickSelect(ary,4);
    }
    System.out.println(Arrays.toString(ary));
    //*/
    for(int i=0;i<9;i++){
      int[] ary = {-100,100,-99,99,-88,100,0,3,2};
      //System.out.println(Arrays.toString(ary));
      int val = quickSelect(ary,i);
      System.out.println(val);
      if(val != sorted[i]) System.out.println("error: "+Arrays.toString(ary));
    }
    //*/
  }
  public static int partition(int start,int end,int[] data){
    int pivot = randBetween(start,end);
    swap(pivot,start++,data);
    pivot = start - 1;
    end--;
    while(start < end){
      if(data[start] > data[pivot]){
        swap(start,end--,data);
      }else{
        start++;
      }
    }
    if(data[start] > data[pivot]){
      start--; //start will be used in a moment to swap, value should be <= pivot as it goes to front
    }
    swap(start,pivot,data);
    return start; //no longer a start obviously but the value that pivot got swapped to
  }
  public static int randBetween(int start,int end){
    double out = Math.abs(Math.random())*(end-start) + start;
    return ((int)out);
  }
  public static void swap(int a,int b,int[] data){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  public static int quickSelect(int[] data,int k){
    int left = 0;
    int right = data.length;
    while(right-left >= 2){
      //System.out.println(left + " " + right);
      //for(int i=left;i<right;i++) System.out.print(data[i]+",");
      //System.out.println("");
      int pivot = partition(left,right,data);
      if(pivot == k) return data[k];
      if(pivot >  k) right = pivot;
      if(pivot <  k) left = pivot;
      //System.out.println(left+" "+right);
      //System.out.println(pivot);
      //System.out.println(Arrays.toString(data));
    }
    if(right-left < 2){
      System.out.println("mmm");
      return data[left];
    }
    else return data[left+1];
  }
}
