package com.gdxx.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticSearchConfig {

	@Value("${elasticsearch.host}")
	private String esHost;
	
	// TCP端口
	@Value("${elasticsearch.master.port}")
	private int masterEsPort;
	@Value("${elasticsearch.slave1.port}")
	private int slave1EsPort;

	//nginx端口
	@Value("${nginx.elasticsearch.port}")
	private int nginxEsPort;

	@Value("${elasticsearch.cluster.name}")
	private String esName;

//	@Bean
//	public TransportClient client() throws UnknownHostException {
//		// client.transport.sniff自动发现节点
//		Settings settings = Settings.builder().put("cluster.name", this.esName).put("client.transport.sniff", true)
//				.build();
//
//		TransportAddress master = new TransportAddress(InetAddress.getByName(esHost), masterEsPort);
//		TransportAddress slave1 = new TransportAddress(InetAddress.getByName(esHost), slave1EsPort);
//
//		TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(master)
//				.addTransportAddress(slave1);
//
//		return client;
//	}

	@Bean
	public TransportClient client() throws UnknownHostException {
		// client.transport.sniff自动发现节点
		Settings settings = Settings.builder().put("cluster.name", this.esName).put("client.transport.sniff", true)
				.build();

		TransportAddress nginxNode = new TransportAddress(InetAddress.getByName(esHost), nginxEsPort);

		TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(nginxNode);

		return client;
	}


}
