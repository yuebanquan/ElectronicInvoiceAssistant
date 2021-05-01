import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;
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
            //关闭各个按钮
            okButton.setEnabled(false);     //关闭"开始"按钮
            printButton.setEnabled(false);  //关闭"打印"按钮
            authorButton.setEnabled(false); //关闭"作者"按钮
            setFilePaht.setEnabled(false); //关闭"浏览"按钮
            setSaveFilePaht.setEnabled(false); //关闭"浏览"按钮
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   //恢复关闭

            //生成提示
            reminderTextArea.append("开始处理,生成截图......\n" +
                    "请勿进行其他操作！！！");
            reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

            //防止UI假死
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    //生成截图
                    Get.getScreenshots(filePath);
                    //生成提示
                    reminderTextArea.append("生成截图成功!\n" +
                            "截图路径为: " + filePath + JudgeSystem.getseparatrix() + "截图\n" +
                            "**************************************\n" +
                            "正在生成文档......\n" +
                            "请勿进行其他操作！！！");
                    reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

                    //生成文档
                    Get.getDoc(filePath, saveFilePath);

                    //生成提示
                    reminderTextArea.append("文档生成成功!\n" +
                            "文档路径为: " + saveFilePath + "\n" +
                            "**************************************\n"
                    );
                    reminderTextArea.setCaretPosition(reminderTextArea.getDocument().getLength());

                    //开启各个按钮
                    okButton.setEnabled(true);     //关闭"开始"按钮
                    printButton.setEnabled(true);  //关闭"打印"按钮
                    authorButton.setEnabled(true); //关闭"作者"按钮
                    setFilePaht.setEnabled(true); //关闭"浏览"按钮
                    setSaveFilePaht.setEnabled(true); //关闭"浏览"按钮
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }.start();

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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭有效

        //======== this =====setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);//关闭有效==
        setTitle("\u7535\u5b50\u53d1\u7968\u52a9\u624b");
        setResizable(false);
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
                setFilePaht.addActionListener(e -> setFilePahtActionPerformed(e));

                //---- label1 ----
                label1.setText(bundle.getString("MainFrame.label1.text"));
                label1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));

                //---- saveFilePathText ----
                saveFilePathText.setEditable(false);

                //---- setSaveFilePaht ----
                setSaveFilePaht.setText(bundle.getString("MainFrame.setSaveFilePaht.text"));
                setSaveFilePaht.addActionListener(e -> setSaveFilePahtActionPerformed(e));

                //======== scrollPane1 ========
                {
                    scrollPane1.setToolTipText("\u662f");
                    scrollPane1.setViewportView(reminderTextArea);
                }

                //---- authorButton ----
                authorButton.setText(bundle.getString("MainFrame.authorButton.text"));
                authorButton.addActionListener(e -> authorButtonActionPerformed(e));

                //---- okButton ----
                okButton.setText(bundle.getString("MainFrame.okButton.text"));
                okButton.addActionListener(e -> okButtonActionPerformed(e));

                //---- printButton ----
                printButton.setText(bundle.getString("MainFrame.printButton.text"));
                printButton.addActionListener(e -> printButtonActionPerformed(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                        .addComponent(label2)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(filePathText, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(setFilePaht, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                        .addComponent(label1)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(saveFilePathText, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(setSaveFilePaht, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(6, 6, 6))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                                        .addComponent(authorButton)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                                                                        .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(printButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))))
                                        .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(label2))
                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(filePathText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(setFilePaht)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(setSaveFilePaht)
                                                .addComponent(saveFilePathText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label1))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(okButton)
                                                .addComponent(printButton)
                                                .addComponent(authorButton)))
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
