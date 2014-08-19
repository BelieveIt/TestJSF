package intialTestBean;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
   public HelloWorld() {
	  Locale browserLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	  System.out.println(browserLocale.getDisplayName());
      System.out.println("HelloWorld started!");
   }
   public String getMessage() {
      return "Hello World!";

   }
}