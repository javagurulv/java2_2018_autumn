package lv.javaguru.java2.services.add.validation.rules;

import lv.javaguru.java2.services.Error;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EmptyTitleRuleTest {

    private EmptyTitleRule rule = new EmptyTitleRule();

    @Test
    public void shouldReturnErrorWhenTitleIsEmpty() {
        Optional<Error> errorOpt = rule.execute("");
        assertEquals(errorOpt.isPresent(), true);
        assertEquals(errorOpt.get().getField(), "title");
        assertEquals(errorOpt.get().getDescription(), "Empty title not allowed");
    }

    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        Optional<Error> errorOpt = rule.execute(null);
        assertEquals(errorOpt.isPresent(), true);
        assertEquals(errorOpt.get().getField(), "title");
        assertEquals(errorOpt.get().getDescription(), "Empty title not allowed");
    }

    @Test
    public void shouldNotReturnErrorWhenTitleNotEmpty() {
        Optional<Error> errorOpt = rule.execute("title");
        assertEquals(errorOpt.isPresent(), false);
    }

}