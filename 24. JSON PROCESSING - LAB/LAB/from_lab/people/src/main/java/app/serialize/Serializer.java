package app.serialize;


import app.domain.dto.json.PersonDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface Serializer {

    public <T> void serialize(T t, String fileName);
    public <T> T deserialize(Class<T> t, String fileName);
}
