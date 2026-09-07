package br.unesp.moisesolimpio.springjpatutorial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.unesp.moisesolimpio.springjpatutorial.entity.Fisica;
import br.unesp.moisesolimpio.utils.InstanceGenerator;

@SpringBootApplication
public class SpringjpatutorialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringjpatutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Fisica entity = InstanceGenerator.getPessoaFisica("111.222.333-44", "user1");
		System.out.println("\n" + entity + "\n");
	}

}
