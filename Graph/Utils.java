package Graph;

public class Utils {
	/**
     * 打印信息
     * @param t
     */
    public static void log(Object t) {
        System.out.print(t);
    }
    
    /**
     * 打印信息
     * @param t
     */
    public static void log(String format, Object... args) {
        String str = String.format(format, args);
        System.out.print(str);
    }
}
