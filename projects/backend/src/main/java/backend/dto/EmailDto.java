package backend.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmailDto implements Serializable {

  private String to;
  private String subject;
  private String html;

  /**
   * Converts object to JSON.
   *
   * @return String json.
   * @throws JsonProcessingException when conversion fails.
   */
  public String toJson() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(this);

    return json;
  }
}
