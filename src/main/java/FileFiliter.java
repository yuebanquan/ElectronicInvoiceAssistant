import java.io.File;

import javax.swing.JFileChooser;

/**
 * 目录文件选择器
 */
public class FileFiliter {
    public static void main(String[] args) {
        getFile();
    }

    public static String getFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(null);
        File selectedFile = fileChooser.getSelectedFile();
        System.out.println(selectedFile.getPath());
        return selectedFile.getPath();
    }
}