interface INode {
    Node getChild(int n);
    void setChild(int n, Node node);
    int getArity();
    String getValue();
    boolean isTerminal();
}

class Node implements INode {
    String value;
    Node[] links;
    boolean terminal;

    Node(String value, int n) {
        if(n == 0) {
            this.value = value;
            this.terminal = true;
        } else {
            this.value = value;
            this.links = new Node[n];
            this.terminal = false;
        }

    }

    Node (String value) {
        this(value, 0);
    }


    public Node getChild(int n) {
        if(n < 0 || n >= links.length) throw new IllegalArgumentException("n is not an index for a child");
        if(isTerminal()) return null;

        return this.links[n];
    }

    public void setChild(int n, Node node) {
        if(n < 0 || n >= links.length) throw new IllegalArgumentException("n is not an index for a child");
        this.links[n] = node;
    }

    public int getArity() {
        return links.length;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isTerminal() {
        return this.terminal;
    }

    @Override
    public String toString() {
        if(isTerminal()) return "Node(" + this.value + ")";
        String children = "";

        if(this.links.length > 0) {
            for(Node e: this.links) {
                children += ", " + e;
            }
        }

        return "Node(" + this.value + children + ")";
    }
}

class Cursor {
    Node node;
    Node[] parents = new Node[]{};
    int horizontalPos = 0;

    Cursor(Node node) {
        this.node = node;
    }

    Cursor down() {
        if(node.isTerminal()) throw new IllegalArgumentException("Node is Terminal");
        
        Node[] copy = parents;
        parents = new Node[parents.length + 1];

        for(int i = 0; i < copy.length; i++) {
            parents[i] = copy[i];
        }

        parents[parents.length - 1] = node;

        node = node.links[0];
        horizontalPos = 0;

        return this;
    }

    Cursor up(){
        if(parents.length == 0) throw new IllegalArgumentException("Can't go up because at Root");
        node = parents[parents.length - 1];

        Node[] copy = parents;
        parents = new Node[parents.length - 1];

        for(int i = 0; i < parents.length; i++) {
            parents[i] = copy[i];
        }

        return this;
    }

    Cursor shift(int n) {
        Node parent = parents[parents.length - 1];
        if(n > 0) {
            node = parent.getChild((horizontalPos + n) % parent.links.length);
            horizontalPos = (horizontalPos + n) % parent.links.length;
        }
        else if(n < 0) {
            //node = parent.getChild((horizontalPos + (-n + parent.links.length)) % parent.links.length);
            //horizontalPos = (horizontalPos + (-n + parent.links.length)) % parent.links.length;

            node = parent.getChild((((horizontalPos + n) % parent.links.length) + parent.links.length) % parent.links.length);
            horizontalPos = (((horizontalPos + n) % parent.links.length) + parent.links.length) % parent.links.length;
        }

        return this;
    }

    Cursor right() {
        shift(1);
        return this;
    }

    Cursor left() {
        shift(-1);

        return this;
    }

    Cursor insert(Node node) {
        Node parent = parents[parents.length - 1];
        parent.setChild(horizontalPos, node);
        this.node = parent.getChild(horizontalPos);

        return this;
    }

    Cursor delete() {
        insert(null);
        return this;
    }

    Cursor root() {
        if(parents.length <= 0) throw new IllegalArgumentException("Already at Root");
        this.node = parents[0];
        this.parents = new Node[]{};

        return this;
    }

    Node getNode() {
        return this.node;
    }

    @Override
    public String toString() {
        return this.getNode().toString();
    }
 }
