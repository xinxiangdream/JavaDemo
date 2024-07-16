package yang.algorithm.base.code02_linkedList;

import java.util.HashMap;

public class BaseLinkedList {
    //12,1,6,4,14,3
    protected static Node buildNode(int[] array) {
        Node startNode = new Node(array[0]);
        Node preNode = startNode;
        int length = array.length;
        for (int i = 1; i < length; i++) {
            Node node = new Node(array[i]);
            preNode = preNode.setNextNode(node);
        }
        return startNode;
    }

    protected static Node buildCircleNode(int[] array) {
        HashMap<Integer, Node> map = new HashMap<>();
        Node startNode = new Node(array[0]);
        Node preNode = startNode;
        int length = array.length;
        for (int i = 1; i < length; i++) {
            //存在一样的数据就停止构建
            if (map.get(array[i]) != null) {
                preNode.setNextNode(map.get(array[i]));
                break;
            }
            Node node = new Node(array[i]);
            map.put(array[i],node);
            preNode = preNode.setNextNode(node);
        }
        return startNode;
    }

    protected static RandomNode buildRandomNode(int[] array) {
        RandomNode startNode = new RandomNode(array[0]);
        RandomNode preNode = startNode;
        int length = array.length;
        for (int i = 1; i < length; i++) {
            RandomNode node = new RandomNode(array[i]);
            preNode = preNode.setNextNode(node);
        }
        startNode.next.rand = startNode;
        startNode.rand = startNode.next.next;
        return startNode;
    }

    protected static class Node {
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

    protected static class RandomNode {

        int value;
        RandomNode next;
        RandomNode rand;

        public RandomNode(Integer integer) {
            this.value = integer;
        }

        public RandomNode setNextNode(RandomNode nextNode) {
            this.next = nextNode;
            return nextNode;
        }

    }

    protected static void toString(Node node) {
        int count = 0;
        while (node != null) {
            count++;
            System.out.println(node.value);
            node = node.nextNode;
        }
        System.out.println("[打印数量]：" + count);
    }
}
