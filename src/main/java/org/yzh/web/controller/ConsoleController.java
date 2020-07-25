package org.yzh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yzh.web.config.SessionKey;
import org.yzh.web.jt.t808.T0001;

import javax.servlet.http.HttpSession;

@Controller
public class ConsoleController {

    @GetMapping("/")
    public String console(HttpSession session) {
        session.setAttribute(SessionKey.USER_ID, session.getId().hashCode());
        return "forward:/index.html";
    }

    @GetMapping("test/{terminalId}")
    @ResponseBody
    public T0001 updateParameters(@PathVariable("terminalId") String terminalId, @RequestParam String hex) {

//        T0001 response = (T0001) MessageManager.getInstance().request(hex);
//        return response;
        return null;
    }
}