package backend.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

  @Autowired
  private IndexController indexController;

  @Autowired
  private LectureController lectureController;

  @Autowired
  private SubjectsController subjectsController;

  @Autowired
  private UsersController usersController;

  @Test
  public void contextLoads() {
    assertThat(indexController).isNotNull();
    assertThat(lectureController).isNotNull();
    assertThat(subjectsController).isNotNull();
    assertThat(usersController).isNotNull();
  }

}
