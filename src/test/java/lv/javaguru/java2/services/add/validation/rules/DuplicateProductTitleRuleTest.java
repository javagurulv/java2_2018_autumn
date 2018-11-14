package lv.javaguru.java2.services.add.validation.rules;

import lv.javaguru.java2.database.ProductRepository;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.services.Error;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class DuplicateProductTitleRuleTest {

    private ProductRepository repository;
    private DuplicateProductTitleRule rule;

    @Before
    public void init() {
        repository = Mockito.mock(ProductRepository.class);
        rule = new DuplicateProductTitleRule(repository);
    }

    @Test
    public void shouldReturnErrorIfProductAlreadyExistInList() {
        Product product = new Product("milk");
        Mockito.when(repository.findByTitle("milk"))
                .thenReturn(Optional.of(product));

        Optional<Error> error = rule.execute("milk");

        assertEquals(error.isPresent(), true);
        assertEquals(error.get().getField(), "title");
        assertEquals(error.get().getDescription(), "Duplicate title not allowed");
    }

    @Test
    public void shouldReturnNoErrorIfProductNotExistInList() {
        Mockito.when(repository.findByTitle("milk"))
                .thenReturn(Optional.empty());

        Optional<Error> error = rule.execute("milk");

        assertEquals(error.isPresent(), false);
    }

    @Test
    public void shouldReturnNoErrorIfProductTitleIsNull() {
        Optional<Error> error = rule.execute(null);

        assertEquals(error.isPresent(), false);

        Mockito.verifyZeroInteractions(repository);
    }

}