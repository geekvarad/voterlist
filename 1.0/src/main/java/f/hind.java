package f;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;


public class hind
{
    void hindi(String s,int np)throws IOException{
        
    //File file=new File("C:/Users/internet/Documents/abc.txt");    
    //Scanner sc=new Scanner(file);
    
    FileWriter fw=new FileWriter(s);
    BufferedWriter bw=new BufferedWriter(fw);
    int it=1;int j=2;int k=3;int l=1;
    bw.write("नाम,पिता का नाम/पति का नाम,मकान संख्या,आयु,लिंग,Sr.No");
   
    for(int i=1;i<=np;i++){
        File file=new File("document/pg"+i+".txt");
        Scanner sc=new Scanner(file);
    int c=0;
    while(sc.hasNextLine())
    {
        String tem=sc.nextLine();
        StringTokenizer st=new StringTokenizer(tem,":");
        if(tem.equals("changed"))
            {
                if(l==2)
                {
                    if((j-it)!=1)
                    {
                        it=it-2;
                        j=j+1;
                        k=k+1;
                    }


                }
                if(l==3)
                {
                    if((k-j)!=1)
                    {
                        it--;
                        j--;
                        k=k+2;
                    }
                }
                l++;
                if(l==4)
                l=1;
            }
        while(st.hasMoreTokens())
        {
            String t1=st.nextToken();
            
            if(t1.equals("नाम ") || t1.equals("नाम") || t1.equals("नाम ¦ ") || t1.equals("नाम ¦") || t1.equals("चास ") || t1.equals("चास") || t1.equals("चास ¦ ") || t1.equals("चीस ") || t1.equals("कास ") || t1.equals("चाम "))
            {
                bw.newLine();
                bw.write(st.nextToken()+",");
                c++;
            }
            if(t1.equals("पिता का नाम ") || t1.equals("पति का नाम ") || t1.equals("पति का नाम ¦"))
            {
                if(c==0)
                { 
                    bw.newLine();
                    if(st.hasMoreTokens())
                    bw.write(","+st.nextToken()+",");
                }
                else
                {
                    
                    bw.write(st.nextToken()+",");
                    c=0;
                    
                }
            }
            if(t1.equals("मकान संख्या") || t1.equals("मकान संख्या ")){
            if(st.hasMoreTokens())
            bw.write(st.nextToken()+",");
            else
            {
                bw.write(",");

            }
        }
            if(t1.equals("आयु ") || t1.equals("आयु"))
            {
                if(st.hasMoreTokens()){
                String temp=st.nextToken();
                if(temp.length()>=4)
                bw.write(temp.substring(0,4)+",");
                if(st.hasMoreTokens())
                bw.write(st.nextToken()+",");
                }
            else
            bw.write(",,");
                if(l==1)
            {
                bw.write(""+it);
                it=it+3;
            }
            if(l==2)
            {
                bw.write(""+j);
                j=j+3;
            }
            if(l==3){
                bw.write(""+k);
                k=k+3;
                
            }
            
               
            }
            

        }
        
    }
    sc.close();

    }
   
    bw.close();
    fw.close();
}
    }

