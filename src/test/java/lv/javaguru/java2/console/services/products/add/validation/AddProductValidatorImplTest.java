package lv.javaguru.java2.console.services.products.add.validation;

import lv.javaguru.java2.console.services.ShoppingListError;
import lv.javaguru.java2.console.services.products.add.AddProductRequest;
import lv.javaguru.java2.console.services.products.add.validation.rules.DuplicateProductTitleRule;
import lv.javaguru.java2.console.services.products.add.validation.rules.EmptyTitleRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AddProductValidatorImplTest {

    @Mock
    private EmptyTitleRule emptyTitleRule;

    @Mock
    private DuplicateProductTitleRule duplicateProductTitleRule;

    @InjectMocks
    private AddProductValidator validator = new AddProductValidatorImpl();

    @Test
    public void shouldReturnCollectAndReturnErrors() {
        Mockito.when(emptyTitleRule.execute("milk"))
                .thenReturn(Optional.of(new ShoppingListError("title", "des")));

        Mockito.when(duplicateProductTitleRule.execute("milk"))
                .thenReturn(Optional.of(new ShoppingListError("title", "duplicate")));

        List<ShoppingListError> errors = validator.validate(
                new AddProductRequest("milk", "desc")
        );

        assertEquals(errors.size(), 2);
    }

}