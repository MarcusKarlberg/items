package se.marcuskarlberg.items.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.marcuskarlberg.commands.ReserveItemCommand;
import se.marcuskarlberg.events.RentalCreatedEvent;
import se.marcuskarlberg.items.mapper.ReservedItemMapper;
import se.marcuskarlberg.items.model.ReservedItem;
import se.marcuskarlberg.items.repository.ReservedItemRepository;

@Slf4j
@Service
public class ReserveItemServiceImpl implements ReserveItemService {

    private final ReservedItemRepository reservedItemRepository;

    //TODO: change to specific payload for items-reserved-events-topic?
    private final KafkaTemplate<String, ReserveItemCommand> kafkaTemplate;

    public ReserveItemServiceImpl(ReservedItemRepository reservedItemRepository, KafkaTemplate<String, ReserveItemCommand> kafkaTemplate) {
        this.reservedItemRepository = reservedItemRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public void reserveItem(ReserveItemCommand reserveItemCommand) {
        ReservedItem reservedItem = ReservedItemMapper.toReservedItem(reserveItemCommand);
        //TODO: verify if item exists and is available

        log.info("Reserving item: {}", reservedItem);
        ReservedItem savedItem = reservedItemRepository.save(reservedItem);
        log.info("Item successfully reserved: {}", savedItem);

        log.info("Sending reserved status to saga-rentals");
        //TODO: send as record
        //kafkaTemplate.send("items-reserved-events-topic", reserveItemCommand);
    }
}
