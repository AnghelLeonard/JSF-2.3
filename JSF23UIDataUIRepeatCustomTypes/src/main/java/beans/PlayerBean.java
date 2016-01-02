package beans;

import java.io.Serializable;
import java.util.Arrays;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PlayerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArraySet arraySet;

    public PlayerBean() {
        String players[] = {"Rafa", "Federer", "Tonga", "Novak", "Murray"};
        arraySet = new ArraySet(Arrays.asList(players));
    }

    public ArraySet getArraySet() {
        return arraySet;
    }

    public void setArraySet(ArraySet arraySet) {
        this.arraySet = arraySet;
    }    
}
