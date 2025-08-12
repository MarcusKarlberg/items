package se.marcuskarlberg.items.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.marcuskarlberg.commands.ReserveItemCommand;
import se.marcuskarlberg.items.mapper.ReservedItemMapper;
import se.marcuskarlberg.items.model.ReservedItem;
import se.marcuskarlberg.items.repository.ReservedItemRepository;

@Slf4j
@Service
public class ReserveItemService {

    private ReservedItemRepository reservedItemRepository;

    public ReserveItemService(ReservedItemRepository reservedItemRepository) {
        this.reservedItemRepository = reservedItemRepository;
    }

    public void reserveItem(ReserveItemCommand reserveItemCommand) {
        ReservedItem reservedItem = ReservedItemMapper.toReservedItem(reserveItemCommand);
        //TODO: verify if item exists and is available

        log.info("Reserving item: {}", reservedItem);
        ReservedItem savedItem = reservedItemRepository.save(reservedItem);
        log.info("Item successfully reserved: {}", savedItem);
    }

    public void send() {

    }
}
