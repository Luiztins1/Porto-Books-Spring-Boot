package io.github.Luiztins1.com.portobook.pbsystem.service;

import io.github.Luiztins1.com.portobook.pbsystem.model.NormalEmployee;
import io.github.Luiztins1.com.portobook.pbsystem.model.PriceMarket;
import io.github.Luiztins1.com.portobook.pbsystem.repository.PriceMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PriceMarketService {

    private final PriceMarketRepository priceMarketRepository;

    @Autowired
    public PriceMarketService(PriceMarketRepository priceMarketRepository) {
        this.priceMarketRepository = priceMarketRepository;
    }

    public PriceMarket savePriceMarket(PriceMarket priceMarket){
        return priceMarketRepository.save(priceMarket);
    }

    public List<PriceMarket> findAll(){
        return priceMarketRepository.findAll();
    }

    public Optional<PriceMarket> updatePriceMarket(UUID id, PriceMarket details){
        return priceMarketRepository.findById(id).map(existPriceMarket ->{
            existPriceMarket.setGenre(details.getGenre());
            existPriceMarket.setPrice(details.getPrice());
            return priceMarketRepository.save(existPriceMarket);
        });
    }

    public Optional<PriceMarket> findById(UUID id){
        return priceMarketRepository.findById(id);
    }
}
