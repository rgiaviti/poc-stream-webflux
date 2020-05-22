package com.gh.rgiaviti.server.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRes implements Serializable {

  @JsonProperty("id")
  private long id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("author")
  private String author;
}
