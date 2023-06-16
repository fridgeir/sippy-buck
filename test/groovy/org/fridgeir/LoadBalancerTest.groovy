package org.fridgeir

import org.fridgeir.models.Instance
import spock.lang.Specification

class LoadBalancerTest extends Specification{

    LoadBalancer balancer
    def correctAddress = "1.1.1.1"
    def incorrectAddress = "999.1.1.1"

    def setup(){
        balancer = new LoadBalancer()
    }

    def "capacity Test"() {
        given:
        def result = true
        for(def i=0; i<11; i++){
            result = balancer.register("1.1.1." + i)
        }

        expect:
        !result
    }

    def "test we can register single instance with correct address"(){
        when:
        def response = balancer.register(correctAddress)

        then:
        response
        balancer.isWorkerRegistered(correctAddress)
    }

    def "test we cannot register signle instance with incorrect address"(){
        when:
        def response = balancer.register(incorrectAddress)

        then:
        !response
        !balancer.isWorkerRegistered(correctAddress)
    }

}
