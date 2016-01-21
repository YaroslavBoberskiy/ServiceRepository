/**
 * Created by YB on 21.01.2016.
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class SRServicesTests {

    private ServiceRepository serviceRepository;
    private Servicable servicable;

    @Before
    public void init () {
        serviceRepository = new ServiceRepository();
        servicable = new Servicable() {
            @Override
            public String read() {
                return null;
            }

            @Override
            public void write(String str) {

            }

            @Override
            public boolean analyze(Object obj) {
                return false;
            }
        };
    }
    @Test
    public void checkServiceRepoIsEmpty () {
        assertTrue("Service repo isn't empty", serviceRepository.getServices().isEmpty());
    }

    @Test
    public void checkAddingService () {

        int beforeSize = serviceRepository.getServices().size();
        boolean isIncreasing;
        serviceRepository.addService(servicable);

        if (beforeSize+1 == serviceRepository.getServices().size()) {
            isIncreasing = true;
        } else {
            isIncreasing = false;
        }
        assertTrue(isIncreasing);
    }

    @Test
    public void checkRemovingService () {

        serviceRepository.addService(servicable);
        int beforeSize = serviceRepository.getServices().size();
        boolean isDecreasing;
        serviceRepository.removeService(servicable);

        if (beforeSize-1 == serviceRepository.getServices().size()) {
            isDecreasing = true;
        } else {
            isDecreasing = false;
        }
        assertTrue(isDecreasing);

    }

}
