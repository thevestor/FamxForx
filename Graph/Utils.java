package Graph;

public class Utils {
	/**
     * ��ӡ��Ϣ
     * @param t
     */
    public static void log(Object t) {
        System.out.println(t);
    }
    
    /**
     * ��ӡ��Ϣ
     * @param t
     */
    public static void log(String format, Object... args) {
        String str = String.format(format, args);
        System.out.println(str);
    }
}
