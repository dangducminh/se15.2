package vnu.hus.min.se152.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Minh Dang
 * @created 07/12/2023 - 12:37
 */
@Aspect
@Component
@Log4j2
public class Log {

    /**
     * define format log for each function is annotated
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(vnu.hus.min.se152.logging.Logging)")
    public Object DefineLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object[] args = proceedingJoinPoint.getArgs();
        String messageLog = "request: %s; with params:%s";
        StringBuilder listParams = new StringBuilder();
        if (listParams.length()==0) listParams.append("empty");
        else
            for (Object arg : args){
                listParams.append(arg.getClass()).append(":");
                listParams.append(arg).append(", ");
            }
        //log request
        log.info(String.format(messageLog,proceedingJoinPoint.getSignature().toLongString(),listParams));
        Object object = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
            //log response
        log.info(String.format("response: %s; took: %sms",object.toString(),(end-start)));
        return object;
    }

}
