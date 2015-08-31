package com.bo0tzz.util.tree;

import java.util.List;

/**
 * Created by bo0tzz
 */
public class Node<T> {
    private boolean isRoot;
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node(T data) {
        isRoot = true;
        this.data = data;
    }

    public Node(T data, Node<T> parent) {
        this.isRoot = false;
        this.data = data;
        this.parent = parent;
    }

    public Node<T> addChild(T data) {
        Node<T> child = new Node<T>(data,this);
        children.add(child);
        return child;
    }

    public T getData() {
        return data;
    }

    public Node<T> getParent() {
        if (!isRoot) {
            return parent;
        }
        return this;
    }

    public Node<T> getParent(int n) {
        if (!isRoot && n > 0) {
            return parent.getParent(n - 1);
        }
        return this;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Tree<T> subTree() {
        return new Tree(this);
    }
}
