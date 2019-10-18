package assignments;

public class ReverseString_Simple {
    public static void main(String[] args) {
        String str = "Akshay";
        String out = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            out = out + str.charAt(i);
        }
        System.out.println(out);
    }
}
