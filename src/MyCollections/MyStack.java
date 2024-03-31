package MyCollections;

public class MyStack {

    private MyNode topNode = null;
    private int size = 0; // Cache the size

    public MyStack(){
    }

    public MyStack(char value){
        topNode = new MyNode(null, value);
    }

    public void push(char ... values){
        for(char value : values){
            topNode = new MyNode(topNode, value);
            size++;
        }
    }

    public void push(int ... values) {
        for (int value : values){
            topNode = new MyNode(topNode, value);
            size++;
        }
    }

    public int pop(){
        MyNode removedNode = topNode;
        topNode = removedNode.getPriorNode();
        size--;
        return removedNode.getValue();
    }

    public int peek(){
        return topNode.getValue();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        MyNode myNode = topNode;
        while (myNode != null) {
            stringBuilder.insert(0, myNode.getValue() + " "); // Prepend to the beginning
            myNode = myNode.getPriorNode();
        }
        return stringBuilder.toString().trim(); // Remove trailing space
    }

}
