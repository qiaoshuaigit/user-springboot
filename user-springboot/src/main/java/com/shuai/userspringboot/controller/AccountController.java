package com.shuai.userspringboot.controller;

import com.shuai.userspringboot.condition.ConditionInBean;
import com.shuai.userspringboot.model.Account;
import com.shuai.userspringboot.model.User;
import com.shuai.userspringboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shuaion 2017/11/5
 **/
//@ConditionInBean(User.class)
@ConditionalOnBean(User.class)
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @ResponseBody
    @RequestMapping("/save")
    public String saveAccount(@RequestParam("name") String name, @RequestParam("money") String money){
        accountService.insert(name, money);
        return "success";
    }

    @RequestMapping("/toView")
    public String toView(Model model){
        model.addAttribute("data","hello world");
        return "index";
    }

    @RequestMapping("/getAccounts")
    @ResponseBody
    public List<Account> getAccounts(){
        return accountService.getAllAccount();
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object update(String money,int id) {
        int t = accountService.update(money, id);
        return t;
    }

    @RequestMapping("/getAccountsByPage")
    @ResponseBody
    public List<Account> getAccountsByPage(int pageNum,int pageSize){
        return accountService.getAccountByPage(pageNum,pageSize);
    }
}
