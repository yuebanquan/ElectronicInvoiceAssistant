/**
 * 对应不同系统不同文件分隔符
 * 如:
 * mac:/user/a/a.pdf
 * Windows:C:\\a\\a.pdf
 */
public class JudgeSystem {
    public static String getseparatrix() {
        //判断系统
        String osName = System.getProperty("os.name");
        String separatrix = new String("/");    //文件分隔符
        if (osName.startsWith("Mac OS")) {
            // 苹果系统
            separatrix = "/";
        } else if (osName.startsWith("Windows")) {
            // windows
            separatrix = "\\";
        } else {
            // unix or linux
            separatrix = "/";
        }
        return separatrix;
    }

}
