package com.example.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication : 스프링 부트의 자동 설정, 스프링 Bean 읽기/생성
// 어노테이션이 있는 위치부터 설정을 읽기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치
@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {

		// SpringApplication.run : 내장 WAS 실행
		// 스프링부트는 언제 어디서나 같은 환경에서 스프링부트를 배포하기 위해 내장 WAS 사용을 권장
		SpringApplication.run(SpringPracticeApplication.class, args);
	}

}
