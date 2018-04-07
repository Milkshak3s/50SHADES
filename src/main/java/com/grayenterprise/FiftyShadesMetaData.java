package com.grayenterprise;

import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.Version;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 * Implement the PluginMetaData interface here.
 */
public class FiftyShadesMetaData implements PluginMetaData {
    private static final String PLUGIN_PROPERTIES = "com.grayenterprise.graylog-plugin-fifty-shades/graylog-plugin.properties";

    @Override
    public String getUniqueId() {
        return "com.grayenterprise.FiftyShadesPlugin";
    }

    @Override
    public String getName() {
        return "FiftyShades";
    }

    @Override
    public String getAuthor() {
        return "Chris Vantine <justchris.vantine@gmail.com>";
    }

    @Override
    public URI getURL() {
        return URI.create("https://github.com/https://github.com/Milkshak3s/graylog-plugin-fifty-shades.git");
    }

    @Override
    public Version getVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "version", Version.from(0, 0, 0, "unknown"));
    }

    @Override
    public String getDescription() {
        // TODO Insert correct plugin description
        return "Description of FiftyShades plugin";
    }

    @Override
    public Version getRequiredVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "graylog.version", Version.from(0, 0, 0, "unknown"));
    }

    @Override
    public Set<ServerStatus.Capability> getRequiredCapabilities() {
        return Collections.emptySet();
    }
}
