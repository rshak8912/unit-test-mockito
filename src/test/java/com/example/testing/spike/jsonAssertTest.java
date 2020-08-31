package com.example.testing.spike;

import org.json.JSONException;
import org.junit.Test;

import static org.skyscreamer.jsonassert.JSONAssert.*;

public class jsonAssertTest {
    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces () throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        assertEquals(expectedResponse, actualResponse, true);
    }
    @Test
    public void jsonAssert_StrictFalse_ExactMatchExceptForSpaces () throws JSONException {
        String expectedResponse = "{id:1,name:Ball,price:1}";
        assertEquals(expectedResponse, actualResponse, false);

    }

}
