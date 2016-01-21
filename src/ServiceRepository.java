import java.util.ArrayList;
import java.util.List;

/**
 * Created by YB on 21.01.2016.
 */
public class ServiceRepository<T extends Servicable> {

    private List<T> services;

    public ServiceRepository() {
        services = new ArrayList<T>();
    }
    public void addService (T service) {
        services.add(service);
    }
    public void removeService (T service) {
        services.remove(service);
    }
    public List<T> getServices (){
        return services;
    }

}
