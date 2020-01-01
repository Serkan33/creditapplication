package com.kocfinans.api.controller;

import com.kocfinans.api.helper.CalculateCredit;
import com.kocfinans.api.helper.NetSms;
import com.kocfinans.api.model.CreditApplication;
import com.kocfinans.api.model.User;
import com.kocfinans.api.service.CreditApplicationServiceImpl;
import com.kocfinans.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map> query(@RequestBody User u) {

        User user = userService.findByCitizen(u.getCitizenNumber());
        int score = user.getCreditScore();
        float monthlyIncome = u.getMonthlyIncome();
        float limit = CalculateCredit.calculate(score, monthlyIncome);
        CreditApplication creditApplication = new CreditApplication();
        creditApplication.setCreditLimit(limit);
        Map<String,Object> map = new HashMap();
        if (limit > 0) {
            creditApplication.setStatus(true);
            creditApplication.setMessage("Sayın "+u.getName()+" "+u.getLastName()+"; Kredi başvurunuz onaylanmıştır. Limitiniz "+limit+" TL olarak tanımlanmıştır.");
            map.put("status",true);
        }
        else{
            creditApplication.setMessage("Sayın "+u.getName()+" "+u.getLastName()+"; Kredi başvurunuz başarısız olmuştur.");
            creditApplication.setStatus(false);
            map.put("status",false);
        }
        user.getCreditApplications().add(creditApplication);
        userService.update(user);
        smsHelper.sendSms(user.getPhone(), creditApplication.getMessage());
        map.put("message",creditApplication.getMessage());
        return ResponseEntity.ok().body(map);
    }

    @GetMapping("application/all")
    public List<CreditApplication> findAll() {
        return creditApplicationService.findAll();
    }
}
