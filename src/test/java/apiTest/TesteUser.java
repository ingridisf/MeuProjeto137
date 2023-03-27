// nome do pacote
package apiTest;

// Bibliotecas

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


// classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteUser { // inicio da classe
         // Atributos

    static String ct = "application/json"; // content type

    static String uriUser = "https://petstore.swagger.io/v2/user/";

        // funções e métodos
        // funções de apoio

    public static String lerArquivoJson (String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }


    // Funções de testes
     @Test @Order(1)
    public void testarIncluirUser () throws IOException {
         // carregar os dados do nosso json
         String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");

         String userId = "1374152406";

         // realizar o teste
         given()                                                    // Dado que
                 .contentType(ct)                                    // o tipo do conteúdo
                 .log().all()                                        // mostre tudo
                 .body(jsonBody)                                     // corpo da requisição
          .when()                                                    // Quando
                 .post(uriUser)                                      // Endpoint / Onde
                 .then()                                             // Então
                 .log().all()                                         // mostre tudo na volta
                 .statusCode(200)                                   // comunic. ida e volta ok
                 .body("code", is(200))                        // tag code é 200
                 .body("message", is(userId))                        // messagem é o userID
         ;
    } // fim do post

    @Test @Order(2)
    public void testarConsultarUser () {
        String username = "ingrid";

        // resultados esperados
        int userId = 1374152406; // código do usuário
        String email = "ingrid.sf@hotmail.com";
        String senha = "123456";
        String telefone = "11983866306";

        given()
                .contentType(ct)
                .log().all()
                .when()
                .get(uriUser + username)
                .then ()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("email", is(email))
                .body("password", is(senha))
                .body("phone", is(telefone))
        ;
    } // fim do get user
@Test @Order(3)
    public void testarAlterarUser () throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");

        String userId = "1374152406";
        String username = "ingrid";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
            .when()
                .put(uriUser + username)
            .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userId))
        ;

} // fim do put user

@Test @Order(4)
public void testarExcluirUser (){ // inicio do delete user não esquecer do @Test
        String username = "ingrid";

                given()
                        .contentType(ct)
                        .log().all()
                    .when()
                        .delete(uriUser + username)
                    .then()
                        .statusCode(200)
                        .body("code", is(200))
                        .body("type", is("unknown"))
                        .body("message", is(username))
                        ;

    } // fim do delete User

    // EXERCICIO

    @Test @Order(5)
    public void testarLogin() { // inicio do login
        String username = "ingrid";
        String password = "123456";

        Response resp = (Response) given()
                .contentType(ct)
                .log().all()
                .when()
                .get(uriUser + "login?username=" + username + "&password=" + password)
                .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", containsString("logged in user session:"))
                .body("message", hasLength(36))
                .extract();

        // Extração do token da resposta
        String token = resp.jsonPath().getString("message").substring(23);
        System.out.println("Conteudo do Token: " + token);
    } // fim do login

    @ParameterizedTest @Order(6)
    @CsvFileSource (resources = "csv/massaUser.csv", numLinesToSkip = 1, delimiter = ',')
    public void testarIncluirUserCSV(
            String id,
            String username,
            String firstName,
            String lastName,
            String email,
            String password,
            String phone,
            String userStatus)
            // carregar os dados do nosso json
    {

        User user = new User(); // instancia a classe User

        user.id = id;
        user.username = username;
        user.firstName  = firstName;
        user.lastName = lastName;
        user.email = email;
        user.password = password;
        user.phone = phone;
        user.userStatus = userStatus;

        Gson gson = new Gson (); // instancia a classe
        String jsonBody = gson.toJson(user);


            // realizar o teste
            given()                                                    // Dado que
                    .contentType(ct)                                    // o tipo do conteúdo
                    .log().all()                                        // mostre tudo
                    .body(jsonBody)                                     // corpo da requisição
                    .when()                                                    // Quando
                    .post(uriUser)                                      // Endpoint / Onde
                    .then()                                             // Então
                    .log().all()                                         // mostre tudo na volta
                    .statusCode(200)                                   // comunic. ida e volta ok
                    .body("code", is(200))                        // tag code é 200
                    .body("message", is(id))                        // messagem é o userID
            ;

    } // fim incluir CSV
} // fim da classe
