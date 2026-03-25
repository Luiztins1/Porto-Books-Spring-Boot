package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.PriceMarket;
import io.github.Luiztins1.com.portobook.pbsystem.service.PriceMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/price_market")
public class PriceMarketController {

    private final PriceMarketService priceMarketService;

    @Autowired
    public PriceMarketController(PriceMarketService priceMarketService) {
        this.priceMarketService = priceMarketService;
    }

    @PostMapping
    public PriceMarket save(@RequestBody PriceMarket priceMarket){
        return priceMarketService.savePriceMarket(priceMarket);
    }

    @GetMapping
    public List<PriceMarket> findAll(){
        return priceMarketService.findAll();
    }

    @PutMapping("/{id}")
    public Optional<PriceMarket> update(@PathVariable("id") UUID id, @RequestBody PriceMarket details){
        return priceMarketService.updatePriceMarket(id, details);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        priceMarketService.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<PriceMarket> findById(@PathVariable("id") UUID id){
        return priceMarketService.findById(id);
    }
}
