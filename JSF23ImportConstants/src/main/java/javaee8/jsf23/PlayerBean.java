package javaee8.jsf23;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private PlayerEnum selectedPlayerEnum;
    public static final String NAME_C = "Rafael Nadal";

    public PlayerEnum getSelectedPlayerEnum() {
        return selectedPlayerEnum;
    }

    public void setSelectedPlayerEnum(PlayerEnum selectedPlayerEnum) {
        this.selectedPlayerEnum = selectedPlayerEnum;
    }
}
