package com.github.alicjawozniak.beatbutler.view;

import com.github.alicjawozniak.beatbutler.model.Song;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tomasz Wójcik
 */
public class PlaylistCellRenderer implements ListCellRenderer<Song> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Song> list, Song song, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel cell = new JPanel();

        cell.setLayout(new BorderLayout(0, 0));
        cell.setBackground(isSelected ? Color.LIGHT_GRAY : Color.white);

        cell.add(new JLabel(String.format("%s - %s", song.getArtist(), song.getTitle())), BorderLayout.WEST);
        return cell;
    }
}
