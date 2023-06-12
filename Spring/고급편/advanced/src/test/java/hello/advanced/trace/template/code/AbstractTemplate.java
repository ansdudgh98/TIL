package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        Long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        call();
        //비즈니스 로직 종료
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

    protected abstract void call();
}
