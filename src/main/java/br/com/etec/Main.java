/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec;

import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.util.Locale;
import java.util.Properties;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author dfelix3
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String COR_AZUL_CLARO_ = "180 209 240";
    private static final String COR_BRANCO = "255 255 255";
    private static final String COR_PRETO = "0 0 0";
    private static final String COR_CINZA_BORDAS = "229 236 231";
    //private static final String COR_CINZA_BORDAS = "218 254 230";

    @SuppressWarnings("ALL")
    public static void main(String args[]) {
        Locale.setDefault(new Locale("pt" , "BR"));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Define o look and feel.
                    initLookAndFeel();
                    installSmartLookAndFeel();
                } catch (Exception ex) {
                    LOGGER.log(Level.WARN , null , ex);
                } finally {
                    new ClassPathXmlApplicationContext("META-INF/spring-config.xml");
                }

            }
        });

    }

    private static void installSmartLookAndFeel() throws UnsupportedLookAndFeelException {
        SmartLookAndFeel.setTheme(getLaFProperties());
        UIManager.setLookAndFeel(new SmartLookAndFeel());
    }

    private static void installDefaultLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                LOGGER.log(Level.INFO , "LookAndFeel " + info.getName());
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                    LOGGER.log(Level.INFO , "Atribuindo o LookAndFeel " + info.getName());
                    //break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.WARN , null , ex);
        }
    }

    private static void initLookAndFeel() {
        UIManager.put("Button.defaultButtonFollowsFocus" , Boolean.TRUE);
    }

    private static Properties getLaFProperties() {
        Properties props = new Properties();

        props.put("logoString" , "CTPS");
        props.put("licenseKey" , "INSERT YOUR LICENSE KEY HERE");

        props.put("selectionBackgroundColor" , COR_AZUL_CLARO_);
        props.put("menuSelectionBackgroundColor" , COR_AZUL_CLARO_);

        props.put("controlColor" , COR_AZUL_CLARO_);
        props.put("controlColorLight" , COR_AZUL_CLARO_);
        props.put("controlColorDark" , COR_AZUL_CLARO_);

        props.put("buttonColor" , "214 219 229");
        props.put("buttonColorLight" , COR_BRANCO);
        props.put("buttonColorDark" , "225 225 224");

        props.put("rolloverColor" , COR_CINZA_BORDAS);
        props.put("rolloverColorLight" , COR_CINZA_BORDAS);
        props.put("rolloverColorDark" , COR_AZUL_CLARO_);

        props.put("windowTitleForegroundColor" , COR_PRETO);
        props.put("windowTitleBackgroundColor" , COR_AZUL_CLARO_);
        props.put("windowTitleColorLight" , COR_AZUL_CLARO_);
        props.put("windowTitleColorDark" , COR_AZUL_CLARO_);
        props.put("windowBorderColor" , COR_CINZA_BORDAS);

        props.put("windowInactiveTitleColorLight" , COR_CINZA_BORDAS);
        props.put("windowInactiveTitleColorDark" , COR_CINZA_BORDAS);

        props.put("backgroundColor" , COR_BRANCO);
        props.put("desktopColor" , COR_BRANCO);
        props.put("backgroundPattern" , "off");

        props.put("textureSet" , "Custom");
        props.put("menubarTexture" , COR_BRANCO);
        props.put("windowTexture" , COR_BRANCO);

        return props;
    }
}
