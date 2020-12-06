package validator;

import collections.valid.CompositionValidator;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
    @Test
    public void validatorTest(){
        String str1 = "type=record name=name1 duration=200 artist=artist1 INSTRUMENTS=guitar,piano";

        Assert.assertFalse(CompositionValidator.isStyleValid(str1));
        Assert.assertTrue(CompositionValidator.isCompositionValid(str1));
    }
    @Test
    public void validatorTestTypes(){
        Assert.assertTrue(CompositionValidator.isTypeValid("record"));
        Assert.assertFalse(CompositionValidator.isTypeValid("RECodr"));

        Assert.assertTrue(CompositionValidator.isInstrumentsValid("guitar"));
        Assert.assertFalse(CompositionValidator.isInstrumentsValid("guiar"));
    }
}
