package ajaxcore;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class BasicView {
     
    private String text;
 
    public String getText() {
        return text;
    }
    public void setText(String text) {
    	System.out.println(text);
        this.text = text;
    }
}
