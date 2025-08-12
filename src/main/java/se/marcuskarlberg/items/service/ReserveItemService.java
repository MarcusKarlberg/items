package se.marcuskarlberg.items.service;

import org.springframework.stereotype.Service;
import se.marcuskarlberg.commands.ReserveItemCommand;

@Service
public interface ReserveItemService {
    public void reserveItem(ReserveItemCommand reserveItemCommand) throws Exception;
}
