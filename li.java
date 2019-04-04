public class li{
    private class Node{
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
    private Node Start,End;
    private int Size;
    public li(){
      Size=0;
      Node Start = null;
      Node End = null;
    }
    public int First(){
      return Start.getVal();
    }
    public int Last(){
      return End.getVal();
    }
    public void addFirst(int Number){
      if(Start==null||End==null){
        Node added= new Node(Number,null,null);
        Start=added;
        End=added;
      }
      else{
        Node added = new Node(Number,null,Start);
        Start.setPrev(added);
        Start=added;
      }
      Size+=1;
    }
    public void addLast(int Number){
      if(Start==null||End==null){
        Node added= new Node(Number,null,null);
        Start=added;
        End=added;
      }
      else{
        Node added = new Node(Number,End,null);
        End.setNext(added);
        End=added;
      }
      Size+=1;
    }
    public void attatch(li merged){
      End.setNext(merged.Start);
      End=merged.End;
      Size+=merge.Size;
    }
    public int getSize(){return Size;}
    public String toString(){
      String tbr ="[ ";
      Node current = Start;
      while(current.hasNext()){
        tbr+=current.getVal()+", ";
        current= current.nextNode();
      }
      tbr+=End.getVal();
      tbr+="]";
      return tbr;
    }
    public static void main(String[] args) {
      li test= new li();
      for(int i=0;i<10;i++){
        test.addLast(i);
      }
      System.out.println(test);
      li test1= new li();
      for(int i=0;i<10;i++){
        test1.addFirst(i);
      }
      System.out.println(test1);
      test.attatch(test1);
      System.out.println(test);
    }

}
