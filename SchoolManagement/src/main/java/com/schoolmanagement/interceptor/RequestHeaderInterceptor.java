//package com.schoolmanagement.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.schoolmanagement.exception.InvalidHeaderFieldException;
//
//
////@SuppressWarnings("deprecation")
////@Component
//public class RequestHeaderInterceptor implements HandlerInterceptor{
//	
////	@SuppressWarnings("deprecation")
////	@Override 
////	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
////
////			if (org.springframework.util.StringUtils.isEmpty(request.getHeader("student-auth-key"))) { throw new InvalidHeaderFieldException("Invalid request");
////
////			
////}
////			return super.preHandle(request, response, handler);
////	}
//	 //unimplemented methods comes here. Define the following method so that it     
//    //will handle the request before it is passed to the controller.
//
//    //@Override
//    public boolean preHandle(HttpServletRequest request,HttpServletResponse  response){
//    	if (org.springframework.util.StringUtils.isEmpty(request.getHeader("student-auth-key"))) { throw new InvalidHeaderFieldException("Invalid request");
//}
//    	return true;
//}
//}
