package internationlization;

import java.text.DateFormat;
import java.util.Locale;

public class Example {
	    static public void main(String[] args) {
	        Locale list[] = DateFormat.getAvailableLocales();
	        for (Locale aLocale : list) {
	            System.out.println(aLocale.toString());
	        }
	    }

}
//ja_JP en_US zh_CN