package io.github.Luiztins1.com.portobook.pbsystem.service;

import io.github.Luiztins1.com.portobook.pbsystem.model.Book;
import io.github.Luiztins1.com.portobook.pbsystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }

    public Optional<Book> updateBook(UUID id, Book details){
        return bookRepository.findById(id).map(existBook -> {
            existBook.setName(details.getName());
            existBook.setAuthor(details.getAuthor());
            existBook.setCountry(details.getCountry());
            existBook.setAge(details.getAge());
            existBook.setPrice(details.getPrice());
            existBook.setPriceMarket(details.getPriceMarket());
            return bookRepository.save(existBook);
        });
    }

    public Optional<Book> findById(UUID id){
        return bookRepository.findById(id);
    }
}
