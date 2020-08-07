import com.spire.doc.Document;
import com.spire.ms.System.Drawing.Printing.PrinterSettings;


/**
 * 测试,功能暂未实现
 */
public class PrintWord {

    public static void main(String[] args) {

        //加载Word文档
        Document document = new Document();
        document.loadFromFile("C:\\Users\\Administrator\\Desktop\\DocoumentToPrint.docx");

        //创建PrinterSettings对象
        PrinterSettings printerSettings = new PrinterSettings();

        //指定物理打印机名称
        printerSettings.setPrinterName("\\\\192.168.1.104\\HP LaserJet P1007");

        //设置打印份数
        printerSettings.setCopies((short) 1);

        //设置打印范围
        printerSettings.setFromPage(2);
        printerSettings.setToPage(4);

        //应用打印设置
        document.getPrintDocument().setPrinterSettings(printerSettings);

        //执行打印
        document.getPrintDocument().print();
    }
}