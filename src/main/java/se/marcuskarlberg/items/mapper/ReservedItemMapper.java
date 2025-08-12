package se.marcuskarlberg.items.mapper;

import org.springframework.stereotype.Component;
import se.marcuskarlberg.commands.ReserveItemCommand;
import se.marcuskarlberg.items.model.ReservedItem;

@Component
public class ReservedItemMapper {
    public ReservedItemMapper() {}

    public static ReservedItem toReservedItem(ReserveItemCommand reserveItemCommand) {
        return ReservedItem.builder()
                .rentalId(reserveItemCommand.getRentalId())
                .itemId(reserveItemCommand.getItemId())
                .pickupDate(reserveItemCommand.getPickupDate())
                .returnDate(reserveItemCommand.getReturnDate())
                .returnedAt(reserveItemCommand.getReturnedAt())
                .build();
    }
}