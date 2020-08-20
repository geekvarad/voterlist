package f;

import java.util.*;

import net.sourceforge.tess4j.TesseractException;

import java.io.*;
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args)throws TesseractException,IOException
    {
        
        pdftoimg obj=new pdftoimg();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter File Directory Path");
        String path=sc.nextLine();
        System.out.println("Enter output Directory+name");
        String opath=sc.nextLine();
        int np=obj.image(path);
        tessfil tes=new tessfil();
        tes.tesst(np);
        hind hi=new hind();
        hi.hindi(opath+".csv",np);
           
       
        sc.close();
        
    }
}
