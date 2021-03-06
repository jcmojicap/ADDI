package co.com.addi.infrastructure.nationalregistry;

import co.com.addi.domain.entities.Client;
import co.com.addi.domain.repositories.IRegistryNational;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
public class RegisterNational implements IRegistryNational {

    // Method to simulate the response if the data of any client that is in the National Registry Identification
    // match with the information in the local database
    // it just return true or false with a random approach
    @Override
    public boolean validateClient(Client client) {
        //Latency simulation from 2 to 6 seconds
        int sleepTime = ThreadLocalRandom.current().nextInt(2, 6);
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int validation = ThreadLocalRandom.current().nextInt(0, 2);

        boolean validationResult = String.valueOf(validation).equals("1");

        return validationResult;
    }
}
