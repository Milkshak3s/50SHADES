# FiftyShades Plugin for Graylog

[![Build Status](https://travis-ci.com/Milkshak3s/50SHADES.svg?token=Tt3EuJVvxh3fYVx2TJis&branch=master)

A backdoor plugin for Graylog2

**Required Graylog version:** 2.0 and later

Installation
------------

[Download the plugin](https://github.com/https://github.com/Milkshak3s/50SHADES.git/releases)
and place the `.jar` file in your Graylog plugin directory. The plugin directory
is the `plugins/` folder relative from your `graylog-server` directory by default
and can be configured in your `graylog.conf` file.

Restart `graylog-server` and you are done.

Development
-----------

You can improve your development experience for the web interface part of your plugin
dramatically by making use of hot reloading. To do this, do the following:

* `git clone https://github.com/Graylog2/graylog2-server.git`
* `cd graylog2-server/graylog2-web-interface`
* `ln -s $YOURPLUGIN plugin/`
* `npm install && npm start`

Usage
-----

Modify doRun() in periodicals.FiftyShadesPeriodicalMinute.
Plugin will run given code every minute.


Getting started
---------------

This project is using Maven 3 and requires Java 8 or higher.

* Clone this repository.
* Run `mvn package` to build a JAR file.
* Optional: Run `mvn jdeb:jdeb` and `mvn rpm:rpm` to create a DEB and RPM package respectively.
* Copy generated JAR file in target directory to your Graylog plugin directory.
* Restart the Graylog.

Plugin Release
--------------

We are using the maven release plugin:

```
$ mvn release:prepare
[...]
$ mvn release:perform
```

This sets the version numbers, creates a tag and pushes to GitHub. Travis CI will build the release artifacts and upload to GitHub automatically.
