package io.github.Luiztins1.com.portobook.pbsystem.repository;

import io.github.Luiztins1.com.portobook.pbsystem.model.Book;
import io.github.Luiztins1.com.portobook.pbsystem.model.PriceMarket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class BookTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PriceMarketRepository priceMarketRepository;

    @Test
    public void saveBook(){

        PriceMarket price = new PriceMarket();
        price.setGenre("TEsst");
        price.setPrice(BigDecimal.valueOf(17,99));

        priceMarketRepository.save(price);

        Book book = new Book();
        book.setName("Test");
        book.setAuthor("Testt");
        book.setCountry("TTest");
        book.setAge(LocalDate.of(1992, 6, 23));
        book.setPrice(BigDecimal.valueOf(25,99));
        book.setPriceMarket(price);

        bookRepository.save(book);

    }
}
