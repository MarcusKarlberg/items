package se.marcuskarlberg.items.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import se.marcuskarlberg.items.model.Item;
import se.marcuskarlberg.items.repository.ItemRepository;

import java.util.UUID;

@Slf4j
@Configuration
public class DbConfig {
    @Bean
    CommandLineRunner init(ItemRepository itemRepository) {
        return args -> {
            itemRepository.deleteAll();
            Item savedItem1 = itemRepository.save(
                    Item.builder()
                            .itemId(UUID.randomUUID().toString())
                            .itemName("Item Name 1")
                            .build()
            );
            Item savedItem2 = itemRepository.save(
                    Item.builder()
                            .itemId(UUID.randomUUID().toString())
                            .itemName("Item Name 2")
                            .build()
            );

            log.info("Saved items on init:");
            log.info("Saved item1 id: " + savedItem1.getItemId());
            log.info("Saved item2 id: " + savedItem2.getItemId());
        };
    }
}
