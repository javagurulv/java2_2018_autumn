package lv.javaguru.java2.console.services.products.add.validation.rules;

import lv.javaguru.java2.console.services.ShoppingListError;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EmptyTitleRuleTest {

    private EmptyTitleRule rule = new EmptyTitleRule();

    @Test
    public void shouldReturnErrorWhenTitleIsEmpty() {
        Optional<ShoppingListError> errorOpt = rule.execute("");
        assertEquals(errorOpt.isPresent(), true);
        assertEquals(errorOpt.get().getField(), "title");
        assertEquals(errorOpt.get().getDescription(), "Empty title not allowed");
    }

    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        Optional<ShoppingListError> errorOpt = rule.execute(null);
        assertEquals(errorOpt.isPresent(), true);
        assertEquals(errorOpt.get().getField(), "title");
        assertEquals(errorOpt.get().getDescription(), "Empty title not allowed");
    }

    @Test
    public void shouldNotReturnErrorWhenTitleNotEmpty() {
        Optional<ShoppingListError> errorOpt = rule.execute("title");
        assertEquals(errorOpt.isPresent(), false);
    }

}