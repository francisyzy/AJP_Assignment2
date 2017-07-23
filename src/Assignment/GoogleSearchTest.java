/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import javax.json.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
//import org.junit.*;

/**
 *
 * @author francisyzy
 */
public class GoogleSearchTest {
    public static void main(String[] args) throws Exception {
        givenJsonDateInFlatFile_readsDataIntoJsonObject();
    }
    
    
    //@Test
    public static void givenJsonDateInFlatFile_readsDataIntoJsonObject() throws Exception {

        // Arrange
        GoogleSearchRestTest objectExample2 = new GoogleSearchRestTest();

        // Act
        JsonObject jsonObject = objectExample2.loadJsonObject();

        // Assert
        assertThat(jsonObject.getValueType()).isEqualTo(JsonValue.ValueType.OBJECT);
    }
}
