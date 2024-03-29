package MyCollections;

public class MyStack {

    private MyNode topNode = null;

    public MyStack(){
    }

    public MyStack(char value){
        topNode = new MyNode(null, value);
    }

    public void add(char ... values){
        for(char value : values)
            topNode = new MyNode(topNode, value);
    }

    public void add (int ... values){
        for(int value : values)
            topNode = new MyNode(topNode, value);
    }

    public int pop(){
        MyNode removedNode = topNode;
        topNode = removedNode.getPriorNode();
        return removedNode.getValue();
    }

    public int peek(){
        return topNode.getValue();
    }

    @Override
    public String toString(){
        MyNode myNode = topNode;
        String string = "";
        while (myNode != null){
            string = myNode.getValue() + " " + string;
            myNode = myNode.getPriorNode();
        }
        return string;
    }

}
