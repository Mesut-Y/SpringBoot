package com.my.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledExample {

	// "saniye dakika saat gün ay haftagünü"
	//@Scheduled(cron = "0 31 16 * * *")
	//@Scheduled(cron = "*/5 * * * * *")
	public void write1To10() {
		System.out.print(new Date()+ " ");
		for(int i = 1; i<11; i++)
			System.out.print(i+" ");
		System.out.println();
	}
}
