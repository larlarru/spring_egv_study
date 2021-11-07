package egovframework.com.cmmn.intercepter;

import java.util.ServiceConfigurationError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.sample.service.impl.EgovSampleServiceImpl;

public class CommIntercepter extends HandlerInterceptorAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommIntercepter.class);
	
	// 전처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		LOGGER.debug("저는 전처리 인터셉터 입니다.......");
		
		String id = request.getParameter("id");
		
		boolean test = false;
		if (StringUtils.isNotBlank(id)) {
			LOGGER.debug("로그인 성공");
		} else {
			LOGGER.debug("로그인 실패");
			ModelAndView modelAndView = new ModelAndView("redirect:/login.do?auth_error=1");
			throw new ModelAndViewDefiningException(modelAndView); // error 강제 발생
		}
		
		//return super.preHandle(request, response, handler);
		return true;
	}
	
	// 후처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		

		LOGGER.debug("저는 후처리 인터셉터 입니다.......");
		LOGGER.debug("저는 후처리 인터셉터 입니다.......");
		LOGGER.debug("저는 후처리 인터셉터 입니다.......");
		
		modelAndView.addObject("test", "고생하셨습니다.");
		
		//super.postHandle(request, response, handler, modelAndView);
	}
	
}
