package se.marcuskarlberg.items.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.marcuskarlberg.commands.ReserveItemCommand;

@Slf4j
@Component
@KafkaListener(topics = "${rental.commands.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
public class RentalCommandsHandler {

  @KafkaHandler
  public void handleCommand(@Payload ReserveItemCommand reserveItemCommand) {
    log.info("Received reserveItemCommand. Handling payload: {}", reserveItemCommand);
    //TODO: implement
  }
}
