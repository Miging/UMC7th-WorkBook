package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context, MissionRepository missionRepository){
		return args -> {
//			StoreQueryService storeService=context.getBean(StoreQueryService.class);
//
//			//파라미터 값 설정
//			String name ="요아정";
//			Float score=4.0f;
//
//			//쿼리메소드 호출 및 쿼리 문자열과 파라미터 출력
//			System.out.println("Executing findStoresByNameAndScore with parameters:");
//			System.out.println("Name: " + name);
//			System.out.println("Score: " + score);
//
//			storeService.findStoresByNameAndScore(name,score)
//					.forEach(System.out::println);


			MissionQueryService missionQueryService=context.getBean(MissionQueryService.class);

			//파라미터 값 설정
			Long memberId=1L;

			//쿼리메소드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findMissionsByMemberName with parameters:");
			System.out.println("memberId: " + memberId);

			missionQueryService.findStoresByMemberId(memberId)
					.forEach(System.out::println);

		};
	}
}
