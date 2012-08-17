package org.mikeneck.grenail

import spock.lang.Specification

class ConfigurationSpec extends Specification {

    def 'generate InetAddress from Configuration object' () {
        given  :
        def configuration = new Configuration(port: 4400, root: 'public', address: 'localhost')
        expect :
        configuration.inetAddress == new InetSocketAddress('localhost', 4400)
    }
}
