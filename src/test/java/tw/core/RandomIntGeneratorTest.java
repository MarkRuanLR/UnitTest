package tw.core;


import org.junit.Assert;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.hamcrest.CoreMatchers.is;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    @Test
    public void should_return_right_RandomNumber() {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        String first = randomIntGenerator.generateNums(9,4);
        String second = randomIntGenerator.generateNums(9,4);
        Assert.assertThat(first.equals(second),is(false));
    }
}