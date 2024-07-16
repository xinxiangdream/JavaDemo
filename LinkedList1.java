package yang.algorithm.base.code02_linkedList;

import lombok.Getter;

import java.util.Objects;
import java.util.Stack;

/**
 * 翻转链表
 */
public class LinkedList1 {

    public static void main(String[] args) {
        Stack<Node> nodeStack = new Stack<>();
        Node node = new Node(12);
        Node node1 = new Node(1);
        Node node2 = new Node(6);
        Node node3 = new Node(4);
        Node node4 = new Node(14);
        node.setNextNode(node1).setNextNode(node2).setNextNode(node3)
                .setNextNode(node4);

        Node startNode = node;
        nodeStack.add(startNode);
        while (Objects.nonNull(startNode.getNextNode())) {
            Node nextNode = startNode.getNextNode();
            nodeStack.add(nextNode);
            startNode = nextNode;
        }
        node = nodeStack.peek();
        Node nextNode ;
        Node preNode = nodeStack.pop();
        while (!nodeStack.empty() && (nextNode = nodeStack.pop()) != null) {
            preNode.setNextNode(nextNode);
            preNode = nextNode;
        }
        preNode.setNextNode(null);
        System.out.println(node.value);
        while(node.getNextNode() !=null){
            node = node.getNextNode();
            System.out.println(node.value);
        }
    }

    @Getter
    private static class Node {
        Integer value;
        Node nextNode;

        public Node(Integer integer) {
            this.value = integer;
        }

        public Node setNextNode(Node nextNode) {
            this.nextNode = nextNode;
            return nextNode;
        }

    }
}

