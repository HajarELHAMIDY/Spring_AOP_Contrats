package com.glsid.contrats;

import java.util.Date;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.glsid.contrats.aspects.ApplicationContext;
import com.glsid.contrats.dao.ContratRepository;
import com.glsid.contrats.entities.Contrat;

@SpringBootApplication
public class ContratsApplication {

    public static void main(String[] args) {
        ApplicationContext.authenticateUser("admin","admin",new String[]{"ADMIN"});
        SpringApplication.run(ContratsApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ContratRepository contratRepository){
        return args -> {
            contratRepository.save(new Contrat(null,"Contrat 1",new Date(),1+new Random().nextDouble(),"Hajar","BK667311"));
            contratRepository.save(new Contrat(null,"Contrat 2",new Date(),1+new Random().nextDouble(),"Fatima","MK667312"));
            contratRepository.save(new Contrat(null,"Contrat 3",new Date(),1+new Random().nextDouble(),"mehdi","BK557487"));
        };
    }

}

