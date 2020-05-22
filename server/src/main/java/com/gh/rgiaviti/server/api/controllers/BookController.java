package com.gh.rgiaviti.server.api.controllers;


import com.gh.rgiaviti.server.api.responses.BookRes;
import com.gh.rgiaviti.server.services.BookService;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@RestController
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping(path = "/books/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<BookRes> books() {
    return this.bookService.subscribe();
  }
}
