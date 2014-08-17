package intialTestBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean(name = "counterView", eager = true)
@ViewScoped
public class CounterView implements Serializable {
     
    private int number;
 
    public int getNumber() {
        return number;
    }
 
    public void increment() {
        number++;
        
    }
}