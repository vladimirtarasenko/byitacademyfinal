import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.net.URL;

public class GetPatients extends StdDeserializer<PatientsContainer> implements PatientsSorting {

   ObjectMapper objectMapper = new ObjectMapper();

   public GetPatients(){
       this(null);
   }

    public GetPatients(Class <?> vc) {
        super(vc);
    }

    public PatientsContainer deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        PatientsContainer patientContainer = new PatientsContainer();
        JsonNode root = objectMapper.readTree(new URL("https://raw.githubusercontent.com/vladimirtarasenko/lesson10/master/PatientsInHospital.json"));
        JsonNode node = root.path("patients");
        for (JsonNode nodes : node) {
            int id = nodes.path("id").asInt();
            String name = nodes.path("name").asText();
            String diagnosis = nodes.path("diagnosis").asText();
            String dateOfBirth = nodes.path("dateOfBirth").asText();
            int daysStayInHospital = nodes.path("daysStayInHospital").asInt();
            String readyForCheckOut = nodes.path("readyForCheckOut").asText();
            patientContainer.getPatients().add(Patients.builder()
                    .id(id)
                    .name(name)
                    .diagnosis(diagnosis)
                    .dateOfBirth(dateOfBirth)
                    .daysStayInHospital(daysStayInHospital)
                    .readyForCheckOut(readyForCheckOut)
                    .build());
        }
        return patientContainer;
    }

    public PatientsContainer execute() throws IOException, XMLStreamException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(PatientsContainer.class, new GetPatients());
        objectMapper.registerModule(module);
        PatientsContainer readValue = objectMapper.readValue(new URL("https://raw.githubusercontent.com/vladimirtarasenko/lesson10/master/PatientsInHospital.json"), PatientsContainer.class);
        return readValue;
    }

    @Override
    public void sortPatients() throws IOException, XMLStreamException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(PatientsContainer.class, new GetPatients());
        objectMapper.registerModule(module);
        PatientsContainer readValue = objectMapper.readValue(new URL("https://raw.githubusercontent.com/vladimirtarasenko/lesson10/master/PatientsInHospital.json"), PatientsContainer.class);
        System.out.println(readValue);
    }
}
