package io.evolvee.poc.misc;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import io.evolvee.poc.EvolveeEnvironment;

public class SSLHelper {
	public static SSLContext loadSslContext() throws Exception {
		SSLContext sslContext = null;

		// load up the key store
		String storeType = EvolveeEnvironment.getConfigManager().getSslStoreType();
		String keyStore = EvolveeEnvironment.getConfigManager().getSslStoreFile();
		String storePassword = EvolveeEnvironment.getConfigManager().getSslStorePassword();
		String keyPassword = EvolveeEnvironment.getConfigManager().getSslKeyPassword();

		KeyStore ks = KeyStore.getInstance(storeType);
		File kf = new File(keyStore);
		ks.load(new FileInputStream(kf), storePassword.toCharArray());

		KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		kmf.init(ks, keyPassword.toCharArray());
		TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
		tmf.init(ks);

		sslContext = SSLContext.getInstance("TLS");
		sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

		return sslContext;
	}
}
