/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.common_classes;

import dsms.controllers.SearchComboController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class ComboSearch {

    private ArrayList<String> ar;
    private JTextField txt;

    public ComboSearch() {
    }

    public static void setSearchableCombo(final JComboBox cmb, boolean mustSort, final String noResultsText) {
        final ArrayList<String> ar = new ArrayList<>();
        final int s = cmb.getItemCount();
        for (int i = 0; i < s; i++) {
            boolean exists = false;
            for (int j = 0; j < ar.size(); j++) {
                if (ar.get(j).equalsIgnoreCase(cmb.getItemAt(i) + "")) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                ar.add(cmb.getItemAt(i) + "");
            }
        }
        if (mustSort) {
            Collections.sort(ar);
        }
        cmb.setEditable(true);
        cmb.setLightWeightPopupEnabled(true);
        final JTextField txt = (JTextField) cmb.getEditor().getEditorComponent();
        txt.addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent evt) {
                int key = evt.getKeyCode();
                if (!(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_ENTER || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP)) {
                    String s = txt.getText();
                    int caret = txt.getCaretPosition();
                    cmb.hidePopup();
                    cmb.removeAllItems();
                    for (int i = 0; i < ar.size(); i++) {
                        if (ar.get(i).toUpperCase().startsWith(s.substring(0, caret).toUpperCase())) {
                            cmb.addItem(ar.get(i));
                        }
                    }
                    cmb.showPopup();
                    if (cmb.getItemCount() == 0) {
                        cmb.addItem(noResultsText);
                    }
                    txt.setText(s);
                    txt.setCaretPosition(caret);
                } else if (key == KeyEvent.VK_ESCAPE) {
                    cmb.setSelectedItem(txt.getText());
                    cmb.hidePopup();
                } else if (key == KeyEvent.VK_ENTER && cmb.getSelectedIndex() == -1) {
                    if (cmb.getItemCount() == 1 && !cmb.getItemAt(0).equals(noResultsText)) {
                        cmb.setSelectedIndex(0);
                    } else if (cmb.getItemCount() > 1) {
                        cmb.setSelectedIndex(0);
                    }
                }
            }
        });
    }

    public static void searchCombo(final JComboBox comboBox, final String table, final String colum) {

        final JTextField text = (JTextField) comboBox.getEditor().getEditorComponent();
        text.addKeyListener(new KeyAdapter() {

          
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int key = e.getKeyCode();
                    if (!(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_ENTER || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP)) {
                        comboBox.hidePopup();
                        String text1 = text.getText();
                        comboBox.removeAllItems();
                        ArrayList<String> combo = SearchComboController.combo(text1 + "%", table, colum);
                        for (String string : combo) {
                            comboBox.addItem(string);
                        }
                        comboBox.showPopup();
                        if (comboBox.getItemCount() == 0) {
                            comboBox.addItem("noResultsText");
                        }
                        text.setText(text1);
                    } else if (key == KeyEvent.VK_ESCAPE) {
                        comboBox.setSelectedItem(text.getText());
                        comboBox.hidePopup();
                    } else if (key == KeyEvent.VK_ENTER && comboBox.getSelectedIndex() == -1) {
                        if (comboBox.getItemCount() == 1 && !comboBox.getItemAt(0).equals("noResultsText")) {
                            comboBox.setSelectedIndex(0);
                        } else if (comboBox.getItemCount() > 1) {
                            comboBox.setSelectedIndex(0);
                        }
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ComboSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
    public static void searchCombo(final JComboBox comboBox, final String table, final String colum,final int condition) {

        final JTextField text = (JTextField) comboBox.getEditor().getEditorComponent();
        text.addKeyListener(new KeyAdapter() {

          
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int key = e.getKeyCode();
                    if (!(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_ENTER || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP)) {
                        comboBox.hidePopup();
                        String text1 = text.getText();
                        comboBox.removeAllItems();
                        ArrayList<String> combo = SearchComboController.combo(text1 + "%", table, colum,condition);
                        for (String string : combo) {
                            comboBox.addItem(string);
                        }
                        comboBox.showPopup();
                        if (comboBox.getItemCount() == 0) {
                            comboBox.addItem("noResultsText");
                        }
                        text.setText(text1);
                    } else if (key == KeyEvent.VK_ESCAPE) {
                        comboBox.setSelectedItem(text.getText());
                        comboBox.hidePopup();
                    } else if (key == KeyEvent.VK_ENTER && comboBox.getSelectedIndex() == -1) {
                        if (comboBox.getItemCount() == 1 && !comboBox.getItemAt(0).equals("noResultsText")) {
                            comboBox.setSelectedIndex(0);
                        } else if (comboBox.getItemCount() > 1) {
                            comboBox.setSelectedIndex(0);
                        }
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ComboSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
