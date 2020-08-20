package f;

import org.junit.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public static void main(String[] args)throws IOException,TesseractException {
        
    
        ITesseract tess=new Tesseract();
        tess.setDatapath("C:/Users/internet/Documents/voterlist/Tess4J/tessdata");
        tess.setLanguage("hin");
        tess.setPageSegMode(4);
        tess.setOcrEngineMode(2);
        tess.setTessVariable("user_defined_dpi", "100");
        File f=new File("abc.txt");
        FileWriter fw=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(tess.doOCR(new File("D:/mnproject/temp/out111"+".png")));
        bw.close();
        fw.close();

        
    }
}
