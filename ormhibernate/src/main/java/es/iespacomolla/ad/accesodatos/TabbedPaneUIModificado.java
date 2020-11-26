/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespacomolla.ad.accesodatos;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JTabbedPane;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 *
 * @author miguel
 */
public class TabbedPaneUIModificado extends BasicTabbedPaneUI{
    
    private boolean MostrarEncabezado = false;
    
    @Override
    protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
        if (MostrarEncabezado) {
            return super.calculateTabAreaHeight(tabPlacement, horizRunCount, maxTabHeight);
        } else {
            return 0;
        }
    }
    
    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {}
    
    
}
