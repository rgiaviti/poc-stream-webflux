package com.gh.rgiaviti.server.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReq implements Serializable {

  @JsonProperty(value = "title", required = true)
  private String title;

  @JsonProperty(value = "author",required = true)
  private String author;
}
