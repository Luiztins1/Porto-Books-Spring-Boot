package io.github.Luiztins1.com.portobook.pbsystem.repository;

import io.github.Luiztins1.com.portobook.pbsystem.model.PriceMarket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceMarketRepository extends JpaRepository<PriceMarket, UUID> {
}
