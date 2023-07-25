package org.brada

import org.brada.sippy.domain.port.ItemService
import spock.lang.Specification

class ItemServiceTest extends Specification {

    ItemService service

    def setup() {
        service = new ItemService(repository)
    }

    def "test we cannot register signle instance with incorrect address"() {
        when:
        def item = service.getItem("1")

        then:
        item.name() == "name"
    }

}
