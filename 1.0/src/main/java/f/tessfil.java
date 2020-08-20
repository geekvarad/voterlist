package f;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class tessfil {
    void tesst(int np)throws TesseractException,IOException
    {
        ITesseract tesseract=new Tesseract();
        tesseract.setTessVariable("user_defined_dpi", "100");
        tesseract.setPageSegMode(4);
        tesseract.setOcrEngineMode(1);
        tesseract.setDatapath("tessdata");
        tesseract.setLanguage("hin");
        imgprocess obj=new imgprocess();
        for(int i=1;i<=np;i++){
            System.out.println(i);
            FileWriter fw= new FileWriter("document/pg"+i+".txt");
            BufferedWriter bw=new BufferedWriter(fw);
            obj.process("png/outpt_"+i+".png");
            int wid=obj.width;
            int hei=obj.height;
            BufferedImage bi= ImageIO.read(new File("png/outpt_"+i+".png"));
            BufferedImage tri;
            //System.out.println(wid);
            
            
            for(int j=0;j<3;j++)
            {             
                switch(j)
                {
                    case(0):
                    tri=bi.getSubimage(0, 0, wid/3-wid/10, hei);
                    //tri=Thumbnails.of(tri).size(wid/2,2*hei).asBufferedImage();
                    ImageIO.write(tri, "png",new File( "temp/out"+i+j+".png"));
                    bw.write(tesseract.doOCR(new File("temp/out"+i+j+".png")));
                    bw.newLine();
                    bw.write("changed");
                    bw.newLine();
                    break;
                    case(1):
                    tri=bi.getSubimage(wid/3+wid/100,0,wid/3-wid/10,hei);
                    //tri=Thumbnails.of(tri).size(wid/2, 2*hei).asBufferedImage();
                    ImageIO.write(tri, "png",new File( "temp/out"+i+j+".png"));
                    bw.write(tesseract.doOCR(new File("temp/out"+i+j+".png")));
                    bw.newLine();
                    bw.write("changed");
                    bw.newLine();
                    break;
                    case(2):
                    tri=bi.getSubimage(2*wid/3-wid/75,0,wid/3-wid/10,hei);
                    //tri=Thumbnails.of(tri).size(wid/2,2*hei).asBufferedImage();
                    ImageIO.write(tri, "png",new File( "temp/out"+i+j+".png"));
                    bw.write(tesseract.doOCR(new File("temp/out"+i+j+".png")));
                    bw.newLine();
                    bw.write("changed");
                    bw.newLine();
                    break;

                }
            }
            //bw.write(tesseract.doOCR(bi));            
            bw.close();
            fw.close();
        }
    }    
}