package MyCollections;

public class MyNode {

    private MyNode priorNode;
    private int value;
    private char operator;

    public MyNode(MyNode node, int value){
        this.priorNode = node;
        this.value = value;
    }

    public MyNode(MyNode node, char operator){
        this.priorNode = node;
        this.operator = operator;
    }

    public MyNode getPriorNode() {
        return priorNode;
    }

    public void setPriorNode(MyNode priorNode) {
        this.priorNode = priorNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}
