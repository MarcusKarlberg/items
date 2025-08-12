package se.marcuskarlberg.items.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.marcuskarlberg.commands.ReserveItemCommand;
import se.marcuskarlberg.items.service.ReserveItemService;

@Slf4j
@Component
@KafkaListener(topics = "${rental.commands.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
public class RentalCommandsHandler {

  private ReserveItemService reserveItemService;

  public RentalCommandsHandler(ReserveItemService reserveItemService) {
    this.reserveItemService = reserveItemService;
  }

  @KafkaHandler
  public void handleCommand(@Payload ReserveItemCommand reserveItemCommand) {
    log.info(
            "Received reserveItemCommand. Handling payload for RentalId: {}. ItemId: {}",
            reserveItemCommand.getRentalId(),
            reserveItemCommand.getItemId()
    );

    reserveItemService.reserveItem(reserveItemCommand);
  }
}
