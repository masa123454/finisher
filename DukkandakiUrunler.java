package textileproject;


import java.awt.Component;
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class DukkandakiUrunler  {
    
private File fileDukkandakiUrunler = new File("dukkandakiUrunler.txt");

    public DukkandakiUrunler() 
    {
        
        
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
        }
        return row;
    }
    public String getPathWay(Component owner)
    {
        JFileChooser chooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter(
            "Image files", "jpg", "jpeg", "gif","png");
        chooser.setFileFilter(filter);
        
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
public void kullanıcıVerileriniKaydet (Object[][] gecmisBilgiler, Object[]simdikiBilgiler,int getRowCount)
{

    Object[][] gecmisVeriler = gecmisBilgiler;
    Object[][] simdikiVeriler = new Object[getRowCount][5];
 
    System.out.println("textileproject.DukkandakiUrunler.kullanıcıVerileriniKaydet() daki gecmisveriler arrayi ="+ Arrays.deepToString(gecmisVeriler));
        System.out.println("textileproject.DukkandakiUrunler.kullanıcıVerileriniKaydet() daki simdikiBilgiler arrayi ="+ Arrays.deepToString(simdikiBilgiler));
    //System.out.println("textileproject.DukkandakiUrunler.kullanıcıVerileriniKaydet() gecmisverileri arrayinin uzunluğu =" + gecmisBilgiler.length);
        if(gecmisVeriler !=null)
    {
        for (int i = 0; i < simdikiVeriler.length; i++) {
            for (int j = 0; j < simdikiVeriler[i].length; j++) {
                simdikiVeriler[i][j]= gecmisVeriler[i][j];
            }
        }
    }
     for (int i = simdikiVeriler.length-1; i < simdikiVeriler.length; i++) {
            for (int j = 0; j < simdikiVeriler[i].length; j++) {
                simdikiVeriler[i][j]= simdikiBilgiler[j];
            }
        }
     System.out.println("textileproject.DukkandakiUrunler.kullanıcıVerileriniKaydet() simdikiVeriler arrayi =" + Arrays.deepToString(simdikiVeriler));
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
                        bw.write(simdikiVeriler[i][j].toString()+ " ");
                        System.out.println(simdikiVeriler[i][j].toString());
                   }
                   bw.newLine();
                   
               }
              
           
           
            bw.close();
            fw.close();
            
        }
catch( IOException i)
{
    
}
         catch(NullPointerException n)
         {
             
         }
         
}
public Object[][] getDukkandakiUrunBilgileri(int getRowCount)
{
     
        Object[][] row = new Object[getRowCount][5];
        try {
 
            
            FileReader reader = new FileReader(fileDukkandakiUrunler);
            BufferedReader br = new BufferedReader(reader);
            try {
                if(!br.ready())
                {
                    System.out.println("BufferredReader dosyadaki verileri okumadı ve değer null döndü");
                    return null;
                }
            } catch (IOException ex) {
                Logger.getLogger(TextileProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] lines = br.lines().toArray();
            //Eğer dosyanın içi boşsa null değerini döndür
            
            System.out.println("Dosyadan okunan 'lines' array değeri ="+ Arrays.deepToString(lines));
            System.out.println("'lines' arrayinin uzunluğu ="+ lines.length);
            System.out.println("modelDuzenleme... görülen row sayısı = "+getRowCount);
             
           
            for (int i = 0; i <row.length-1; i++)
            {
                //Burada lines[i] nin değer row.length den küçük olduğu için
                // program hata veriyor bu yüzden bigileri okurken arrayin
                //içindeki bütün değerleri buradaki if döngüsünde okunur.
                
             row[i] = lines[i].toString().split(" ");
                
                System.out.println(Arrays.toString(row[i]));
                System.out.println(Arrays.deepToString(row));
                        
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
}