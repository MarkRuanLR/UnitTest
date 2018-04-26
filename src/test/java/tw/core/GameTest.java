package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import static org.hamcrest.CoreMatchers.is;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private Game game;
    @Mock
    AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        game = new Game(answerGenerator);
    }

    @Test
    public void should_return_guessresult_with_input() {
        GuessResult guessResult = game.guess(Answer.createAnswer("1 2 4 3"));

        Assert.assertThat(guessResult.getResult(), is("2A2B"));
    }

    @Test
    public void should_return_success_with_input3() {
        game.guess(Answer.createAnswer("1 2 4 3"));
        game.guess(Answer.createAnswer("1 2 5 3"));
        game.guess(Answer.createAnswer("1 2 3 4"));

        Assert.assertThat(game.guessHistory().size(), is(3));
        Assert.assertThat(game.checkStatus(), is("success"));
    }

    @Test
    public void should_return_fail_with_input7() {
        game.guess(Answer.createAnswer("1 2 4 3"));
        game.guess(Answer.createAnswer("1 2 5 3"));
        game.guess(Answer.createAnswer("3 4 6 7"));
        game.guess(Answer.createAnswer("3 4 6 7"));
        game.guess(Answer.createAnswer("3 4 6 7"));
        game.guess(Answer.createAnswer("3 4 6 7"));
        game.guess(Answer.createAnswer("1 2 3 4"));

        Assert.assertThat(game.guessHistory().size(), is(7));
        Assert.assertThat(game.checkStatus(), is("fail"));

    }
    @Test
    public void should_return_continue_with_input4() {
        game.guess(Answer.createAnswer("1 2 4 3"));
        game.guess(Answer.createAnswer("1 2 5 3"));
        game.guess(Answer.createAnswer("3 4 6 7"));
        game.guess(Answer.createAnswer("3 4 6 7"));

        Assert.assertThat(game.guessHistory().size(), is(4));
        Assert.assertThat(game.checkStatus(), is("continue"));

    }

}
