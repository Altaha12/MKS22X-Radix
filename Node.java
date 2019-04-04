public class Node{
  private Node Prev,Next;
  public int val;
  public Node(int Number, Node Prev1, Node Next1){
    Prev=Prev1;
    Next=Next1;
    val=Number;
  }
  public Node nextNode(){
    return Next;
  }
  public Node prevNode(){
    return Prev;
  }
  public  int dig(int digit){
    int number=val;
    if(number<0)return -1*((number/(int)Math.pow(10,digit))%10);
    return ((number/(int)Math.pow(10,digit))%10);
  }
  public int get(){
    return val;
  }
  public void setVal(int Number){
    val=Number;
  }
  public void setNext(Node nex){
    Next=nex;
  }
  public void setPrev(Node pre){
    Prev=pre;
  }
  public Boolean hasNext(){
    if(Next!=null)return true;
    return false;
  }

}
