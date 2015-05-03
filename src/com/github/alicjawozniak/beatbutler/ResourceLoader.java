package com.github.alicjawozniak.beatbutler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ResourceLoader {
    private static ClassLoader loader = ResourceLoader.class.getClassLoader();

    public static URL getResource(String name) {
        return loader.getResource(name);
    }

    public static ImageIcon getImageIcon(String name) {
        return new ImageIcon(getResource(name));
    }

    public static Image getImage(String name) throws IOException {
        return ImageIO.read(getResource(name));
    }
}
