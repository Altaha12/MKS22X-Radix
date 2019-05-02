import java.util.Arrays;
public class Radix{
  public static void radixsort(int[]data){
    li theDataPlus = new li();
    int j = 0;
    for(int i = 0;i<data.length;i++){
     int length = (int) (Math.log10(Math.abs(data[i])) + 1);
     if(length>j)j = length;
     theDataPlus.addLast(data[i]);
    }
    for(int i=0;i<j;i++){
      theDataPlus=rsort(theDataPlus,i);
    }
    Node current1 = theDataPlus.First();
    int index =0;
    while(current1.hasNext()){data[index]=current1.get();index++;current1=current1.nextNode();}
    data[index]=current1.get();
  }

  public static li rsort(li theData, int j){
    if(theData.getSize()==0)return theData;
    li[] buckets = new li[19];
    for(int i=0;i<19;i++)buckets[i]=new li();
    Node current = theData.First();
    while(current.hasNext()){
        buckets[current.dig(j)+9].addLast(current.get());
        current=current.nextNode();
    }
    buckets[theData.Last().dig(j)+9].addLast(theData.Last().get());
    for(int i=1;i<19;i++)buckets[0].attatch(buckets[i]);
    return buckets[0];
  }

  public static void main(String[]args){
 System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          if(i%2==0)
          {
          data1[i] = (int)(Math.random()*MAX*-1);
          data2[i] = data1[i];
          }
          else
          {
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
          }
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Radix.radixsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }

}
}
