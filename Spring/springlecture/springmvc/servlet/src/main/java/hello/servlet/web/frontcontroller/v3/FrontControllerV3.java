package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerV3(Map<String, ControllerV3> controllerMap) {
        this.controllerMap.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        this.controllerMap.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        this.controllerMap.put("/front-controller/v3/members",new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerV3.service");

        //1. 컨트롤러 조회
        String requestURI = request.getRequestURI();
        //2. 컨트롤러 호출
        //*생성자로 입력되어진 url주소로 조회하고 만약 값이 존재하면은 해당 객체 반환해주는 HashMap사용
      ControllerV3 controller = controllerMap.get((requestURI));
        //존재 하지 않을시 404오류
        if(controller == null){
            System.out.println("controller null");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //paramMap


        Map<String, String> paramMap = createParamMap(request);

        //return hashmap
        //model과 viewName을 리턴
        //3.ModelView 반환
        ModelView mv = controller.process(paramMap);


        String viewName = mv.getViewName();//논리 이름 new-form
        //4,5번 코드
        MyView myView = viewResolver(viewName);

        //6번 코드
        myView.render(mv.getModel(),request,response);

    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }


    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName-> paramMap.put(paramName, request.getParameter(paramName)));
        System.out.println("-------paramName-------");
        System.out.println(request.getParameterNames());
        System.out.println("-----------------------");
        return paramMap;
    }
}
