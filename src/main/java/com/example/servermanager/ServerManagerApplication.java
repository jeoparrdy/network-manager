package com.example.servermanager;

import com.example.servermanager.enumeration.Status;
import com.example.servermanager.model.Server;
import com.example.servermanager.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepository serverRepository){
        return args -> {
            serverRepository.save(new Server(null, "10.1.180.230","Ubuntu Linux Server","proxy server","http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
            serverRepository.save(new Server(null, "10.1.180.231","Windows 2008 Server","file server","http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
            serverRepository.save(new Server(null, "10.1.180.214","Windows 2012 Server","SCADA server","http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
            serverRepository.save(new Server(null, "10.1.180.215","Windows 2012 Server","BackUp server","http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
        };
    }
}
