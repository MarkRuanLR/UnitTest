package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import static org.hamcrest.CoreMatchers.is;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    public void shouid_return_correct_number() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        Assert.assertThat(answer.getIndexOfNum("3"), is(2));
    }

    @Test
    public void shouid_pass_correct_number() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 2 3 4");
        answer.validate();
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void shouid_throw_Error_with_wrong_number() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 2 2 4");
        answer.validate();
    }

    @Test
    public void shouid_return12_with_input_1243_answer_1234() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        Answer input = Answer.createAnswer("1 2 4 3");
        Record record = answer.check(input);
        Assert.assertThat(record.getValue(),is(new int[]{2,2}));
    }

}