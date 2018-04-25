package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.views.GameView;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    @Test
    public void should_call_show_result_and_History() throws IOException, OutOfRangeAnswerException {
        GameView gameView = mock(GameView.class);
        Game game = mock(Game.class);
        InputCommand inputCommand = mock(InputCommand.class);
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);

        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        game = new Game(answerGenerator);

        GameController gameController = new GameController(game, gameView);
        Answer wrong1answer = Answer.createAnswer("1 2 4 3");
        Answer wrong2answer = Answer.createAnswer("2 1 4 3");
        Answer rightanswer = Answer.createAnswer("1 2 3 4");

        when(inputCommand.input()).thenReturn(wrong1answer).thenReturn(wrong2answer).thenReturn(rightanswer);

        gameController.play(inputCommand);

        verify(gameView, times(1)).showGameStatus("success");
        verify(gameView, times(3)).showGuessResult(any());
    }
}