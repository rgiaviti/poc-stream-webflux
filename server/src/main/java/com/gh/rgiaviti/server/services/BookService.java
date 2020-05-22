package com.gh.rgiaviti.server.services;

import com.gh.rgiaviti.server.api.responses.BookRes;
import com.gh.rgiaviti.server.data.domains.Book;
import com.gh.rgiaviti.server.data.repositories.BookReactiveRepository;
import com.github.javafaker.Faker;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

  private final BookReactiveRepository bookRepository;
  private final Faker faker;

  public Flux<BookRes> subscribe() {
    return this.bookRepository.findWithTailableCursorBy()
        .doOnTerminate(() -> log.info("Terminate of Book Streaming"))
        .map(book ->
        {
          log.info("Transforming Book...");
          return new BookRes(book.getId().getTimestamp(), book.getTitle(), book.getAuthor());
        });
  }


  public void add(@NonNull final Book book) {
    log.info("Adding a new book...");
    this.bookRepository.save(book).subscribe();
  }

  public void addRandomBook() {
    log.info("Generating a random book...");
    this.bookRepository.save(new Book(faker.book().title(), faker.book().author())).subscribe();
  }
}
