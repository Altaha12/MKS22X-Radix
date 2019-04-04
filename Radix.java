public class Radix{

  public static int getDigit(int number, int digit){
    if(number<0)return -1*((number/(int)Math.pow(10,digit))%10);
    return ((number/(int)Math.pow(10,digit))%10);
  }

  public static li radixsort(int[]data){
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
  }

  public static li rsort(li theData){
    li[] buckets = new li[10];
    for(int i = 0; i<buckets.length;i++){buckets[i] = new li();}
    int i = 0;
    while(true){
      Node current = theData.First();
      while(current.hasNext()){
        buckets[getDigit(current.getVal(),i)].addLast(current.getVal());
        current=current.nextNode();//forgot this line and was crushed
      }
      buckets[getDigit(theData.Last().getVal(),i)].addLast(theData.Last().getVal());
      for(int j = 0; i< buckets.length;i++){buckets[0].attatch(buckets[j]);System.out.println(buckets[j]);}
      if(theData.getSize()==buckets[0].getSize())break;
      theData=buckets[0];
      for(int k = 0; i<buckets.length;i++){buckets[k] = new li();}
      i++;
      System.out.println(theData);
    }
    if(theData.First().getVal()<0){
      li tbr = new li();
      Node current = theData.Last();
      while(current.prevNode()!=null)tbr.addLast(current.getVal());
      tbr.addLast(theData.First().getVal());
      theData=tbr;
      current=current.prevNode();//forgot this one too, but same mistake noticed it faster
    }
    return theData;
  }

  public static void main(String[] args) {
    int[] test = new int[]{0,-12,129,-9684,984675,-984,65140,-94,651,-984,651,-98,4651,-964,961,-94,9874,943,6948};
    System.out.println(radixsort(test));
  }
}
