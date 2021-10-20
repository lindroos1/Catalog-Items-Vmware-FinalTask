package com.example.helpers;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.HttpGetEntity;
import com.example.models.catalogItems.CatalogItemsList;
import com.example.models.catalogItems.VersionsList;

public class SetVersionsHelper {

	
	public static void setVersions(CatalogItemsList catalogitemList,  RestTemplate restTemplate,
			 HttpGetEntity getEntity) {
		
		for(int i = 0; i < catalogitemList.getContent().size(); i++) {
			String urrl = "https://api.staging.symphony-dev.com/catalog/api/items/" +
					catalogitemList.getContent().get(i).getId()+ "/versions";
			catalogitemList.getContent().get(i).setVersions(restTemplate.exchange(urrl, HttpMethod.GET ,getEntity.getEntity(),
					VersionsList.class).getBody());
		}
		
	}
}
