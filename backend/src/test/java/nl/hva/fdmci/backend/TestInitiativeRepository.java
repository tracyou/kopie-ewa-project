package nl.hva.fdmci.backend;

import nl.hva.fdmci.backend.models.Initiative;
import nl.hva.fdmci.backend.repositories.InitiativeRepository;
import nl.hva.fdmci.backend.repositories.InitiativeRepositoryInterface;
import nl.hva.fdmci.backend.rest.InitiativeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestInitiativeRepository {

  InitiativeRepository repository = new InitiativeRepository(new ArrayList<>());

  @Autowired
  InitiativeRepositoryInterface repositoryInterface;

  @Autowired
  InitiativeController controller;


  @Test
  void testAddIniative() {
    Initiative initiative = new Initiative(4, "Amsterdam", "Getting Technical Support", "29-01-2012",
      "not selected", "selected", "selected", "not selected", "selected",
      "example 1", "example 2", "example 3", "Radio 1", "Radio 2",
      "Radio 3", "Radio 4", "tracy@gmail.com", "0612345678", "tracy.nl",
      "Tracy", "selected theme", "noord-holland", "random zip");

    repository.save(initiative);
    assertNotNull(initiative);
    repository.findAll();
    assertEquals(4, initiative.getId());
  }

  @Test
  void getInitiative() {
    controller.getAllInitiatative();
    assertNotNull(controller.getAllInitiatative().toString());
  }

  @Test
  void getInitiativeDatabase(){
    repositoryInterface.findAll();
    assertEquals("[]", repositoryInterface.findAll().toString());
  }

}
