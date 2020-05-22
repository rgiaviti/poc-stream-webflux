package com.gh.rgiaviti.server.jobs;

import com.gh.rgiaviti.server.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookJob {

  private final BookService bookService;

  @Scheduled(fixedRate = 4000)
  public void scheduledRandomBook() {
    this.bookService.addRandomBook();
  }
}
