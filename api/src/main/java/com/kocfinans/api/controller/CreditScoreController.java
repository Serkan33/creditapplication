package com.kocfinans.api.controller;

import com.kocfinans.api.helper.CalculateCredit;
import com.kocfinans.api.helper.NetSms;
import com.kocfinans.api.model.CreditApplication;
import com.kocfinans.api.model.User;
import com.kocfinans.api.service.CreditApplicationServiceImpl;
import com.kocfinans.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("query")
public class CreditScoreController {

    @Autowired
    private NetSms smsHelper;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CreditApplicationServiceImpl creditApplicationService;

    @PostMapping("credit/limit")
    public String query(@RequestBody User u) {
        User user = userService.findByCitizen(u.getCitizenNumber());
        int score = user.getCreditScore();
        float monthlyIncome = u.getMonthlyIncome();
        float limit = CalculateCredit.calculate(score, monthlyIncome);
        CreditApplication creditApplication = new CreditApplication();
        creditApplication.setUser(user);
        creditApplication.setCreditLimit(limit);
        if (limit > 0) {
            creditApplication.setStatus(true);
            creditApplication.setMessage(limit + " TL başvurusu alınmıştır.");
        }
        else{
            creditApplication.setMessage("Kredi limiti başvurunuz başarısız.");
            creditApplication.setStatus(false);
        }
        creditApplicationService.save(creditApplication);
        smsHelper.sendSms(user.getPhone(), creditApplication.getMessage());
        return creditApplication.getMessage();
    }

    @GetMapping("application/all")
    public List<CreditApplication> findAll() {
        return creditApplicationService.findAll();
    }
}
