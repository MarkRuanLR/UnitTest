package tw.core.generator;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.commands.InputCommand;
import tw.core.Game;
import tw.views.GameView;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Mock
    GameView gameView;
    InputCommand inputCommand;
    AnswerGenerator answerGenerator;
    Game game;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }
}

