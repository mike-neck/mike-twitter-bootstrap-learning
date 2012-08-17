package org.mikeneck.grenail

import org.eclipse.jetty.server.Server

class WebServer {

    static Configuration configuration = new Configuration(
            port: 4400,
            root: '.',
            address: 'localhost')

    static WebServer webServer

    Server server

    static def configure (Map configuration) {
        Configuration.ITEMS.each {
            if (configuration[it]) {
                WebServer."${it}" = configuration[it]
            }
        }
    }

    static def configure (Configuration conf) {
        configuration = conf
    }

    static synchronized def start () {
        def inetAddress = configuration.inetAddress
        webServer = new WebServer(server: new Server(inetAddress))
    }

    static synchronized def stop () {

    }

    static int getPort () {
        configuration.port
    }

    static def setPort (int port) {
        configuration.port = port
    }

    static String getRoot () {
        configuration.root
    }

    static def setRoot (String root) {
        configuration.root = root
    }

    static String getAddress () {
        configuration.address
    }

    static def setAddress(String address) {
        configuration.address = address
    }
}
