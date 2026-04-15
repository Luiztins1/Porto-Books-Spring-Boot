package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.PriceMarket;
import io.github.Luiztins1.com.portobook.pbsystem.service.PriceMarketService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/price_market")
@RequiredArgsConstructor
public class PriceMarketController {

    private final PriceMarketService priceMarketService;

    @PostMapping
    public ResponseEntity<PriceMarket> save(@RequestBody PriceMarket priceMarket){
        PriceMarket priceMark = priceMarket;
        priceMarketService.savePriceMarket(priceMarket);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(priceMark.getId_price_market())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<PriceMarket>> findAll(){
        List<PriceMarket> priceMarketList = priceMarketService.findAll();

        if(priceMarketList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceMarket> update(@PathVariable("id") UUID id, @RequestBody PriceMarket details){
        Optional<PriceMarket> priceMarketOptional = priceMarketService.updatePriceMarket(id, details);

        if(priceMarketOptional.isPresent()){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        priceMarketService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceMarket> findById(@PathVariable("id") UUID id){
        Optional<PriceMarket> priceMarketId = priceMarketService.findById(id);

        if(priceMarketId.isPresent()){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
