import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import com.sun.xml.internal.ws.server.ServerRtException;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Thu Aug 06 16:59:16 CST 2020
 */


/**
 * 主界面
 *
 * @author yuebanquan
 */
public class MainFrame extends JFrame {
    public String filePath; //发票目录文件路径
    public String saveFilePath; //生成文档路径

    public MainFrame() {
        initComponents();
        filePath = "-1";
        saveFilePath = "-1";
        reminderTextArea.append("欢迎使用电子发票打印助手!\n");
        reminderTextArea.append("**************************************\n");
    }

    //点击"浏览"设定发票文件位置
    private void setFilePahtActionPerformed(ActionEvent e) {
        filePath = FileFiliter.getFile();
        filePathText.setText(filePath);
    }

    //点击"浏览"设定生成文档位置
    private void setSaveFilePahtActionPerformed(ActionEvent e) {
        saveFilePath = FileFiliter.getFile();
        saveFilePathText.setText(saveFilePath);
    }


    //点击"开始"
    private void okButtonActionPerformed(ActionEvent e) {

        if (filePath.equals("-1")) {    //未添加发票目录路径
            reminderTextArea.append("请添加发票目录路径!\n");
            reminderTextArea.append("**************************************\n");
        } else if (saveFilePath.equals("-1")) {   //未添加生成文档路径
            reminderTextArea.append("请添加生成文档路径!\n");
            reminderTextArea.append("**************************************\n");
        } else {
            //生成提示
            reminderTextArea.append("开始处理,生成截图......\n");

            //生成截图
            Get.getScreenshots(filePath);

            //生成提示
            reminderTextArea.append("生成截图成功!\n");
            reminderTextArea.append("截图路径为: " + filePath + JudgeSystem.getseparatrix() + "截图\n");
            reminderTextArea.append("**************************************\n");
            setForeground(Color.red);
            reminderTextArea.append("正在生成文档......\n");
            reminderTextArea.append("文档生成成功!\n");
            reminderTextArea.append("文档路径为: " + saveFilePath + "\n");
            reminderTextArea.append("**************************************\n");

            //生成文档
            Get.getDoc(filePath, saveFilePath);
        }

    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void printButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label2 = new JLabel();
        filePathText = new JTextField();
        setFilePaht = new JButton();
        scrollPane1 = new JScrollPane();
        reminderTextArea = new JTextArea();
        label1 = new JLabel();
        saveFilePathText = new JTextField();
        setSaveFilePaht = new JButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        printButton = new JButton();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("\u7535\u5b50\u53d1\u7968\u6253\u5370\u52a9\u624b");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label2 ----
                label2.setText(bundle.getString("MainFrame.label2.text"));
                label2.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));

                //---- filePathText ----
                filePathText.setEditable(false);

                //---- setFilePaht ----
                setFilePaht.setText(bundle.getString("MainFrame.setFilePaht.text"));
                setFilePaht.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });
                setFilePaht.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        setFilePahtActionPerformed(e);
                    }
                });

                //======== scrollPane1 ========
                {
                    scrollPane1.setToolTipText("\u662f");
                    scrollPane1.setViewportView(reminderTextArea);
                }

                //---- label1 ----
                label1.setText(bundle.getString("MainFrame.label1.text"));
                label1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));

                //---- saveFilePathText ----
                saveFilePathText.setEditable(false);

                //---- setSaveFilePaht ----
                setSaveFilePaht.setText(bundle.getString("MainFrame.setSaveFilePaht.text"));
                setSaveFilePaht.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        setSaveFilePahtActionPerformed(e);
                    }
                });

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .add(GroupLayout.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .add(10, 10, 10)
                                        .add(contentPanelLayout.createParallelGroup()
                                                .add(contentPanelLayout.createSequentialGroup()
                                                        .add(label1)
                                                        .addPreferredGap(LayoutStyle.RELATED)
                                                        .add(saveFilePathText, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.UNRELATED)
                                                        .add(setSaveFilePaht)
                                                        .add(0, 0, Short.MAX_VALUE))
                                                .add(contentPanelLayout.createSequentialGroup()
                                                        .add(label2)
                                                        .addPreferredGap(LayoutStyle.RELATED)
                                                        .add(filePathText)
                                                        .addPreferredGap(LayoutStyle.RELATED)
                                                        .add(setFilePaht)))
                                        .addContainerGap())
                                .add(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .add(scrollPane1, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .add(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .add(contentPanelLayout.createParallelGroup(GroupLayout.BASELINE)
                                                .add(setFilePaht)
                                                .add(label2)
                                                .add(filePathText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.RELATED)
                                        .add(contentPanelLayout.createParallelGroup(GroupLayout.BASELINE)
                                                .add(label1)
                                                .add(saveFilePathText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .add(setSaveFilePaht))
                                        .addPreferredGap(LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                                        .add(scrollPane1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- okButton ----
                okButton.setText(bundle.getString("MainFrame.okButton.text"));
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        okButtonActionPerformed(e);
                    }
                });

                //---- printButton ----
                printButton.setText(bundle.getString("MainFrame.printButton.text"));
                printButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        printButtonActionPerformed(e);
                    }
                });

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                        buttonBarLayout.createParallelGroup()
                                .add(GroupLayout.TRAILING, buttonBarLayout.createSequentialGroup()
                                        .addContainerGap(283, Short.MAX_VALUE)
                                        .add(okButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                        .add(5, 5, 5)
                                        .add(printButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
                buttonBarLayout.setVerticalGroup(
                        buttonBarLayout.createParallelGroup()
                                .add(buttonBarLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .add(buttonBarLayout.createParallelGroup()
                                                .add(okButton)
                                                .add(printButton))
                                        .addContainerGap(10, Short.MAX_VALUE))
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label2;
    private JTextField filePathText;
    private JButton setFilePaht;
    private JScrollPane scrollPane1;
    private JTextArea reminderTextArea;
    private JLabel label1;
    private JTextField saveFilePathText;
    private JButton setSaveFilePaht;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton printButton;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
