package com.github.alicjawozniak.beatbutler;

import javax.swing.*;
import java.net.URL;

public class ResourceLoader {
    private static ClassLoader loader = ResourceLoader.class.getClassLoader();

    public static URL getResource(String name) {
        return loader.getResource(name);
    }

    public static ImageIcon getImageIcon(String name) {
        return new ImageIcon(getResource(name));
    }
}
