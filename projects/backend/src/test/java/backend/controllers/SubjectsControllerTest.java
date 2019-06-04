package backend.controllers;

import backend.domain.Subject;
import backend.service.SubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(SubjectsController.class)
public class SubjectsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SubjectService subjectService;

  @MockBean
  private ModelMapper modelMapper;

  @Test
  public void shouldReturnAllSubjects() throws Exception {
    List<Subject> subjects = List.of(new Subject(), new Subject());
    when(subjectService.getSubjects()).thenReturn(subjects);

    mockMvc.perform(get("/subjects"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$", hasSize(2)));
  }

}
