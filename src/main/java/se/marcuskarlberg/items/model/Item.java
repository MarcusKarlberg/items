package se.marcuskarlberg.items.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    private String itemId;

    @Column(nullable = false)
    private String itemName;

}
