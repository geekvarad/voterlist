package f;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
public class pdftoimg 
{
    
    int image(String addr)throws IOException
    {
        File pdf=new File(addr);
        PDDocument document=PDDocument.load(pdf);
        int np=document.getNumberOfPages();
        PDFRenderer pdr=new PDFRenderer(document);
        for(int i=1;i<=np;i++)
        {
            File output=new File("png/outpt"+"_"+i+".png");
            BufferedImage bImage=pdr.renderImageWithDPI(i-1,600,ImageType.GRAY);
            ImageIO.write(bImage,"png", output);
            

        }
        document.close();
        
        return np;

    }

    
}