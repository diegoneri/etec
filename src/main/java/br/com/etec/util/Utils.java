/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.util;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author dfelix3
 */
public class Utils {

    private final static String URL_DEFAULT_ICON = "/images/logo_ab.png";
    private static Image DEFAULT_IMAGE;
    private static ImageIcon DEFAULT_IMAGE_ICON;

    public static Image getDefaultImage() {
        if (DEFAULT_IMAGE == null) {
            DEFAULT_IMAGE = Toolkit.getDefaultToolkit().getImage(Utils.class.getResource(URL_DEFAULT_ICON));
        }
        return DEFAULT_IMAGE;
    }

    public static ImageIcon getDefaultImageIcon() {
        if (DEFAULT_IMAGE_ICON == null) {
            DEFAULT_IMAGE_ICON = new ImageIcon(Utils.class.getResource(URL_DEFAULT_ICON));
        }
        return DEFAULT_IMAGE_ICON;
    }
}
