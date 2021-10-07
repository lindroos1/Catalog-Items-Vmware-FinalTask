 package com.example.demo.services;



import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.HttpCustomEntity;
import com.example.models.CatalogItems;
import com.example.models.CatalogItemsList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class CatalogItemsService {

	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private HttpCustomEntity customEntity;
	
	@Autowired
	public CatalogItemsService(RestTemplate restTemplate, HttpHeaders headers,
			HttpCustomEntity customEntity) {
		this.restTemplate = restTemplate;
		this.headers = headers;
		this.customEntity = customEntity;
	}

	@ResponseBody
	public CatalogItemsList getCatalog(String url) throws RestClientException {

		return restTemplate.exchange(url, HttpMethod.GET, customEntity.getEntity(),
				CatalogItemsList.class).getBody();
	}
	
	@ResponseBody
	public CatalogItems getSingleCatalog(String url) throws RestClientException {

		
		return restTemplate.exchange(url, HttpMethod.GET, customEntity.getEntity(),
				CatalogItems.class).getBody();
	}
	
	@ResponseBody
	public String PostCatalogItems(String url, String projectId) throws RestClientException {
		String token  = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InNpZ25pbmdfMiJ9.eyJzdWIiOiJ2bXdhcmVpZDo0MWQ0NjlkZi05NTRjLTQ2MTktYmM2ZC0wMzM2OWFmNGVmNDYiLCJpc3MiOiJodHRwczovL2dhei1wcmV2aWV3LmNzcC12aWRtLXByb2QuY29tIiwiY29udGV4dF9uYW1lIjoiYTkzZjI0MWQtNTM0Zi00NTU3LTgzNDEtNzQyNGM1OWRjNGM5IiwiYXpwIjoiY3NwX3N0Z19nYXpfaW50ZXJuYWxfY2xpZW50X2lkIiwiYXV0aG9yaXphdGlvbl9kZXRhaWxzIjpbXSwiZG9tYWluIjoidm13YXJlaWQiLCJjb250ZXh0IjoiNzRmOTA5NDgtNTU3Yi00NmFkLTgyZjItZTRkZmNlZGEwMDViIiwicGVybXMiOlsiZXh0ZXJuYWwvWXctSHlCZVF6akNYa0wyd1FTZUd3YXVKLW1BXy9jYXRhbG9nOnVzZXIiLCJjc3A6b3JnX21lbWJlciIsImNzcDpkZXZlbG9wZXIiXSwiZXhwIjoxNjMzNjEwOTI3LCJpYXQiOjE2MzM2MDkxMjcsImp0aSI6IjJlMWU5ZDIyLWEwYmYtNGRkMS1hNzdiLTIwNjg2YzdjNDEyOCIsImFjY3QiOiJzaWRlbGNoOUBnbWFpbC5jb20iLCJ1c2VybmFtZSI6InNpZGVsY2g5QGdtYWlsLmNvbSJ9.IE27csV1m-f1MmqvO2UnCADgg9tqLViF-a-E-tFDMGqotaTTXcClFBJ2w4cMU_KuDMc1p-NLCxfWS-2p2ToS3U-2yBDU1p91oGv0hUOsiiKxBOvcxcPPO71LS1BH8ksI39hDv1mzsFDXrKOj4uK2mG_9T8AvgPbjLuinTD3o_ja3NCMLjEVOLsPm7-g6_NrQPuO5Jui_Edf_Zi35xODnoVXI4dzoZ2Y3Zbs2svidntQx4vLJmPAPC5bbfYRVIGaKiVUjN5GUouCstQNxeeIK6_2TfEwaYXJOAzos6UEgZpP2P7xRx7Q-tZcINJItgidoGauSLBxv6Q6gaMXPSNVIBw";
				headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
				headers.set("Authorization", "Bearer " + token);
				
				
				JsonObject object = new JsonObject();
				JsonObject object1 = new JsonObject();
				object.addProperty("bulkRequestCount",1);
				object.addProperty("deploymentName","send from Spring");
				object.add("inputs", object1);
				object.addProperty("projectId", projectId);
				object.addProperty("reason", "");
				object.addProperty("version", "");
				
				HttpEntity entity = new HttpEntity<>(object.toString(), headers);
			return restTemplate.exchange(url, HttpMethod.POST, entity,
				String.class).getBody();
	}
	
}
