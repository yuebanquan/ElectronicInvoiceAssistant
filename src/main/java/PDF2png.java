import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PDF2png {
    //可自由确定起始页和终止页
    public static void pdf2png(String fileAddress, String filename, int indexOfStart, int indexOfEnd) {
        //验证文件是否为pdf
        if (filename.indexOf("pdf") == -1) {
            return;
        }
        // 将pdf装图片 并且自定义图片得格式大小
        File file = new File(fileAddress + JudgeSystem.getseparatrix() + filename);
        try {
            PDDocument doc = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = indexOfStart; i < indexOfEnd; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 144); // Windows native DPI
                // BufferedImage srcImage = resize(image, 240, 240);//产生缩略图
                new File(fileAddress + JudgeSystem.getseparatrix() + "截图").mkdirs();//新建文件夹
                ImageIO.write(image, "PNG", new File(fileAddress + JudgeSystem.getseparatrix() + "截图" + JudgeSystem.getseparatrix() + filename + "_" + (i + 1) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //转换全部的pdf
    public static void pdf2png(String fileAddress, String filename) {
        //验证文件是否为pdf
        if (filename.indexOf("pdf") == -1) {
            return;
        }
        // 将pdf装图片 并且自定义图片得格式大小
        File file = new File(fileAddress + JudgeSystem.getseparatrix() + filename);
        try {
            PDDocument doc = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 144); // Windows native DPI
                // BufferedImage srcImage = resize(image, 240, 240);//产生缩略图
                new File(fileAddress + JudgeSystem.getseparatrix() + "截图").mkdirs();//新建文件夹
                ImageIO.write(image, "PNG", new File(fileAddress + JudgeSystem.getseparatrix() + "截图" + JudgeSystem.getseparatrix() + filename + "_" + (i + 1) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
