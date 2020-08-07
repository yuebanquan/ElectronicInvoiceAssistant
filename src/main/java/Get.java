import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.DocPicture;

import java.io.File;

public class Get {
    //截图文件地址
    String screenshotsPath;

    /**
     * 生成截图
     *
     * @param path
     */
    public static void getScreenshots(String path) {
        // get file list where the path has
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();

        for (int i = 0; i < array.length; i++) {
            PDF2png.pdf2png(path, array[i].getName(), 0, 1);
        }
    }

    /**
     * 生成文档
     *
     * @param path
     */
    public static void getDoc(String path, String saveDocPath) {
        //截图文件地址
        String screenshotsPath;
        screenshotsPath = path + JudgeSystem.getseparatrix() + "截图";
        //获取截图文件
        File file = new File(screenshotsPath);
        File[] array = file.listFiles();

        //创建Word文档
        Document document = new Document();

        //添加一个section
        Section section = document.addSection();
        //设置页边距
        section.getPageSetup().getMargins().setTop(0f);
        section.getPageSetup().getMargins().setBottom(0f);
        section.getPageSetup().getMargins().setLeft(0f);
        section.getPageSetup().getMargins().setRight(0f);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName());

            //判断是否为图片
            if (array[i].getName().indexOf("png") != -1) {
                //添加此页第一个段落
                Paragraph paragraph1 = section.addParagraph();
                //添加图片到段落
                DocPicture picture1 = paragraph1.appendPicture(screenshotsPath + JudgeSystem.getseparatrix() + array[i].getName());
                picture1.setWidth(590f);
                picture1.setHeight(380f);

                if (i % 2 == 0) {
                    //设置第一个段落的段后间距
                    paragraph1.getFormat().setAfterSpacing(80f);
                }
            }

        }
        //保存文档
        document.saveToFile(saveDocPath + JudgeSystem.getseparatrix() + "Output.docx", FileFormat.Docx);
    }
}
