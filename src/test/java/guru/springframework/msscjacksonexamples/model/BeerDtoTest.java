package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);

    }

    @Test
    void testDeserialize() throws IOException {

        String json ="\n" +
                "{\"beerId\":\"d0b81a5b-040f-4a66-9d19-b378da44a4e9\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2020-12-05T23:30:14+0900\",\"lastUpdatedDate\":\"2020-12-05T22:46:35.166266+09:00\"}";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }

}