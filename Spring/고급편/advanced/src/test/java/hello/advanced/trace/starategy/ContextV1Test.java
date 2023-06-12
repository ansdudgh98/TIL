package hello.advanced.trace.starategy;

import hello.advanced.trace.starategy.code.strategy.ContextV1;
import hello.advanced.trace.starategy.code.strategy.Strategy;
import hello.advanced.trace.starategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.starategy.code.strategy.StrategyLogic2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        Long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

    private void logic2() {
        Long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        ContextV1 context1 = new ContextV1(strategyLogic1);
        log.info("strategyLogic1 = {}", strategyLogic1.getClass());
        context1.execute();

        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        };

        ContextV1 context2 = new ContextV1(strategyLogic2);
        log.info("strategyLogic2 = {}", strategyLogic2.getClass());
        context2.execute();
    }

    @Test
    void strategyV3() {
        ContextV1 context1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
        context1.execute();


        ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
        context2.execute();
    }

}
