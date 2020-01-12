package textileproject;


import java.awt.Component;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class DukkandakiUrunler  {
    
private File fileDukkandakiUrunler = new File("dukkandakiUrunler.txt");
private boolean modelDukkandakiUrunlerYuklemeDurumu = true;

    public DukkandakiUrunler() 
    {
        
        
    }

    public File getDukkandakiUrunlerFile ()
    {
        return fileDukkandakiUrunler;
    }
    
    
    public Object[] UrunBilgileriEkle (String modelIsmi,String kumasTuru,String bedenSayisi,String toplamAdet,String dosyaYolu)
    {
        Object[] row = null;
        
       
            if(!modelIsmi.isEmpty() && !kumasTuru.isEmpty()&& checkInputIsANumber(bedenSayisi)
                    &&checkInputIsANumber(toplamAdet))
            {
            row = new Object[5];
        row[0] = modelIsmi;
        row[1]= kumasTuru;
        row[2]= bedenSayisi;
        row[3]= toplamAdet;
        row[4]= dosyaYolu;
        }else if(!checkInputIsANumber(bedenSayisi))
        {
            JOptionPane.showMessageDialog(new JDialog(), "Beden sayısı kısmını boş bıraktınız veya harf girmeyiniz.");
        }
        else if(!checkInputIsANumber(toplamAdet))
        {
            JOptionPane.showMessageDialog(new JDialog(), "Toplam adet kısmını boş bıraktınız veya harf girmeyiniz.");
        }
        return row;
    }
    public String getPathWay(Component owner)
    {
        JFileChooser chooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter(
            "Image files", "jpg", "jpeg", "gif","png");
        chooser.setFileFilter(filter);
        chooser.setAccessory(new ImagePreviewer(chooser));
        String name =null;
        System.out.println(owner.getClass().getName());
        chooser.setCurrentDirectory(new File("."));

        
        {
        // show file chooser dialog
        int result = chooser.showOpenDialog(owner);

        // if image file accepted, set it as icon of the label
        if (result == JFileChooser.APPROVE_OPTION)
        {
             name = chooser.getSelectedFile().getPath();
             /*
             eğer gösterilen dosya aşağıdaki uzantıları içermiyorsa kullanıcıyı uyarır ve tekrar resim yolu göstermesini söyler.
             */
            if(!name.contains(".jpg")&&!name.contains(".png")&&!name.contains(".jpeg")&&!name.contains(".gif"))
            {JOptionPane.showMessageDialog(owner, "Yanlış yol gösterdiniz.Lütfen ekran üzerinden seçerek tekrar resim yolunu gösteriniz!");
                name =getPathWay(owner);
            }
    }    } 
        return name;
    }
     public boolean checkInputIsANumber (String s)
     {
          try {
            float f = Float.parseFloat(s);
        } 
        catch(NullPointerException n)
        {
            System.out.println("Çalıştı 000");
            return false;
        }
        catch (NumberFormatException  e) {
            return false;
              
            } 
        
        System.out.println("Çalıştı 222");
        return true;
     }
public void kullanıcıVerileriniKaydet (Object[][] gecmisBilgiler, Object[]simdikiBilgiler,int getRowCount,int getColumnCount)
{

    Object[][] gecmisVeriler = gecmisBilgiler;
    Object[][] simdikiVeriler = new Object[getRowCount][getColumnCount];
 
    System.out.println("textileproject.DukkandakiUrunler.kullanıcıVerileriniKaydet() daki gecmisveriler arrayi ="+ Arrays.deepToString(gecmisVeriler));
        System.out.println("textileproject.DukkandakiUrunler.kullanıcıVerileriniKaydet() daki simdikiBilgiler arrayi ="+ Arrays.deepToString(simdikiBilgiler));
//    System.out.println("textileproject.DukkandakiUrunler.kullanıcıVerileriniKaydet() gecmisverileri arrayinin uzunluğu =" + gecmisVeriler.length);
        if(gecmisVeriler !=null)
    {
        for (int i = 0; i < gecmisVeriler.length; i++) {
            for (int j = 0; j < gecmisVeriler[i].length; j++) {
                System.out.println("gecmisVeriler in 2. indeksinin uzunluğu =" + gecmisVeriler[i].length);
                simdikiVeriler[i][j]= gecmisVeriler[i][j];
            }
        }
    }
        if(simdikiBilgiler != null)
        {
     for (int i = simdikiVeriler.length-1; i < simdikiVeriler.length; i++) {
         if(simdikiVeriler[i] != null)
         {
            for (int j = 0; j < simdikiVeriler[i].length; j++) {
                simdikiVeriler[i][j]= simdikiBilgiler[j];
            }
         }
        }
     System.out.println("textileproject.DukkandakiUrunler.kullanıcıVerileriniKaydet() simdikiVeriler arrayi =" + Arrays.deepToString(simdikiVeriler));
        }
     try{
      //  file = new File("C:\\Users\\H3RK3S\\Desktop\\TextileProject\\fermuaradet.txt");
        if(!fileDukkandakiUrunler.exists())
        {
            
            fileDukkandakiUrunler.createNewFile();
        }
    
            FileWriter fw = new FileWriter(fileDukkandakiUrunler.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
             
            
               for (int i = 0; i < simdikiVeriler.length; i++) {
                   for (int j = 0; j < simdikiVeriler[i].length; j++) {
                        bw.write(simdikiVeriler[i][j].toString()+ "tF3sjrG2dB");
                        System.out.println("bw.write daki döngü = " + simdikiVeriler[i][j].toString());
                   }
                   bw.newLine();
                   
               }
              
           
           
            bw.close();
            fw.close();
            
        }
catch( IOException i)
{
    
}
        
         
}
public Object[][] getDukkandakiUrunBilgileri()
{
     
        Object[][] row = null;
        try {
 
            
            FileReader reader = new FileReader(fileDukkandakiUrunler);
            BufferedReader br = new BufferedReader(reader);
            try {
                //Eğer dosyanın içi boşsa null değerini döndür
                if(!br.ready())
                {
                    System.out.println("BufferredReader dosyadaki verileri okumadı ve değer null döndü");
                    
                }
            } catch (IOException ex) {
                
                //Logger.getLogger(TextileProject.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            Object[] lines = br.lines().toArray();
            
            
            System.out.println("Dosyadan okunan 'lines' array değeri ="+ Arrays.deepToString(lines));
            System.out.println("'lines' arrayinin uzunluğu ="+ lines.length);
            
             row = new Object[lines.length][6];
           
            for (int i = 0; i <row.length; i++)
            {
                //Burada lines[i] nin değer row.length den küçük olduğu için
                // program hata veriyor bu yüzden bigileri okurken arrayin
                //içindeki bütün değerleri buradaki if döngüsünde okunur.
                
             row[i] = lines[i].toString().split("tF3sjrG2dB");
                
                System.out.println("getDukkandakiUrunBilgileri dosyadan okunan lines[i] değeri"+Arrays.toString(row[i]));
                        
            }
            
            
                        try {
                    br.close();
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(TextileProject.class.getName()).log(Level.SEVERE, null, ex);
                }
                            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextileProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
   
}
public String resimDegistir(int secilenSutunIndeksi,int getRowCount,int getColumnCount,Component owner)
{
    Object[][] dukkandakiUrunBilgiler = getDukkandakiUrunBilgileri();
    String degistirilenResimYolu = null;
    int depolananSutunDeger = secilenSutunIndeksi;
       
        if(depolananSutunDeger == secilenSutunIndeksi)
        {
            degistirilenResimYolu = getPathWay(owner);
            Object[] degistirelecekResminSutunu = dukkandakiUrunBilgiler[secilenSutunIndeksi];
            degistirelecekResminSutunu[5] = degistirilenResimYolu;
            dukkandakiUrunBilgiler[secilenSutunIndeksi] = degistirelecekResminSutunu;

            kullanıcıVerileriniKaydet(dukkandakiUrunBilgiler, null, getRowCount,getColumnCount+1);
        }
    
    return degistirilenResimYolu;
   
}
public void dukkandakiUrunlerinFotosunuGuncelle(JDialog jdialog,JTable table,JLabel label)
{
     ImageIcon icon = new ImageIcon(resimDegistir(table.getSelectedRow(), table.getRowCount(),table.getColumnCount(),jdialog));
       if (icon.getIconWidth() > label.getWidth())
            {
                icon = new ImageIcon(icon.getImage().getScaledInstance(
                    label.getWidth(), -1, Image.SCALE_DEFAULT));
  
        }       
       label.setIcon(icon);
       jdialog.pack();
            
}
public void tablodanBirSutunSil(JTable table,DefaultTableModel model,JDialog dialog,JLabel label)
{
    boolean sonDeger =true;
            
            Object [][] butunRowBilgiler = getDukkandakiUrunBilgileri();
            Object [][] simdikiRowBilgiler =null;
            
            System.out.println("Dkkandakirunler sınıfının tablodanBirSutunSil fonksdaki dosyadan okunan bilgiler ="+ Arrays.deepToString(butunRowBilgiler));
            System.out.println("tablodanbirsütunsil fonksdaki sutunsayısı ="+model.getColumnCount());

            if(model.getRowCount() !=0)
            {
                simdikiRowBilgiler = new Object[model.getRowCount()-1][model.getColumnCount()+1];
                
                System.out.println("Seçilen sütun değeri ="+ table.getSelectedRow());
                System.out.println("simdikiRowbilgiler arrayinin uzunluğu ve içi ="+ Arrays.deepToString(simdikiRowBilgiler));
                System.out.println("Tablo silinmeden önceki modelbilgileri 'array butunRowBilgiler'="+ Arrays.deepToString(butunRowBilgiler));
            for (int i = 0; i < table.getSelectedRow(); i++) {
                for (int j=0;j<butunRowBilgiler[i].length;j++)
               {
                   System.out.println(butunRowBilgiler[i].length);
                   simdikiRowBilgiler[i][j] = butunRowBilgiler[i][j];
               }
               }
                for (int i = table.getSelectedRow(); i < simdikiRowBilgiler.length; i++) {
                    for (int j = 0; j < butunRowBilgiler[i].length; j++) {
                        simdikiRowBilgiler[i][j] = butunRowBilgiler[i+1][j];
                    }
                    
                }
              System.out.println("Tablo silindikten sonra modelbilgileri 'array butunRowBilgiler'="+ Arrays.deepToString(simdikiRowBilgiler));
  model.removeRow(table.getSelectedRow());
}
          
            if(simdikiRowBilgiler.length ==0)
{
    System.out.println("textileproject.DukkandakiUrunler.tablodanBirSutunSil() calıstıysa sıkıntı var");
    simdikiRowBilgiler = null;
    label.setIcon(null);
    dialog.pack();
}
            kullanıcıVerileriniKaydet(simdikiRowBilgiler, null, model.getRowCount(),model.getColumnCount()+1);
            table.setModel(model);
}
public void setModelDukkandakiUrunlerYuklemeDurumu (boolean set)
{
    modelDukkandakiUrunlerYuklemeDurumu = set;
}
public boolean getModelDukkandakiUrunlerYuklemeDurumu()
{
    return modelDukkandakiUrunlerYuklemeDurumu;
}
}