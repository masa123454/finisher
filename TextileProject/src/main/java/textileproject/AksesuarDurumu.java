/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textileproject;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author H3RK3S
 */
public class AksesuarDurumu 
{
   private  File fileFermuar = new File("fermuaradet.txt");
 private  File fileEtiket = new File("etiketadet.txt");
 private  File fileKart = new File("kartadet.txt");
 private  File fileArma = new File("armaAdet.txt");
 private String dosyaKodlama = "tF3sjrG2dB";
public void comboBoxAksesuarDurumu (int getSelectedIndex,DefaultTableModel model,JTable table,Object[] columnIdentfier)
{
    switch(getSelectedIndex)
        {
            case 0:
                //Fermuarlar
                model.setColumnIdentifiers(columnIdentfier);
                table.setModel(model);
               
                    readFileForAksesuarDurumu(fileFermuar, model);
                
                break;
            case 1:
                //Etiketler
                 model.setColumnIdentifiers(columnIdentfier);
                table.setModel(model);
                
                    readFileForAksesuarDurumu(fileEtiket, model);
                
                break;
                case 2:
                    //Kartlar
                model.setColumnIdentifiers(columnIdentfier);
                table.setModel(model);
                
                    readFileForAksesuarDurumu(fileKart, model);
                
                break;
                case 3:
                    //Armalar
                    
                    
                    model.setColumnIdentifiers(columnIdentfier);
                table.setModel(model);
               
                    readFileForAksesuarDurumu(fileArma, model);
                
                break;
                default:
        }
}
public void readFileForAksesuarDurumu(File file,DefaultTableModel model)
{
  Object[][] okunanDegerler = null;
    if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(TextileProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            
            Object[] lines = br.lines().toArray();
            okunanDegerler = new Object[lines.length][model.getColumnCount()];
            
            for (int i = 0; i <lines.length; i++)
            {
             String[] row = lines[i].toString().split("tF3sjrG2dB");
             okunanDegerler[i] =row;
                System.out.println(Arrays.toString(row));
               
           
             try {
                    br.close();
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(TextileProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(model.getRowCount() ==0)
            {
                for (int i = 0; i < okunanDegerler.length; i++) {
                    model.addRow(okunanDegerler[i]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextileProject.class.getName()).log(Level.SEVERE, null, ex);
        }
     
}
public void aksesuarEkle(int getIndex,String getName,JLabel label1,JLabel label2,JLabel label3,Component dialog)
{
    if(getIndex !=-1)
    {
    switch(getIndex)
        {
            case 0:
                //Fermuarlar
               
                 label1.setText( getName + " boyunu giriniz");
                 label2.setText( getName + " rengini giriniz");
                 label3.setText(getName + " adetini giriniz");
       ((JDialog)dialog).pack(); 
        dialog.setVisible(true);   
        ((JDialog)dialog).pack(); 
                                    
                
                break; 
            case 1:
                //Etiketler
                
                
               System.out.println(getName);   
                 label1.setText(getName + " türünü giriniz.");
                 label2.setText( getName + " adetini giriniz.");
        ((JDialog)dialog).pack(); 
        dialog.setVisible(true);   
        ((JDialog)dialog).pack();  
                
                break;
                case 2:
                    //Kartlar
                    label1.setText(getName + " türünü giriniz.");
                 label2.setText( getName + " adetini giriniz.");
        ((JDialog)dialog).pack(); 
        dialog.setVisible(true);   
        ((JDialog)dialog).pack();
                break;
                case 3:
                    //Armalar
                    label1.setText(getName + " türünü giriniz.");
                 label2.setText( getName + " adetini giriniz.");
        ((JDialog)dialog).pack(); 
        dialog.setVisible(true);   
        ((JDialog)dialog).pack();
                break;
                default:
        }
    }
}
public void aksesuarSil (DefaultTableModel model,JTable table)
{
    if(table.getSelectedRow() !=-1)
    {
            model.removeRow(table.getSelectedRow());
            table.setModel(model);
        
    }
}
public String getDosyaKodlama()
{
    return dosyaKodlama;
}
}
