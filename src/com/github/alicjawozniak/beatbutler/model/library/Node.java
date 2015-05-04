package com.github.alicjawozniak.beatbutler.model.library;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tomasz Wójcik
 */
public class Node<T> implements TreeNode {
    private Node parent;
    private List<Node> children;
    private T value;
    private String key;
    private boolean isLeaf;
    private boolean isEmpty;

    public Node() {
        isEmpty = true;
        children = new ArrayList<Node>();
    }

    public Node(String key, T value, boolean isLeaf) {
        if (key == null || value == null)
            throw new NullPointerException();

        this.value = value;
        this.key = key;
        this.isLeaf = isLeaf;

        children = isLeaf ? null : new ArrayList<Node>();
    }

    public Node(String key, T value) {
        this(key, value, false);
    }

    public T getValue() {
        return value;
    }

    public Node add(Node node) {
        if (node == null)
            throw new NullPointerException();

        Node existingNode = getChildByKey(node.key);

        if (existingNode == null) {
            children.add(node);
            node.parent = this;
            return node;
        }

        return existingNode;
    }

    public Node getChildByKey(String key) {
        if (isLeaf) {
            return null;
        }

        for (Node node : children) {
            if (node.key.equals(key)) {
                return node;
            }
        }

        return null;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        if (isLeaf) {
            return null;
        }

        return children.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return isLeaf ? 0 : children.size();
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode node) {

        return children.indexOf(node);
    }

    @Override
    public boolean getAllowsChildren() {
        return !isLeaf();
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public Enumeration children() {
        return new Enumeration() {
            private Iterator iterator = children.iterator();

            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            @Override
            public Object nextElement() {
                return iterator.next();
            }
        };
    }
}
