package com.ait.staffmanagement.controller;

import com.ait.staffmanagement.model.Account;
import com.ait.staffmanagement.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("")
public class AccessController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/login")
    public ModelAndView login(HttpSession session) {
        Boolean login = (Boolean) session.getAttribute("login");
        if (login == null) login = false;
        if (login) {
            return new ModelAndView("redirect:/staff");
        } else {
            return new ModelAndView("login", "account", new Account());
        }
    }

    @PostMapping("/login")
    public ModelAndView getLogin(@ModelAttribute("account") Account account,
                                 RedirectAttributes redirectAttributes, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Account> accountOptional = accountService.findByUsernameAndPassword(account.getUsername(), account.getPassword());
        if (accountOptional.isPresent()) {
                session.setAttribute("account", accountOptional.get());
                session.setAttribute("login", true);
                modelAndView.setViewName("redirect:/staff");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Something is Wrong");
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("login");
        session.removeAttribute("account");
        return new ModelAndView("redirect:/login");
    }

}
