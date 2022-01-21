package com.example.servermanager.service.impl;

import com.example.servermanager.enumeration.Status;
import com.example.servermanager.model.Server;
import com.example.servermanager.repository.ServerRepository;
import com.example.servermanager.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import static com.example.servermanager.enumeration.Status.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {
    private final ServerRepository serverRepo;

    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageURL());
        return serverRepo.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        return null;
    }

    @Override
    public Server get(Long id) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private String setServerImageURL() {
        return null;
    }
}
