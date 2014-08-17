package ajaxcore;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@RequestScoped
public class PollView implements Serializable {
     
    private int number;
    @PostConstruct
    public void init(){
    	System.out.println("initial");
    }
    public PollView(){
    	System.out.println("consinitial");
    }
    
    public int getNumber() {
        return number;
    }
 
    public void increment() {
        number++;
    }
}