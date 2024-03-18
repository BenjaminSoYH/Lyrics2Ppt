import org.apache.commons.compress.utils.IOUtils;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;


import java.io.*;


public class main {

    static int width = 1920;
    static int height = 1080;
    public static void main(String[] args) throws Exception {
        XMLSlideShow ppt = new XMLSlideShow();
        String pic = "src/main/java/newbackground.png";
        String file = "src/main/java/copyfromthis.pptx";


        createSlide creation = new createSlide(ppt, pic, file);

        splicingslyrics string = new splicingslyrics();
        String[] lyrics = string.splicingslyrics();


        for (String i : lyrics) {
            creation.creatingSlide(i);
        }
    }
    static void setBackgroundPicture(XSLFSlide slide, String picturePath, PictureData.PictureType pictureType) throws Exception {
        byte[] picData = IOUtils.toByteArray(new FileInputStream(picturePath));


        XSLFPictureData pcData = slide.getSlideShow().addPicture(picData, pictureType);
        CTBackgroundProperties backgroundProperties = slide.getXmlObject().getCSld().addNewBg().addNewBgPr();
        CTBlipFillProperties blipFillProperties = backgroundProperties.addNewBlipFill();
        CTRelativeRect ctRelativeRect = blipFillProperties.addNewStretch().addNewFillRect();
        String idx = slide.addRelation(null, XSLFRelation.IMAGES, pcData).getRelationship().getId();

        CTBlip blib = blipFillProperties.addNewBlip();
        blib.setEmbed(idx);
    }

}
