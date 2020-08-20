package f;

import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
class imgprocess{
    int width;
    int height;
    void process(String s)throws IOException
    {
        
        nu.pattern.OpenCV.loadShared();
        
        Mat source=Imgcodecs.imread(s,Imgcodecs.IMREAD_GRAYSCALE);
        Mat destination=new Mat(source.rows(),source.cols(),source.type());
        //source.convertTo(destination,-1,1,0);
        Imgproc.GaussianBlur(source,destination, new Size(0,0), 10);
        Core.addWeighted(source,1.5,destination, -0.5, 0, destination);
        //Imgproc.equalizeHist(destination, destination);
        int wid=destination.width();
        int hei=destination.height();
        this.width=wid;
        this.height=hei;
        Imgcodecs.imwrite(s,destination);
        
    }
    
}