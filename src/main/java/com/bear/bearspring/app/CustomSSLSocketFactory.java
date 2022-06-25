package com.bear.bearspring.app;

import java.io.IOException;
import java.net.InetAddress;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class CustomSSLSocketFactory {

  private static final Logger LOG = LoggerFactory.getLogger(CustomSSLSocketFactory.class);

  private CustomSSLSocketFactory() {
    // Prevents developer from initializing instance
  }

  /**
   * Creates a {@code ClientHttpRequestFactory}
   *
   * @param connectionTimeout the connection timeout
   * @param readTimeout       the read timeout
   * @return a {@link ClientHttpRequestFactory}
   */
  public static ClientHttpRequestFactory createClientHttpRequestFactory(int connectionTimeout, int readTimeout) {
    return createClientHttpRequestFactory("", connectionTimeout, readTimeout);
  }

  /**
   * Creates a {@code ClientHttpRequestFactory}
   *
   * @param protocol          the SSL protocol e.g. {@code TLSv1.2, TLSv1.3}
   * @param connectionTimeout the connection timeout
   * @param readTimeout       the read timeout
   * @return a {@link ClientHttpRequestFactory}
   */
  public static ClientHttpRequestFactory createClientHttpRequestFactory(final String protocol, int connectionTimeout,
      int readTimeout) {
    LOG.info("createClientHttpRequestFactory - protocol: {}, connectionTimeout: {}, readTimeout: {}", protocol,
        connectionTimeout, readTimeout);
    LayeredConnectionSocketFactory connSocketFactory = null;
    if (StringUtils.isNotBlank(protocol)) {
      connSocketFactory = createSSLSocketFactory(protocol);
    }
    return createClientHttpRequestFactory(connSocketFactory, connectionTimeout, readTimeout);
  }

  /**
   * Creates a {@code ClientHttpRequestFactory} by a {@code certification}
   *
   * @param trustResource      a {@link Resource}
   * @param trustStorePassword the password corresponding {@code certification}
   * @param connectionTimeout  the connection timeout
   * @param readTimeout        the read timeout
   * @return a {@link ClientHttpRequestFactory}
   * @throws NoSuchAlgorithmException
   * @throws KeyManagementException
   * @throws KeyStoreException
   * @throws CertificateException
   * @throws IOException
   */
  public static ClientHttpRequestFactory createClientHttpRequestFactory(final Resource trustResource,
      final String trustStorePassword, int connectionTimeout, int readTimeout) throws NoSuchAlgorithmException,
      KeyManagementException, KeyStoreException, CertificateException, IOException {
    LOG.info("createClientHttpRequestFactory - trustResource: {}, connectionTimeout: {}, readTimeout: {}",
        trustResource, connectionTimeout, readTimeout);
    SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(trustResource.getURL(),
        trustStorePassword.toCharArray()).build();
    return createClientHttpRequestFactory(sslContext, connectionTimeout, readTimeout);
  }

  /**
   * Creates a {@code ClientHttpRequestFactory} which trusts all hosts
   *
   * @param connectionTimeout the connection timeout
   * @param readTimeout       the read timeout
   * @return a {@link ClientHttpRequestFactory}
   * @throws NoSuchAlgorithmException
   * @throws KeyManagementException
   * @throws KeyStoreException
   */
  public static ClientHttpRequestFactory createClientHttpsRequestFactoryTrustAll(final int connectionTimeout,
      final int readTimeout) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
    return createClientHttpsRequestFactoryTrustAll("", connectionTimeout, readTimeout);
  }

  /**
   * Creates a {@code ClientHttpRequestFactory} which trusts all hosts
   *
   * @param protocol          the SSL protocol e.g. {@code TLSv1.2, TLSv1.3}
   * @param connectionTimeout the connection timeout
   * @param readTimeout       the read timeout
   * @return a {@link ClientHttpRequestFactory}
   * @throws NoSuchAlgorithmException
   * @throws KeyManagementException
   * @throws KeyStoreException
   */
  public static ClientHttpRequestFactory createClientHttpsRequestFactoryTrustAll(final String protocol,
      final int connectionTimeout, final int readTimeout) throws NoSuchAlgorithmException,
      KeyManagementException, KeyStoreException {
    LOG.info("createClientHttpsRequestFactoryTrustAll - protocol: {}, connectionTimeout: {}, readTimeout: {}",
        protocol, connectionTimeout, readTimeout);

    SSLContextBuilder builder = new SSLContextBuilder();
    if (StringUtils.isNotBlank(protocol)) {
      builder.setProtocol(protocol);
    }

    SSLContext sslContext = builder.loadTrustMaterial(null, new TrustStrategy() {

      @Override
      public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        return true;
      }
    }).build();
    return createClientHttpRequestFactory(sslContext, connectionTimeout, readTimeout);
  }

  /**
   * Creates a {@code ClientHttpRequestFactory} which trusts all hosts
   *
   * @param Context           the SSL Context
   * @param connectionTimeout the connection timeout
   * @param readTimeout       the read timeout
   * @return a {@link ClientHttpRequestFactory}
   */
  private static ClientHttpRequestFactory createClientHttpRequestFactory(final SSLContext sslContext,
      final int connectionTimeout, final int readTimeout) {
    LOG.info("createClientHttpRequestFactory - sslContext: {}, connectionTimeout: {}, readTimeout: {}", sslContext,
        connectionTimeout, readTimeout);
    HttpClientBuilder builder = HttpClientBuilder.create();
    RequestConfig config = RequestConfig.custom().setConnectTimeout(connectionTimeout)
        .setConnectionRequestTimeout(connectionTimeout).setSocketTimeout(readTimeout).build();
    builder.setDefaultRequestConfig(config);
    if (null != sslContext) {
      builder.setSSLContext(sslContext);
    }

    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(builder.build());
    factory.setConnectTimeout(connectionTimeout);
    factory.setReadTimeout(readTimeout);
    return factory;
  }

  /**
   * Creates a {@code ClientHttpRequestFactory} which trusts all hosts
   *
   * @param connection        Socket the Layer Connection Socket Factory
   * @param connectionTimeout the connection timeout
   * @param readTimeout       the read timeout
   * @return a {@link ClientHttpRequestFactory}
   */
  private static ClientHttpRequestFactory createClientHttpRequestFactory(
      final LayeredConnectionSocketFactory connSocketFactory, final int connectionTimeout, final int readTimeout) {
    LOG.info("createClientHttpRequestFactory2 - connSocketFactory: {}, connectionTimeout: {}, readTimeout: {}",
        connSocketFactory, connectionTimeout, readTimeout);
    HttpClientBuilder builder = HttpClientBuilder.create();
    RequestConfig config = RequestConfig.custom().setConnectTimeout(connectionTimeout)
        .setConnectionRequestTimeout(connectionTimeout).setSocketTimeout(readTimeout).build();
    builder.setDefaultRequestConfig(config);
    if (null != connSocketFactory) {
      builder.setSSLSocketFactory(connSocketFactory);
    }

    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(builder.build());
    factory.setConnectTimeout(connectionTimeout);
    factory.setReadTimeout(readTimeout);
    return factory;
  }

  /**
   * Creates a {@code LayeredConnectionSocketFactory}
   *
   * @param protocol
   * @return a {@link LayeredConnectionSocketFactory}
   */
  private static LayeredConnectionSocketFactory createSSLSocketFactory(String protocol) {
    try {
      LOG.info("createSSLSocketFactory - protocol: {}", protocol);
      return new SSLConnectionSocketFactory(SSLContexts.createDefault()) {

        @Override
        protected void prepareSocket(SSLSocket socket) {
          LOG.info("createSSLSocketFactory - InetAddress info: {}", getAddrInfo(socket.getInetAddress()));
          if (StringUtils.isBlank(protocol) || "DYNAMIC".equalsIgnoreCase(protocol)) {
            // Let server decide which version should be used
            socket.setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"});
          } else {
            socket.setEnabledProtocols(new String[]{protocol});
          }
        }

        private String getAddrInfo(InetAddress iaddr) {
          StringBuilder sb = new StringBuilder();
          if (iaddr != null) {
            sb.append("hostAddress=").append(iaddr.getHostAddress()).append(", ");
            sb.append("hostName=").append(iaddr.getHostName()).append(", ");
            sb.append("address=").append(new String(iaddr.getAddress()));
          }
          return sb.toString();
        }
      };
    } catch (Exception ex) {
      LOG.info("createSSLSocketFactory - error while creating SSLSocketFactory protocol: {}", protocol, ex);
      return null;
    }
  }

}
