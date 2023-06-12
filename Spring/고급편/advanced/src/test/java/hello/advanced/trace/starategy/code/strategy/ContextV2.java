package hello.advanced.trace.starategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
    전략을 파라미터로 전달하는 형식
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy){
        Long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        strategy.call();
        //비즈니스 로직 종료
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("result Time = {}",resultTime);
    }
}
