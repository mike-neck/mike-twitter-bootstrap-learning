package org.mikeneck.grenail

import spock.lang.Specification

class WebServerSpec extends Specification {

    def 'verify properties on normal state' () {
        expect :
        WebServer."${key}" == value

        where :
        key             |         value
        'port'          |          4400
        'root'          |           '.'
        'address'       |   'localhost'
    }

    def 'configure with map' () {
        setup :
        def originalValue = WebServer."${key}"
        def map = [:]
        map[key] = value
        WebServer.configure(map)

        expect :
        WebServer."${key}" == value
        WebServer."${otherKey}" == otherValue

        cleanup :
        WebServer."${key}" == originalValue

        where :
        key       |           value | otherKey  |    otherValue
        'port'    |            8080 | 'root'    |           '.'
        'root'    |       'product' | 'address' |   'localhost'
        'address' |  '192.168.1.10' | 'port'    |          4400
    }

    def 'configure with Configuration' () {
        setup :
        WebServer.configure(new Configuration(port: 3373, root: 'public', address: '192.168.1.1'))

        expect :
        WebServer."${key}" == value

        cleanup :
        WebServer.configure(new Configuration(port: 4400, root: '.', address: 'localhost'))

        where :
        key | value
        'port' | 3373
        'root' | 'public'
        'address' | '192.168.1.1'
    }
}
