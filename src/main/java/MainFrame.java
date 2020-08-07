import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

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

    /**
     * 点击"浏览"设定发票文件位置
     *
     * @param e
     */
    private void setFilePahtActionPerformed(ActionEvent e) {
        filePath = FileFiliter.getFile();
        filePathText.setText(filePath);
    }

    /**
     * 点击"浏览"设定生成文档位置
     *
     * @param e
     */
    private void setSaveFilePahtActionPerformed(ActionEvent e) {
        saveFilePath = FileFiliter.getFile();
        saveFilePathText.setText(saveFilePath);
    }

    /**
     * 点击"开始"
     *
     * @param e
     */
    private void okButtonActionPerformed(ActionEvent e) {

        if (filePath.equals("-1") && saveFilePath.equals("-1")) {    //未添加发票目录路径或生成文档路径
            reminderTextArea.append("请添加发票目录路径和生成文档路径!\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            reminderTextArea.append("**************************************\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());
        } else {
            //生成提示
            reminderTextArea.append("开始处理,生成截图......\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            //生成截图
            Get.getScreenshots(filePath);

            //生成提示
            reminderTextArea.append("生成截图成功!\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            reminderTextArea.append("截图路径为: " + filePath + JudgeSystem.getseparatrix() + "截图\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            reminderTextArea.append("**************************************\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            reminderTextArea.append("正在生成文档......\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            reminderTextArea.append("文档生成成功!\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            reminderTextArea.append("文档路径为: " + saveFilePath + "\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            reminderTextArea.append("**************************************\n");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            //生成文档
            Get.getDoc(filePath, saveFilePath);
        }

    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    /**
     * 点击"打印"
     *
     * @param e
     */
    private void printButtonActionPerformed(ActionEvent e) {
        reminderTextArea.append("抱歉!功能暂未实现,请等待版本更新,谢谢!\n");
        reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

        reminderTextArea.append("**************************************\n");
        reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());
    }

    /**
     * 点击"作者"
     *
     * @param e
     */
    private void authorButtonActionPerformed(ActionEvent e) {
        reminderTextArea.append("作者: yuebanquan\n");
        reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

        reminderTextArea.append("GitHub: https://github.com/yuebanquan\n");
        reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

        reminderTextArea.append("Blog: https://www.yuebanquan.xyz/\n");
        reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

        reminderTextArea.append("**************************************\n");
        reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label2 = new JLabel();
        filePathText = new JTextField();
        setFilePaht = new JButton();
        label1 = new JLabel();
        saveFilePathText = new JTextField();
        setSaveFilePaht = new JButton();
        scrollPane1 = new JScrollPane();
        reminderTextArea = new JTextArea();
        authorButton = new JButton();
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

                //======== scrollPane1 ========
                {
                    scrollPane1.setToolTipText("\u662f");
                    scrollPane1.setViewportView(reminderTextArea);
                }

                //---- authorButton ----
                authorButton.setText(bundle.getString("MainFrame.authorButton.text"));
                authorButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        authorButtonActionPerformed(e);
                    }
                });

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

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .add(contentPanelLayout.createSequentialGroup()
                                        .add(contentPanelLayout.createParallelGroup()
                                                .add(GroupLayout.TRAILING, contentPanelLayout.createSequentialGroup()
                                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(contentPanelLayout.createParallelGroup()
                                                                .add(contentPanelLayout.createSequentialGroup()
                                                                        .add(label2)
                                                                        .addPreferredGap(LayoutStyle.RELATED)
                                                                        .add(filePathText, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.UNRELATED)
                                                                        .add(setFilePaht, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                                                                .add(contentPanelLayout.createSequentialGroup()
                                                                        .add(label1)
                                                                        .addPreferredGap(LayoutStyle.RELATED)
                                                                        .add(saveFilePathText, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.UNRELATED)
                                                                        .add(setSaveFilePaht, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
                                                        .add(6, 6, 6))
                                                .add(contentPanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .add(contentPanelLayout.createParallelGroup()
                                                                .add(GroupLayout.TRAILING, contentPanelLayout.createSequentialGroup()
                                                                        .add(authorButton)
                                                                        .addPreferredGap(LayoutStyle.RELATED, 200, Short.MAX_VALUE)
                                                                        .add(okButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.RELATED)
                                                                        .add(printButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                                                .add(scrollPane1, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))))
                                        .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .add(contentPanelLayout.createSequentialGroup()
                                        .add(contentPanelLayout.createParallelGroup()
                                                .add(contentPanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .add(label2))
                                                .add(contentPanelLayout.createParallelGroup(GroupLayout.BASELINE)
                                                        .add(filePathText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .add(setFilePaht)))
                                        .addPreferredGap(LayoutStyle.RELATED)
                                        .add(contentPanelLayout.createParallelGroup(GroupLayout.BASELINE)
                                                .add(setSaveFilePaht)
                                                .add(saveFilePathText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .add(label1))
                                        .addPreferredGap(LayoutStyle.RELATED)
                                        .add(scrollPane1, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.RELATED)
                                        .add(contentPanelLayout.createParallelGroup(GroupLayout.BASELINE)
                                                .add(okButton)
                                                .add(printButton)
                                                .add(authorButton)))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
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
    private JLabel label1;
    private JTextField saveFilePathText;
    private JButton setSaveFilePaht;
    private JScrollPane scrollPane1;
    private JTextArea reminderTextArea;
    private JButton authorButton;
    private JButton okButton;
    private JButton printButton;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
