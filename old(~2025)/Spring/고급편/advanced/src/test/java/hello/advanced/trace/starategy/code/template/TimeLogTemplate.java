package hello.advanced.trace.starategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(CallBack callBack){
        Long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        callBack.call();
        //비즈니스 로직 종료
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("result Time = {}",resultTime);
    }


}
