package com.home.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.home.books")
public class BooksApplication implements CommandLineRunner{

	@Autowired
	BookLibraryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}*/


	@Override
	public void run(String... args) throws Exception {

		System.out.println("JPA Runner: ");

		Iterable<BookLibrary> iterator = repository.findAll();
		System.out.println("All expense items: ");
		iterator.forEach(item -> System.out.println(item));

//		repository.save(new BookLibrary("1001", "The Mahabharata"));
		/*Optional<BookLibrary> optionalBookLibrary= repository.findById("bk1TnHgMT");
		if(optionalBookLibrary.isPresent())
		{
			System.out.println(optionalBookLibrary.get().getBook_name());
		}*/

		System.out.println("JPA End");


	}
}
