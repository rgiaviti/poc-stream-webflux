package com.gh.rgiaviti.server.data.repositories;

import com.gh.rgiaviti.server.data.domains.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookReactiveRepository extends ReactiveMongoRepository<Book, ObjectId> {

  @Tailable
  Flux<Book> findWithTailableCursorBy();
}
