package hudson.plugins.deploy.tomcat;

import hudson.Extension;
import hudson.plugins.deploy.ContainerAdapterDescriptor;

import org.codehaus.cargo.container.tomcat.Tomcat8xRemoteContainer;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Tomcat 8.x
 *
 * @author soudmaijer
 */
public class Tomcat8xAdapter extends TomcatAdapter {
    private static final long serialVersionUID = -998875391401118618L;

    /**
     * Tomcat 8 support
     *
     * @param url Tomcat server location (for example: http://localhost:8080)
     * @param credentialsId tomcat manager username password credentials
     * @param context alternative context
     * @param path an alternative manager context path
     * @param context alternative context
     */
    @DataBoundConstructor
    public Tomcat8xAdapter(String url, String credentialsId, String context, String path) {
        super(url, credentialsId, context, path);
    }

    @Override
    public String getContainerId() {
        return Tomcat8xRemoteContainer.ID;
    }

    @Symbol("tomcat8")
    @Extension
    public static final class DescriptorImpl extends ContainerAdapterDescriptor {
        @Override
        public String getDisplayName() {
            return new Tomcat8xRemoteContainer(null).getName();
        }
    }
}
