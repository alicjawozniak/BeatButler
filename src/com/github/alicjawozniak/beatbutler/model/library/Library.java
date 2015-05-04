package com.github.alicjawozniak.beatbutler.model.library;

import com.github.alicjawozniak.beatbutler.model.Song;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * @author Tomasz Wójcik
 */
public class Library implements TreeModel {
    private Node<String> root = new Node<>();
    private TreeModel tree = new DefaultTreeModel(root);

    public void add(Song song) {
        root.add(new Node<>(song.getArtist(), song.getArtist())) // artist
                .add(new Node<>(song.getAlbum(), song.getAlbum())) // album
                .add(new Node<>(song.getTitle(), song)); // title

    }

    @Override
    public Object getRoot() {
        return tree.getRoot();
    }

    @Override
    public Object getChild(Object parent, int index) {
        return tree.getRoot();
    }

    @Override
    public int getChildCount(Object parent) {
        return tree.getChildCount(parent);
    }

    @Override
    public boolean isLeaf(Object node) {
        return tree.isLeaf(node);
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        tree.valueForPathChanged(path, newValue);
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return tree.getIndexOfChild(parent, child);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        tree.addTreeModelListener(l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        tree.removeTreeModelListener(l);
    }
}
