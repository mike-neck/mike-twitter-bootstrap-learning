package org.mikeneck.grenail

import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.Request
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class WebHandler extends AbstractHandler {

    final File root

    WebHandler (String root) {
        this.root = new File(root)
    }

    WebHandler () {
        this.root = new File('.')
    }

    @Override
    void handle(String target,
                Request baseRequest,
                HttpServletRequest request,
                HttpServletResponse response) {

    }
}
