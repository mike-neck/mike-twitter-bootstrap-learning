package org.mikeneck.grenail

import spock.lang.Specification

class WebHandlerSpec extends Specification {

    static {
        File.metaClass.define {
            listFiles = { Closure<Boolean> closure ->
                def children = delegate.list()
                return children.collect {
                    if (closure(it)) return it
                } as File[]
            }
            contains = {String name ->
                delegate.listFiles { file ->
                    file == name
                }.size () > 0
            }
        }
    }

    def 'initialize test' () {
        when   :
        def handler = init

        then   :
        handler.root == file

        where  :
        init                     | file
        new WebHandler()         | new File('.')
        new WebHandler('public') | new File('public')
    }

    def 'root directory contains subdirectory' () {
        when  :
        def handler = init

        then  :
        handler.root.contains(subdirectory) == true

        where :
        init                     | subdirectory
        new WebHandler()         | 'public'
        new WebHandler('public') | 'css'
    }
}
