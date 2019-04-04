public class li{
    private Node Start,End;
    private int Size;
    public li(){
      Size=0;
      Node Start = null;
      Node End = null;
    }
    public Node First(){
      return Start;
    }
    public Node Last(){
      return End;
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
      if(merged.getSize()==0)return;
      if(this.getSize()==0){Start = merged.Start;End=merged.End;Size=merged.Size; return;}
      End.setNext(merged.Start);
      End=merged.End;
      Size+=merged.Size;
      merged.Size=0;
      merged.Start=null;
      merged.End=null;
    }
    public int getSize(){return Size;}
    public String toString(){
      if(Size==0)return "[]";
      String tbr ="[ ";
      Node current = Start;
      while(current.hasNext()){
        tbr+=current.get()+", ";
        current= current.nextNode();
      }
      tbr+=End.get();
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
