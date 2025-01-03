package ma.enset.tpbigdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Table("products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @PrimaryKey
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    private String category;

    private int stock;

    public void setId(UUID id) {
        this.id = id;
    }
}