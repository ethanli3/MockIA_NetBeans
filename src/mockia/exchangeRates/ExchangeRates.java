/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockia.exchangeRates;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ethanli
 */
public class ExchangeRates 
{
    //From ApiLayer
    
    //Essential URL structure is built using constants
    public static final String ACCESS_KEY = "3203a276784864b320f36d588cb90a71";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";

    //This object is used for executing requests to the (REST) API
    static CloseableHttpClient httpClient = HttpClients.createDefault();
    
    /**
     * Method that calls the exchange rate API that converts USD into HKD live
     * @param inputSpending The input Spending in HKD that will be converted to
     * USD
     * @return The inputSpending * The exchange rate given from the API
     */
    public static double convert(double inputSpending)
    {
        //The following line initializes the HttpGet Object with the URL in 
        //order to send a request
        HttpGet get = 
                new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);

        try 
        {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            //The following line converts the JSON Response to an equivalent 
            //Java Object
            JSONObject exchangeRates = 
                    new JSONObject(EntityUtils.toString(entity));

            //Parsed JSON Objects are accessed according to the JSON resonse's 
            //hierarchy, output strings are built

            double convertedAmount = inputSpending * 
                    exchangeRates.getJSONObject("quotes").getDouble("USDHKD");
            System.out.println(convertedAmount);   
            response.close();
            return convertedAmount;
        } 
        catch (ClientProtocolException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        } 
        catch (ParseException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        } 
        catch (JSONException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }
}