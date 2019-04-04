public class Radix{
  public static int getDigit(int number, int digit){
    return ((number/(int)Math.pow(10,digit))%10);
  }
  /*public static void radixsort(int[]data){
    li[] buckets = new li[10];
    for(int i = 0; i<buckets.length;i++){buckets[i] = new li();}
  }*/
  public static void main(String[] args) {
    System.out.println(getDigit(987654321,2));
  }
}
