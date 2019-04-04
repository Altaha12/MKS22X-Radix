public class Radix{
  /*public static li radixsort(int[]data){
    li theDataPlus = new li();
    li theDataminus = new li();
    for(int i = 0;i<data.length;i++){
      if(data[i]>=0){
        theDataPlus.addLast(data[i]);
      }
    }
    for(int i = 0;i<data.length;i++){
      if(data[i]<0){
        theDataminus.addLast(data[i]);
      }
    }
    System.out.println(theDataPlus);
    System.out.println(theDataminus);

    li A = rsort(theDataPlus);
    li B =rsort(theDataminus);
    A.attatch(B);
    return A;
  }*/

  public static li rsort(li theData, int j){
    li[] buckets = new li[10];
    for(int i=0;i<10;i++)buckets[i]=new li();
      Node current = theData.First();
      while(current.hasNext()){
        buckets[current.dig(j)].addLast(current.get());
        current=current.nextNode();
      }
      buckets[theData.Last().dig(j)].addLast(theData.Last().get());
      for(int i=1;i<10;i++)buckets[0].attatch(buckets[i]);
      System.out.println(buckets[0]);
      return buckets[0];
  }

  public static void main(String[] args) {
    int[] test = new int[]{6,12,129,9684,984675,984,65140,94,657,984,651,98,4651,964,968,4,9874,943,6948};
    //System.out.println(radixsort(test));
    li theData = new li();
    for(int i = 0;i<test.length;i++){
      if(test[i]>=0){
        theData.addLast(test[i]);
      }
    }
    System.out.println(theData);
    for(int i =0; i<10;i++){
      theData=rsort(theData,i);
    }

  }
}
