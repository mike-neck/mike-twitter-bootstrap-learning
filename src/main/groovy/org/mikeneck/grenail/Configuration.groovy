package org.mikeneck.grenail

class Configuration {

    final static def ITEMS = ['port', 'root', 'address']

    int port

    String root

    String address

    InetSocketAddress getInetAddress () {
        new InetSocketAddress(address, port)
    }
}
