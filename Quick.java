public class Quick{
  public static void main(String[] args){

  }
  public static int partition(int start,int end,int[] data){
    int pivot = randBetween(start,end);
    swap(pivot = start,start++,data);
    while(start != end){
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
    return (int)(Math.abs(Math.random())*(end-start));
  }
  public static void swap(int a,int b,int[] data){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
}
