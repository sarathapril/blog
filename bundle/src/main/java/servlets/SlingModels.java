package servlets;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import sling.models.ResourceValues;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@SlingServlet(paths = "/bin/slingmodel", methods = "GET")
public class SlingModels extends SlingAllMethodsServlet {

    @Reference
    ResourceResolverFactory resourceResolverFactory;
    ResourceResolver resourceResolver;

    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        try {
            resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
            Resource resource = resourceResolver.getResource("/content/testsling/slingmodel");
            ValueMap valueMap = resource.adaptTo(ValueMap.class);
            out.print("Output from ValueMap is First Name: " + valueMap.get("firstName").toString() + " Last Name: " + valueMap.get("lastName").toString());
            ResourceValues resourceValues = resource.adaptTo(ResourceValues.class);
            out.print("Output from Sling Model is First Name: " + resourceValues.getFirstName() + " Last Name: " + resourceValues.getLastName() + " Technology: " + resourceValues.getFullName());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resourceResolver.isLive())
                resourceResolver.close();
        }
    }
}