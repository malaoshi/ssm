package com.jsoft.ctrls;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.services.InfoSrv;
import com.jsoft.util.RequestTool;
import com.jsoft.util.TurnPage;

@Controller
@RequestMapping("/mgr/info")
public class InfoCtrl {

	@Resource(name="infoSrv")
	private InfoSrv infoSrv;
	
	@RequestMapping("/list")
	public ModelAndView list(@ModelAttribute("turnPage") TurnPage turnPage,HttpServletRequest req) throws Exception{
		
		ModelAndView mv=new ModelAndView();
		Map map=RequestTool.getParameterMap(req);
		map.put("turnPage", turnPage);
		
		List list=infoSrv.query(map);
		mv.addObject("list", list);
		mv.setViewName("mgr/info");
		return mv;
	}
}
