/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.util;

import java.beans.PropertyChangeSupport;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dfelix3
 */
public enum ResourceBundleUtil {
    RELATORIO_PROFESSOR("br.com.etecab.report.resources"
                      , "report/br/com/etecab/report/resources"
                      , "RelatorioProfessor")
  , RELATORIO_QUADRO_AULAS("br.com.etecab.report.resources"
                      , "report/br/com/etecab/report/resources"
                      , "RelatorioQuadroAulas");
    public static final String PROP_PACKAGENAME = "packageName";
    public static final String PROP_FILEPATHNAME = "filePathName";
    public static final String PROP_FILENAME = "fileName";
    public static final String PROP_LOCALE = "locale";
    
    private String packageName = "";
    private String filePathName = "";
    private String fileName = "";
    private Locale locale = new Locale("pt", "BR");
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    
    private ResourceBundleUtil(String packageName, String filePathName, String fileName){
        this.packageName = packageName;
        this.filePathName = filePathName;
        this.fileName = fileName;
    }
    
    @Override
    public String toString(){
        return getFileName();
    }
    
    public String getProperty(ResourceBundle rb, String key){
        return rb.getString(key);
    }

    public void setProperty(String key, String value, Locale locale){
        Properties propertiesFile = getPropertiesFile(getLocale(locale));
        propertiesFile.setProperty(key, value);
        try {
            propertiesFile.store(new FileOutputStream(getPropertiesFileName(getLocale(locale))),null);
        } catch (IOException ex) {
            Logger.getLogger(ResourceBundleUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public ResourceBundle getResourceBundle(Locale locale) {
        return ResourceBundle.getBundle(getFullQualifiedName(), getLocale(locale));
    }

    public Properties getPropertiesFile(Locale locale) {
        String finalFile = getPropertiesFileName(getLocale(locale));
        try {
            Properties p = new Properties();
            FileInputStream fis = new FileInputStream(finalFile);
            p.load(fis);
            return p;
        } catch (IOException ex) {
            Logger.getLogger(ResourceBundleUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private String getPropertiesFileName(Locale locale) {
        return this.getFullFileName() + "_" + locale.toString() + ".properties";
    }
    
    private Locale getLocale(Locale locale){
        if (locale == null) {
            locale = this.getLocale();
        }        
        return locale;
    }

    private String getFullFileName() {
        return this.getFilePathName() + "/" + this.getFileName();
    }

    private String getFullQualifiedName() {
        return this.getPackageName() + "." + this.getFileName();
    }

    public String getPackageName() {
        return packageName;
    }

    public String getFilePathName() {
        return filePathName;
    }

    public String getFileName() {
        return fileName;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setPackageName(String packageName) {
        java.lang.String oldPackageName = this.packageName;
        this.packageName = packageName;
        propertyChangeSupport.firePropertyChange(PROP_PACKAGENAME, oldPackageName, packageName);
    }

    public void setFilePathName(String filePathName) {
        java.lang.String oldFilePathName = this.filePathName;
        this.filePathName = filePathName;
        propertyChangeSupport.firePropertyChange(PROP_FILEPATHNAME, oldFilePathName, filePathName);
    }

    public void setFileName(String fileName) {
        java.lang.String oldFileName = this.fileName;
        this.fileName = fileName;
        propertyChangeSupport.firePropertyChange(PROP_FILENAME, oldFileName, fileName);
    }

    public void setLocale(Locale locale) {
        java.util.Locale oldLocale = this.locale;
        this.locale = locale;
        propertyChangeSupport.firePropertyChange(PROP_LOCALE, oldLocale, locale);
    }
    
    
}
