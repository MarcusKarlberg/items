package se.marcuskarlberg.items.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import se.marcuskarlberg.items.model.Item;
import se.marcuskarlberg.items.repository.ItemRepository;

import java.util.UUID;

@Configuration
public class DbConfig {
    @Bean
    CommandLineRunner init(ItemRepository itemRepository) {
        return args -> {
            itemRepository.deleteAll();
            itemRepository.save(
                    Item.builder()
                            .itemId(UUID.randomUUID().toString())
                            .itemName("Item Name 1")
                            .build()
            );
            itemRepository.save(
                    Item.builder()
                            .itemId(UUID.randomUUID().toString())
                            .itemName("Item Name 2")
                            .build()
            );
        };
    }
}
