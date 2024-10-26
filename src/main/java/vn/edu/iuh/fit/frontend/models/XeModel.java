package vn.edu.iuh.fit.frontend.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.frontend.dto.HangXeDTO;
import vn.edu.iuh.fit.frontend.dto.XeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class XeModel {
    private static final String BASE_URL = "http://localhost:8080/ontap2-1.0-SNAPSHOT/api/";

    public String getRequest(String path) {
        String json = null;
        try(Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(BASE_URL).path(path);
            json = target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return json;
    }
    public List<XeDTO> getAllXe(){
        List<XeDTO> xeDTOS = null;
        try(Client client = ClientBuilder.newClient()) {
                String jsonXe = getRequest("xes");

                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                xeDTOS = mapper.readValue(jsonXe, new TypeReference<List<XeDTO>>() {});
                for (XeDTO xeDTO : xeDTOS) {
                    String jsonHangXe = getRequest("hangxes/" + xeDTO.getMahangxe());
                    JsonNode jsonNode = mapper.readTree(jsonHangXe);
                    xeDTO.setTenhangxe(jsonNode.get("tenhang").asText());
                }

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return xeDTOS;
    }
    private String getNodeText(JsonNode node, String fieldName) {
        JsonNode fieldNode = node.get(fieldName);
        return fieldNode != null ? fieldNode.asText() : "";
    }

    public List<XeDTO> searchXe(String tenxe, double giaXe) {
        List<XeDTO> xeDTOS = getAllXe();
        return xeDTOS.stream()
                .filter(xe -> xe.getTenxe().equalsIgnoreCase(tenxe) || xe.getGiaXe() == giaXe)
                .collect(Collectors.toList());
    }
    public List<HangXeDTO> getAllHangXe() {
        List<HangXeDTO> hangXeDTOS = null;
        try (Client client = ClientBuilder.newClient()) {
            String jsonHangXe = getRequest("hangxes");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            hangXeDTOS = mapper.readValue(jsonHangXe, new TypeReference<List<HangXeDTO>>() {});
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return hangXeDTOS;
    }
}
