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
  public int getVal(){
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
