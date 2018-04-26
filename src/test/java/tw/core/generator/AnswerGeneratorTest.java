package tw.core.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.views.GameView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Test
    public void should_return_right_answer() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);

        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        Answer answer = Answer.createAnswer("1 2 3 4");
        Assert.assertEquals(answer.toString(), answerGenerator.generate().toString());
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_throw_Error() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);

        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 10");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        answerGenerator.generate();
    }
}

