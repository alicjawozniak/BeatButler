package com.github.alicjawozniak.beatbutler.view;

import com.github.alicjawozniak.beatbutler.model.library.Node;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

/**
 * @author Tomasz Wójcik
 */
public class LibraryCellRenderer implements TreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Node node = (Node) value;
        System.out.println(node.getValue().toString());
        return new JLabel(node.getValue().toString());
    }
}
