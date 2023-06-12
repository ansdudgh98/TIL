package hello.advanced.trace.starategy;

import hello.advanced.trace.starategy.code.strategy.ContextV2;
import hello.advanced.trace.starategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.starategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1(){
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스적용
     */
    @Test
    void strategyV2(){
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }

}
