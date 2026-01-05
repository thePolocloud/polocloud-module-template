package com.example

import dev.httpmarco.polocloud.agent.Agent
import dev.httpmarco.polocloud.shared.events.definitions.service.ServiceChangeStateEvent
import dev.httpmarco.polocloud.shared.module.PolocloudModule
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

val logger: Logger = LogManager.getLogger()

class MyModule : PolocloudModule {

    override fun onEnable() {
        Agent.eventProvider().subscribe(ServiceChangeStateEvent::class.java) { event ->
            logger.info("[MyModule] Service '${event.service.name()}' changed his state to '${event.service.state}'")
        }
    }

    override fun onDisable() {
        logger.info("[MyModule] Good bye!")
    }

}