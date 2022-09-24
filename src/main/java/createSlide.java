import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.io.FileOutputStream;

public class createSlide {

    XMLSlideShow ppt;
    String picpath;
    String filepath;

    public createSlide( XMLSlideShow ppt, String picpath,String filepath) throws Exception {
        this.ppt = ppt;
        this.picpath = picpath;
        this.filepath = filepath;
    }


    public void creatingSlide(String words) throws Exception {

        int width = 1920;
        int height = 1080;

        ppt.setPageSize(new Dimension(width,height));

        XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);
        XSLFSlideLayout titleLayout = slideMaster.getLayout(SlideLayout.TITLE_ONLY);
        XSLFSlide slide1 = ppt.createSlide(titleLayout);
        XSLFTextShape title1 = slide1.getPlaceholder(0);

        title1.clearText();
        XSLFTextParagraph para = title1.addNewTextParagraph();
        XSLFTextRun run = para.addNewTextRun();
        run.setFontColor(Color.white);
        run.setFontSize(80.0);
        run.setText(words);
        title1.setAnchor(new Rectangle((width- (int) (width*0.9))/2,(height- (int) (height*0.9))/2, (int) (width*0.9), (int) (height*0.9)));


        main.setBackgroundPicture(slide1,picpath,PictureData.PictureType.JPEG);

        ppt.write(new FileOutputStream(filepath));
    }
}
