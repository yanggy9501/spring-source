package com.readspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yanggy
 */
@Controller
@RequestMapping("/request")
public class RequestMappingController {

	/**
	 * 这个 httpServletRequest 不是原生的 request，否则就不能线程安全。
	 *
	 */
	@Autowired
	private HttpServletRequest httpServletRequest;

	/**
	 * todo: 目前静态资源打包存在问题，可访问，但是视图出现问题前台404
	 *
	 * @return
	 */
    @RequestMapping("/mapping")
    public ModelAndView mapping() {
        System.out.println("Request mapping controller working.");
        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("name", "kato");
        return modelAndView;
    }
}
