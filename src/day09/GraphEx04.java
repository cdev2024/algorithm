package day09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
    String name;
    List<Node> links; // 인접 노드
    boolean visited;

    public Node(String name) {
        this.name = name;
        this.links = new LinkedList<Node>();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return this.name.equals(node.name);
    }
    
    void link(Node n) { // 인접 노드 추가 메서드
        links.add(n);
    }

    void visit(){
        this.visited = true;
    }

    boolean isVisited() {
        return this.visited;
    }
}

public class GraphEx04 {

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        c.link(b);
        c.link(d);
        d.link(a);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        // 정점 E를 찾고자 하는 경우
        // DFS 사용해서 찾아봅니다.

        Node target = e;

        // DFS
        ArrayDeque<Node> stack = new ArrayDeque<Node>();
        stack.push(a); // 탐색 시작 정점 : a 탐색 대기열에 추가

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            n.visit();
            System.out.println(n);

            if (n.equals(target)) {
                System.out.println("FOUND!!!! " + target);
                break;
            }

            for (Node l : n.links) {
                if(l.isVisited())
                    continue;
                if(stack.contains(l))
                    continue;
                stack.push(l);
            }
//            n.links.stream().filter(l -> !stack.contains(l)).forEach(stack::push);
        }
    }
}
