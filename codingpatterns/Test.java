import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {


    public static void main(String[] args) {

        String str = "vmandalapu1994@gmail.com";
        Pattern pattern = Pattern.compile("\\S+");

        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());

        if (matcher.matches()) {
            System.out.println(matcher.groupCount());
//            System.out.println("Date:" + matcher.group(1));
//            System.out.println("Month:" + matcher.group(2));
            System.out.println("Full date:" + matcher.group());
        }

    }
}
