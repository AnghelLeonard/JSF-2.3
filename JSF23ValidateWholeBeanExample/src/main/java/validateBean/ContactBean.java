package validateBean;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
@ValidContact(groups = validateBean.ContactGroup.class)
public class ContactBean implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    @Size(min = 3, max = 20, message = "Please enter a valid name (between 3-20 characters)!", groups = validateBean.ContactGroup.class)
    private String name;

    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Please enter a valid formated e-mail !", groups = validateBean.ContactGroup.class)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     @Override
    protected Object clone() throws CloneNotSupportedException {
        ContactBean other = (ContactBean) super.clone();
        other.setName(this.getName());
        other.setEmail(this.getEmail());
        return other;
    }

}
