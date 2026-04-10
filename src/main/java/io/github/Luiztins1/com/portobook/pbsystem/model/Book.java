package io.github.Luiztins1.com.portobook.pbsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_book", nullable = false)
    private UUID id_book;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "country", length = 45, nullable = false)
    private String country;

    @Column(name = "age", nullable = false)
    private LocalDate age;

    @Column(name = "price", precision = 18, scale = 2, nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "book")
    private List<Author> author;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_price_market", referencedColumnName = "id_price_market")
    private PriceMarket priceMarket;


}
