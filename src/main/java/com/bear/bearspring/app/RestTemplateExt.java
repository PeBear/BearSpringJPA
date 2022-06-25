package com.bear.bearspring.app;

import com.bear.bearspring.common.exception.CustomiseException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * It is to wrapper the {@code RestTemplate} with some extra functionality
 */
public class RestTemplateExt extends RestTemplate {

  private static final Logger LOG = LoggerFactory.getLogger(RestTemplateExt.class);

  /**
   * Initializes the default variables
   */
  public RestTemplateExt() {
    super();
    LOG.info("RestTemplateExt - using default configuration");
  }

  /**
   * Initializes the {@code RestTemplate} by {@code requestFactory}
   *
   * @param factory the {@link ClientHttpRequestFactory} to set
   */
  public RestTemplateExt(ClientHttpRequestFactory factory) {
    super(factory);
    LOG.info("RestTemplateExt - using ClientHttpRequestFactory");
  }

  /**
   * Initializes the {@code RestTemplate} by timeout attributes
   *
   * @param connectionTimeout        the connection timeout for the underlying {@code RequestConfig}
   * @param readTimeout              the socket read timeout
   * @param connectionRequestTimeout the timeout in milliseconds used when requesting a connection from the connection manager
   */
  public RestTemplateExt(final int connectionTimeout, final int readTimeout, final int connectionRequestTimeout) {
    super();
    LOG.info("RestTemplateExt - using default and timeout attributes");
    setTimeoutAttributes(getRequestFactory(), connectionTimeout, readTimeout, connectionRequestTimeout);
  }

  /**
   * Calls a rest api using the {@code GET} method
   *
   * @param url   the request url
   * @param clazz a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doGet(final String url, Class<T> clazz) throws CustomiseException {
    return doGet(url, null, null, MediaType.APPLICATION_JSON, clazz);
  }

  /**
   * Calls a rest api using the {@code GET} method
   *
   * @param url         the request url
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doGet(final String url, final Map<String, String> headerAttrs, Class<T> clazz)
      throws CustomiseException {
    return doGet(url, headerAttrs, null, MediaType.APPLICATION_JSON, clazz);
  }

  /**
   * Calls a rest api using the {@code GET} method
   *
   * @param url         the request url
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param queryParams list of key value pairs should be appended into the {@code url}
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doGet(final String url, final Map<String, String> headerAttrs,
      final Map<String, String> queryParams, Class<T> clazz) throws CustomiseException {
    return doGet(url, headerAttrs, queryParams, MediaType.APPLICATION_JSON, clazz);
  }

  /**
   * Calls a rest api using the {@code GET} method
   *
   * @param url         the request url
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param queryParams list of key value pairs should be appended into the {@code url}
   * @param mediaType   a {@link MediaType} is accepted in the request header
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doGet(final String url, final @Nullable Map<String, String> headerAttrs,
      final @Nullable Map<String, String> queryParams, final @Nullable MediaType mediaType, Class<T> clazz)
      throws CustomiseException {
    return doExchange(url, HttpMethod.GET, headerAttrs, queryParams, null, mediaType, clazz);
  }

  /**
   * Calls a rest api using the {@code POST} method
   *
   * @param url   the request url
   * @param clazz a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doPost(final String url, Class<T> clazz) throws CustomiseException {
    return doPost(url, null, null, null, MediaType.APPLICATION_JSON, clazz);
  }

  /**
   * Calls a rest api using the {@code POST} method
   *
   * @param url         the request url
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doPost(final String url, final @Nullable Map<String, String> headerAttrs,
      Class<T> clazz) throws CustomiseException {
    return doPost(url, headerAttrs, null, null, MediaType.APPLICATION_JSON, clazz);
  }

  /**
   * Calls a rest api using the {@code POST} method
   *
   * @param url         the request url
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param queryParams list of key value pairs should be appended into the {@code url}
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doPost(final String url, final @Nullable Map<String, String> headerAttrs,
      final @Nullable Map<String, String> queryParams, Class<T> clazz) throws CustomiseException {
    return doPost(url, headerAttrs, queryParams, null, MediaType.APPLICATION_JSON, clazz);
  }

  /**
   * Calls a rest api using the {@code POST} method
   *
   * @param url         the request url
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param body        an object to be passed via body of the request
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doPost(final String url, final @Nullable Map<String, String> headerAttrs,
      final @Nullable Object body, Class<T> clazz) throws CustomiseException {
    return doPost(url, headerAttrs, null, body, MediaType.APPLICATION_JSON, clazz);
  }

  /**
   * Calls a rest api using the {@code POST} method
   *
   * @param url         the request url
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param queryParams list of key value pairs should be appended into the {@code url}
   * @param body        an object to be passed via body of the request
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doPost(final String url, final @Nullable Map<String, String> headerAttrs,
      final @Nullable Map<String, String> queryParams, final @Nullable Object body, Class<T> clazz)
      throws CustomiseException {
    return doPost(url, headerAttrs, queryParams, body, MediaType.APPLICATION_JSON, clazz);
  }

  /**
   * Calls a rest api using the {@code POST} method
   *
   * @param url         the request url
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param queryParams list of key value pairs should be appended into the {@code url}
   * @param body        an object to be passed via body of the request
   * @param mediaType   a {@link MediaType} is accepted in the request header
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public <T> ResponseEntity<T> doPost(final String url, final @Nullable Map<String, String> headerAttrs,
      final @Nullable Map<String, String> queryParams, final @Nullable Object body,
      final @Nullable MediaType mediaType, Class<T> clazz) throws CustomiseException {
    return post4Entity(url, headerAttrs, queryParams, body, mediaType, clazz);
  }

  /**
   * Exchanges the request
   *
   * @param url         the {@code url} to be exchanged
   * @param method      a {@link HttpMethod}
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param queryParams list of key value pairs should be appended into the {@code url}
   * @param body        an object to be passed via body of the request
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public final <T> ResponseEntity<T> doExchange(final String url, final HttpMethod method,
      final @Nullable Map<String, String> headerAttrs, final @Nullable Map<String, String> queryParams,
      final @Nullable Object body, final MediaType mediaType, Class<T> clazz) throws CustomiseException {
    HttpHeaders headers = createHttpHeaders(headerAttrs, mediaType);
    String requestUrl = buildUrl(url, queryParams);
    HttpEntity<Object> request = body != null ? new HttpEntity<>(body, headers) : new HttpEntity<>(headers);
    return doExchange(requestUrl, method, request, clazz);
  }

  /**
   * Calls the rest API using {@code postForEntity}
   *
   * @param url         the {@code url} to be exchanged
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param queryParams list of key value pairs should be appended into the {@code url}
   * @param body        an object to be passed via body of the request
   * @param clazz       a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public final <T> ResponseEntity<T> post4Entity(final String url, final @Nullable Map<String, String> headerAttrs,
      final @Nullable Map<String, String> queryParams, final @Nullable Object body, final MediaType mediaType,
      Class<T> clazz) throws CustomiseException {
    HttpHeaders headers = createHttpHeaders(headerAttrs, mediaType);
    String requestUrl = buildUrl(url, queryParams);
    HttpEntity<Object> request = body != null ? new HttpEntity<>(body, headers) : new HttpEntity<>(headers);
    return post4Entity(requestUrl, request, clazz);
  }

  /**
   * Calls the rest API using {@code postForEntity}
   *
   * @param url     the {@code url} to be called
   * @param request an {@code Object} contains both {@code HttpHeaders} and {@code body}
   * @param clazz   a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public final <T> ResponseEntity<T> post4Entity(String url, final @Nullable Object request, Class<T> clazz)
      throws CustomiseException {
    long start = System.currentTimeMillis();
    try {
      LOG.info("=========================== post4Entity - \nurl: {} \nrequest: {}", url, request);
      ResponseEntity<T> resp = postForEntity(url, request, clazz);
      LOG.info("post4Entity - executed in {}ms", (System.currentTimeMillis() - start));
      return resp;
    } catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
      LOG.info(
          "=========================== catch HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException - executed in {}ms =============================",
          (System.currentTimeMillis() - start));
      LOG.error("Client and server error", ex);
      String errorMsg = ex.getResponseBodyAsString();
      errorMsg = StringUtils.isBlank(errorMsg) ? ex.getStatusText() : errorMsg;
      throw new CustomiseException(ex.getRawStatusCode(), "", errorMsg, ex.getMessage());
    } catch (ResourceAccessException ex) {
      LOG.info(
          "=========================== catch ResourceAccessException - executed in {}ms =============================",
          (System.currentTimeMillis() - start));
      LOG.error("ResourceAccessException : I/O error", ex);
      String errorMsg = ex.toString();
      if (ex.getCause() instanceof SocketTimeoutException) {
        LOG.info("=========================== catch ResourceAccessException | SocketTimeoutException =============================");
        throw new CustomiseException(HttpStatus.SERVICE_UNAVAILABLE.value(), "",
            "Connection or read timed out", ex.getMessage());
      } else if (errorMsg.toLowerCase().contains("handshake_failure")) {
        LOG.info("=========================== catch ResourceAccessException | handshake_failure =============================");
        throw new CustomiseException(HttpStatus.SERVICE_UNAVAILABLE.value(), "", "Handshare issue",
            ex.getMessage());
      }
      LOG.info("=========================== catch ResourceAccessException | INTERNAL_SERVER_ERROR =============================");
      throw new CustomiseException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "",
          HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
    } catch (Exception ex) {
      LOG.info("=========================== catch Exception  - executed in {}ms =============================",
          (System.currentTimeMillis() - start));
      LOG.error("Exception: ", ex);
      throw new CustomiseException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "",
          HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
    }
  }

  /**
   * Exchanges the request
   *
   * @param url    the {@code url} to be exchanged
   * @param method a {@link HttpMethod}
   * @param entity a {@link HttpEntity} of the request. It can contain both {@code HttpHeaders} and {@code EntityBody}
   * @param clazz  a return type
   * @return a {@link ResponseEntity} of T
   * @throws CustomiseException
   */
  public final <T> ResponseEntity<T> doExchange(final String url, final HttpMethod method,
      final @Nullable HttpEntity<?> entity, Class<T> clazz) throws CustomiseException {
    long start = System.currentTimeMillis();
    try {
      LOG.info("=========================== doExchange - url: {}", url);
      ResponseEntity<T> resp = exchange(url, method, entity, clazz);
      LOG.info("doExchange - executed in {}ms", (System.currentTimeMillis() - start));
      return resp;
    } catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
      LOG.error("Client and server error - executed in {}ms", (System.currentTimeMillis() - start), ex);
      String errorMsg = ex.getResponseBodyAsString();
      errorMsg = StringUtils.isBlank(errorMsg) ? ex.getStatusText() : errorMsg;
      throw new CustomiseException(ex.getRawStatusCode(), "", errorMsg, ex.getMessage());
    } catch (ResourceAccessException ex) {
      String errorMsg = ex.toString();
      LOG.error("ResourceAccessException - executed in {}ms", (System.currentTimeMillis() - start), ex);
      if (ex.getCause() instanceof SocketTimeoutException) {
        throw new CustomiseException(HttpStatus.SERVICE_UNAVAILABLE.value(), "",
            "Connection or read timed out", ex.getMessage());
      } else if (errorMsg.toLowerCase().contains("handshake_failure")) {
        throw new CustomiseException(HttpStatus.SERVICE_UNAVAILABLE.value(), "", "Handshare issue",
            ex.getMessage());
      }
      throw new CustomiseException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "",
          HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
    } catch (Exception ex) {
      LOG.error("Exception - executed in {}ms", (System.currentTimeMillis() - start), ex);
      throw new CustomiseException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "",
          HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
    }
  }

  /**
   * Creates a {@code HttpHeaders} by {@code headerAttrs}
   *
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @return a {@link HttpHeaders}
   */
  public final HttpHeaders createHttpHeaders(final Map<String, String> headerAttrs) {
    if (headerAttrs == null || headerAttrs.isEmpty()) {
      return new HttpHeaders();
    }
    MultiValueMap<String, String> attrs = new LinkedMultiValueMap<>();
    Iterator<Entry<String, String>> iterator = headerAttrs.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, String> entry = iterator.next();
      attrs.add(entry.getKey(), entry.getValue());
    }
    return new HttpHeaders(attrs);
  }

  /**
   * Creates a {@code HttpHeaders} by {@code headerAttrs}
   *
   * @param headerAttrs list of key value pairs should be added into the {@code HttpHeaders}
   * @param mediaType   a {@link MediaType} should be accepted
   * @return a {@link HttpHeaders}
   */
  public final HttpHeaders createHttpHeaders(final Map<String, String> headerAttrs, final MediaType mediaType) {
    HttpHeaders header = createHttpHeaders(headerAttrs);
    if (mediaType != null) {
      header.setAccept(Collections.singletonList(mediaType));
    }
    return header;
  }

  /**
   * Builds a {@code url} by combining {@code url} and {@code queryParams}
   *
   * @param url         the raw url to be built
   * @param queryParams list of key value pairs should be appended into the {@code url}
   * @return a combined {@code url}
   */
  public final String buildUrl(final String url, final Map<String, String> queryParams) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
    if (queryParams == null || queryParams.isEmpty()) {
      return builder.build().toUriString();
    }

    Iterator<Entry<String, String>> iterator = queryParams.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, String> entry = iterator.next();
      builder = builder.queryParam(entry.getKey(), entry.getValue());
    }
    return builder.build().toUriString();
  }

  private void setTimeoutAttributes(final ClientHttpRequestFactory factory, final int connectionTimeout,
      final int readTimeout, final int connectionRequestTimeout) {
    try {
      LOG.info("setTimeoutAttributes - factory: {}", factory);
      if (factory != null) {
        if (factory instanceof SimpleClientHttpRequestFactory) {
          SimpleClientHttpRequestFactory connFactory = (SimpleClientHttpRequestFactory) factory;
          connFactory.setConnectTimeout(connectionTimeout);
          connFactory.setReadTimeout(readTimeout);
        } else if (factory instanceof HttpComponentsClientHttpRequestFactory) {
          HttpComponentsClientHttpRequestFactory connFactory = (HttpComponentsClientHttpRequestFactory) factory;
          connFactory.setConnectTimeout(connectionTimeout);
          connFactory.setReadTimeout(readTimeout);
          connFactory.setConnectionRequestTimeout(connectionRequestTimeout);
        }
      }
    } catch (Exception ex) {
      LOG.error("Exception - error while configuring timeout", ex);
    }
  }


}

