package project.tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import framework.base.BaseTest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Rule;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.pages.MainPage;
import project.steps.BattleShipSteps;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.Assert.assertThat;

public class TestBattleship extends BaseTest {

    @Override
    @Test
    public void runTest() {
        WireMockServer wireMockServer = new WireMockServer(8081); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        System.out.println(wireMockServer.isRunning());
        System.out.println(wireMockServer.port());

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8081/__admin/mappings");
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String stringResponse = httpResponse.getEntity().toString();
        String status = httpResponse.getStatusLine().toString();
        System.out.println(stringResponse + "  " + status);

//        WireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/plaintext/mapping1"))
//                .willReturn(aResponse()
//                        .withHeader("Content-Type", "text/plain")));
//        wireMockServer.stop();

//        WireMock.stubFor(get(urlEqualTo("/some/thing"))
//                .willReturn(aResponse()
//                        .withHeader("Content-Type", "text/plain")
//                        .withBody("Hello world!")));

//        Assert.assertEquals();
//
//        assertThat(testClient.get("/some/thing").statusCode(), is(200));
//        assertThat(testClient.get("/some/thing/else").statusCode(), is(404));

//        MainPage mainPage = new MainPage();
//        BattleShipSteps.preparationToStart(mainPage);
//        BattleShipSteps.playingGame(mainPage);

    }
}
