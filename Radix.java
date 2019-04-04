import java.util.Arrays;
public class Radix{
  public static void radixsort(int[]data){
    li theDataPlus = new li();
    li theDataminus = new li();
    int j =0;
    for(int i = 0;i<data.length;i++){
     int length = (int) (Math.log10(Math.abs(data[i])) + 1);
     if(length>j)j=length;
      if(data[i]>=0){
        theDataPlus.addLast(data[i]);
      }
      if(data[i]<0){
        theDataminus.addLast(data[i]);
      }
    }

    for(int i=0;i<j;i++){
      theDataPlus=rsort(theDataPlus,i);
      theDataminus=rsort(theDataminus,i);
    }
    li A = new li();
    if(theDataminus.getSize()!=0){
      Node current = theDataminus.Last();
      while(current.prevNode()!=null){
        A.addLast(current.get());
      }
        A.addLast(theDataminus.First().get());}
     A.attatch(theDataPlus);
     Node current1 = A.First();
     int index =0;
     while(current1.hasNext()){data[index]=current1.get();index++;current1=current1.nextNode();}
     data[index]=current1.get();
  }

  public static li rsort(li theData, int j){
    if(theData.getSize()==0)return theData;
    li[] buckets = new li[10];
    for(int i=0;i<10;i++)buckets[i]=new li();
      Node current = theData.First();
      while(current.hasNext()){
        buckets[current.dig(j)].addLast(current.get());
        current=current.nextNode();
      }
      buckets[theData.Last().dig(j)].addLast(theData.Last().get());
      for(int i=1;i<10;i++)buckets[0].attatch(buckets[i]);
      return buckets[0];
  }

  public static void main(String[] args) {
    int[] test = new int[]{6,12,129,9684,984675,984,65140,94,657,984,651,98,4651,964,968,4,9874,943,6948};
    //System.out.println(radixsort(test));
    System.out.println(Arrays.toString(test));
    radixsort(test);
    System.out.println(Arrays.toString(test));

  }
}
