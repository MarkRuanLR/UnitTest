package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.validator.InputValidator;

import static org.hamcrest.CoreMatchers.is;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    @Test
    public void should_return_true_with_input_4_numbers() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertThat(inputValidator.validate("1 2 3 4"),is(true));
    }
    @Test
    public void should_return_fales_with_input_7_numbers() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertThat(inputValidator.validate("1 2 3 4 6 7 9"),is(false));
    }
}
