abstract class Node { //Durch abstract kann man keine Node Instanzen mehr erzeugen
    String name;
    Node[] children;

    Node(String name, Node... children) {
        this.name = name;
        this.children = children;
    }
}

class BinaryNode extends Node {
    BinaryNode(String name, Node child1, Node child2) {
        super(name, child1, child2);
    }
}

class UnaryNode extends Node {
    UnaryNode(String name, Node child) {
        super(name, child);
    }
}

class Terminal extends Node {
    Terminal(String name) {
        super(name);
    }
}