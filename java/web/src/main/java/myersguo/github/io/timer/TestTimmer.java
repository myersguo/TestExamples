package myersguo.github.io.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by guoliangyong on 2017/5/23.
 */
public class TestTimmer {
    public final static Logger logger = LoggerFactory.getLogger(TestTimmer.class);
    public static int looper=0;

    public void execute() {
        logger.info("----------execute timer----------");
        TestTimmer.looper++;
        logger.info(TestTimmer.looper + "计划任务执行中");
    }

}
