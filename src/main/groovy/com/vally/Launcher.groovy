package com.vally
import discord4j.core.DiscordClient
import discord4j.core.event.domain.lifecycle.ReadyEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Launcher {
    public static Logger logger = LoggerFactory.getLogger("Bot-Discord4J");
    static void main(final String[] args) {
        DiscordClient discord = DiscordClient.create()
            .gateway()
            .withGateway( { client ->
                client.on(ReadyEvent.class)
                    .doOnNext({ready ->
                        logger.info("Sharding has connected with success!")
                    })
                    .then()
            })
            .block();
    }
}
