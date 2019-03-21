import java.util.Arrays;
public class Quick{
  public static void main(String[] args){
    //testing partition
    /*
    int[] data = {-100,100,-99,99,-88,100,0,3,2};
    int piv = partition(1,2,data);
    System.out.println(piv+" "+Arrays.toString(Arrays.copyOfRange(data,1,4)));
    //*/
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
    /*
    for(int i=0;i<9;i++){
      int[] ary = {-100,100,-99,99,-88,100,0,3,2};
      //System.out.println(Arrays.toString(ary));
      int val = quickSelect(ary,i);
      System.out.println(val);
      if(val != sorted[i]) System.out.println("error: "+Arrays.toString(ary));
    }
    //*/
    int[][] testArrays = {
      {},
      {1},
      {2,4},
      {4,2},
      {9,0,2},
      {0,2,9},
      {9,2,0},
      {9,8,7,6,5,4,3,2,1},
      {5,3,2,4,6,7,9,5,2,4,5,5,5,5,5,5,5,5,5}
    };
    for(int i=0;i<testArrays.length;i++){
      System.out.println(i);
      quicksort(testArrays[i]);
      System.out.println(Arrays.toString(testArrays[i]));
    }
  }
  public static int partition(int start,int end,int[] data){
    //System.out.println(Arrays.toString(Arrays.copyOfRange(data,start,end)));
    int pivot = medianOfThree(data,start,end);
    swap(pivot,start++,data);
    pivot = start - 1;
    end--;
    while(start < end){
      if(data[start] > data[pivot] || (data[start]==data[pivot] && Math.random()>0.5)){
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
      return data[left];
    }
    else return data[left+1];
  }
  public static void quicksort(int[] data){
    quickSortH(data,0,data.length,750);
  }
  public static void quicksort(int[] data,int k){
    quickSortH(data,0,data.length,k);
  }
  public static void quickSortH(int[] data,int start,int end,int k){
    if(end - start > k  ){// when end==start, base case of doing nothing
      int pivot = partition(start,end,data);
      quickSortH(data,start,pivot,k);
      quickSortH(data,pivot+1,end,k);
    }else{//when array is short enough, just insertionsort
      insertionsort(data,start,end);
    }
  }
  public static int medianOfThree(int[] data,int lo,int hi){
    int a = randBetween(lo,hi);
    int b = randBetween(lo,hi);
    int c = randBetween(lo,hi);
    int min = Math.min(Math.min(data[a],data[b]),data[c]);
    int max = Math.max(Math.max(data[a],data[b]),data[c]);
    if(data[a]==min || data[a]==max){
      if(data[b]==min || data[b] == max){
        return c;
      }else{
        return b;
      }
    }else{
      return a;
    }
  }
  public static boolean isSorted(int[] data){
    for(int i=0;i+1<data.length;i++){
      if(data[i] > data[i+1]) return false;
    }
    return true;
  }
  private static void insertionsort(int[] data,int lo,int hi){
    for(int i=lo+1;i<hi;i++){//at any given time, all values to the left of i are sorted
      int j = i;
      while(j > lo && data[j-1] > data[j]){
        swap(j-1,j--,data);
      }
    }
  }
}
