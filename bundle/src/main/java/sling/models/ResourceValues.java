package sling.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Filter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.Servlet;
import java.util.List;

@Model(adaptables = Resource.class)
public class ResourceValues {

    @Inject
    @Named("name")
    private String firstName;

    @Inject
    @Default(values = "Chauhan") /*  Default only works with @Inject annotation. */
    private String lastName;

    @Optional
    private String fullName;


    /* Child List injection works after Sling version 1.0.6. According to the sling documentationa*/

    @Inject
    private List<Resource> childs;


    public List<Resource> getChilds() {
        return childs;
    }

    public void setChilds(List<Resource> childs) {
        this.childs = childs;
    }

    @PostConstruct
    protected void sayHello() {
        System.out.println("post construct is working");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    /*@PostConstruct
    protected void sayHello() {
        System.out.println("post construct is working");
    }*/
}