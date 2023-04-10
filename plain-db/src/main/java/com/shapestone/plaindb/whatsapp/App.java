/* Copyright (c) Meta Platforms, Inc. and affiliates.
* All rights reserved.
*
* This source code is licensed under the license found in the
* LICENSE file in the root directory of this source tree.
*/

package com.shapestone.plaindb.whatsapp;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App 
{
    public static void main( String[] args )
    {
        String phoneNumber = "918639379153";
        String phoneNumberId = "108232302237352";
        String authToken = "EAAInWW7PLioBAFOecY9eHq2C4aOdNWZCvfDELW8INZCajiJ8NZAMLiFEyQkdt7NAGyzgkdowlwTM4Jjg9wHjXIC3uAIxHSTHd2TmmlJgJy8tO7n8wwMRyaUMHHOvagMbPJeLOjQyLk1yqVs9dkCGLrwi49CZBACWSoqOeb0kfLIPt6IErDufoUEmsqt9ZBNTJZCsfj5dMGTQZDZD";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://graph.facebook.com/v13.0/"+phoneNumberId+"/messages"))
                .header("Authorization", "Bearer "+authToken)
                .header("Content-Type", "application/json")
                // Getting started example
                //.POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \""+phoneNumber+"\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }"))
                // Text message example
                .POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \""+phoneNumber+"\", \"type\": \"text\", \"text\": { \"preview_url\": false, \"body\": \"This is an example of a text message\" } }"))
                // Bespoke message template example
//                .POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \""+phoneNumber+"\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" }, \"components\":[{\"type\":\"header\",\"parameters\":[{\"type\":\"image\",\"image\":{\"link\":\"https://i.ibb.co/DRMHqRj/welcome.jpg\"}}]},{\"type\":\"body\",\"parameters\":[{\"type\":\"text\",\"text\":\"John Smith\"}]}] } }"))
                .build();
            HttpClient http = HttpClient.newHttpClient();
            for (int i = 1; i < 50; i++) {
            	HttpResponse<String> response = http.send(request,BodyHandlers.ofString());
                System.out.println(i + "). " + response.body());
            }
            
            
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}