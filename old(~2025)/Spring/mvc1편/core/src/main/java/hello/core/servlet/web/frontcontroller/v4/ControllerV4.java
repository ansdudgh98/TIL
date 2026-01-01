package hello.core.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**
     * @param paramMap
     * @parma model
     * @return viewName
     */

    String process(Map<String, String> paramMap, Map<String,Object> model);


}
