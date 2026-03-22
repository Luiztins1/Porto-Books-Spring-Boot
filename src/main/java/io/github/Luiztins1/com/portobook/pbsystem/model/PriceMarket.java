package io.github.Luiztins1.com.portobook.pbsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "price_market")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceMarket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_price_market", nullable = false)
    private UUID id_price_market;

    @Column(name = "genre", length = 45, nullable = false)
    private String genre;

    @Column(name = "price", precision = 18, scale = 2, nullable = false)
    private BigDecimal price;

    @OneToOne(mappedBy = "priceMarket")
    private Book book;
}
