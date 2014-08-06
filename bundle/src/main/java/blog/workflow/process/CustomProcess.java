package blog.workflow.process;


import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, enabled = true, metatype = false)
@Service
@Properties({
        @Property(name = "service.description", value = "Service for Showing custom workflow demo."),
        @Property(name = "service.vendor", value = "versatileankur@blogspot.in"),
        @Property(name = "process.label", value = "Blog Process")
})
public class CustomProcess implements WorkflowProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        LOGGER.info("\n\n\n\n=============== Custom workflow Creation completed successfully. \n thanks for creation");
        LOGGER.info("\n\n\n\n==============="+metaDataMap.get("PROCESS_ARGS", new String()));
        LOGGER.info("\n\n\n\n==============="+metaDataMap);

    }
}
