package backend.repositories;

import backend.MongoConfiguration;
import backend.domain.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class SubjectsRepositoryTest {

  @Autowired
  private SubjectsRepository subjectsRepository;

  @Test
  public void whenFindById_thenReturnSubject() {
    Subject subject = new Subject("Maths", "key", null);
    subjectsRepository.save(subject);

    Subject found = subjectsRepository.findById(subject.getId()).orElse(null);

    assertThat(found).isNotNull();
    assertThat(found.getTopic()).isEqualTo(subject.getTopic());
    assertThat(found.getKey()).isEqualTo(subject.getKey());
    assertThat(found.getLecturer()).isEqualTo(subject.getLecturer());
  }
}
