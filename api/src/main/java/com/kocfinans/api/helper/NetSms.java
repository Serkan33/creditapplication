package com.kocfinans.api.helper;

import org.springframework.stereotype.Component;

@Component
public class NetSms implements Sms {

    @Override
    public void sendSms(String phone, String messageBody) {
        System.out.println(phone +" numaraya sms gönderiliyor...");
        try {
            Thread.sleep(2000);
            System.out.println("Sms gönderildi");
            System.out.println("Sms içeriği: "+messageBody);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
