package theoinf;

public class VsevolodIorhov {
    public static void main(String[] args) {
        String s = "package src.theoinf;\n\npublic class VsevolodIorhov {\r\n" + //
                        "    public static void main(String[] args) {\r\n" + //
                        "        String s = %c%s%c;\r\n" + //
                        "        System.out.printf(s, 34, s, 34);\r\n" + //
                        "    }\r\n" + //
                        "}\r\n";
        System.out.printf(s, 34, s, 34);
    }
}
