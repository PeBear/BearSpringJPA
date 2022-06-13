package com.bear.bearspring.common.exception.handler;

import com.bear.bearspring.common.constants.CommonConstants;
import java.nio.file.AccessDeniedException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * It is to handle the {@code exception} of the application
 */
@ControllerAdvice(annotations = Controller.class)
@Order(Ordered.LOWEST_PRECEDENCE)
public class CustomExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler(Exception.class)
  public final String handleUnExpectedException(final Exception ex, final Model model) {
    LOG.error("handleUnExpectedException: {}", ex.getMessage());
    model.addAttribute(CommonConstants.STATUS_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value());
    model.addAttribute(CommonConstants.CONTENT_ERROR,
        getMessages(CommonConstants.KEY_CONTENT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value()));
    return CommonConstants.PAGE_ERROR;
  }

  @ExceptionHandler(AccessDeniedException.class)
  public final String handleAccessDeniedException(final AccessDeniedException ex, final Model model) {
    LOG.error("handleAccessDeniedException: {}", ex.getMessage());
    model.addAttribute(CommonConstants.STATUS_CODE, HttpStatus.FORBIDDEN.value());
    model.addAttribute(CommonConstants.CONTENT_ERROR,
        getMessages(CommonConstants.KEY_CONTENT_ERROR, HttpStatus.FORBIDDEN.value()));
    return CommonConstants.PAGE_ERROR;
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public final String handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final Model model) {
    LOG.error("handleHttpMessageNotReadable: {}", ex.getMessage());
    model.addAttribute(CommonConstants.STATUS_CODE, HttpStatus.BAD_REQUEST.value());
    model.addAttribute(CommonConstants.CONTENT_ERROR,
        getMessages(CommonConstants.KEY_CONTENT_ERROR, HttpStatus.BAD_REQUEST.value()));
    return CommonConstants.PAGE_ERROR;
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public final String handleMissingServletRequestParameterException(final MissingServletRequestParameterException ex,
      final Model model) {
    LOG.error("handleMissingServletRequestParameterException: {}", ex.getMessage());
    model.addAttribute(CommonConstants.STATUS_CODE, HttpStatus.BAD_REQUEST.value());
    model.addAttribute(CommonConstants.CONTENT_ERROR,
        getMessages(CommonConstants.KEY_CONTENT_ERROR, HttpStatus.BAD_REQUEST.value()));
    return CommonConstants.PAGE_ERROR;
  }

  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  public final String handleHttpMediaTypeNotSupported(final HttpMediaTypeNotSupportedException ex, final Model model) {
    LOG.error("handleHttpMediaTypeNotSupported: {}", ex.getMessage());
    model.addAttribute(CommonConstants.STATUS_CODE, HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
    model.addAttribute(CommonConstants.CONTENT_ERROR,
        getMessages(CommonConstants.KEY_CONTENT_ERROR, HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()));
    return CommonConstants.PAGE_ERROR;
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public final String handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException ex,
      final Model model) {
    LOG.error("handleMethodArgumentTypeMismatchException: {}", ex.getMessage());
    model.addAttribute(CommonConstants.STATUS_CODE, HttpStatus.BAD_REQUEST.value());
    model.addAttribute(CommonConstants.CONTENT_ERROR,
        getMessages(CommonConstants.KEY_CONTENT_ERROR, HttpStatus.BAD_REQUEST.value()));
    return CommonConstants.PAGE_ERROR;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public final String handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex,
      final Model model) {
    LOG.error("handleMethodArgumentNotValidException: {}", ex.getMessage());
    model.addAttribute(CommonConstants.STATUS_CODE, HttpStatus.BAD_REQUEST.value());
    model.addAttribute(CommonConstants.CONTENT_ERROR,
        getMessages(CommonConstants.KEY_CONTENT_ERROR, HttpStatus.BAD_REQUEST.value()));
    return CommonConstants.PAGE_ERROR;
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public final String handleNoHandlerFoundException(final NoHandlerFoundException ex, final Model model) {
    LOG.error("handleNoHandlerFoundException: {}", ex.getMessage());
    model.addAttribute(CommonConstants.STATUS_CODE, HttpStatus.BAD_REQUEST.value());
    model.addAttribute(CommonConstants.CONTENT_ERROR,
        getMessages(CommonConstants.KEY_CONTENT_ERROR, HttpStatus.BAD_REQUEST.value()));
    return CommonConstants.PAGE_ERROR;
  }

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public final String handleMaxUploadSizeExceededException(final MaxUploadSizeExceededException ex, final Model model) {
    LOG.error("handleMaxUploadSizeExceededException: {}", ex.getMessage());
    model.addAttribute(CommonConstants.STATUS_CODE, HttpStatus.BAD_REQUEST.value());
    model.addAttribute(CommonConstants.CONTENT_ERROR,
        getMessages(CommonConstants.KEY_CONTENT_ERROR, HttpStatus.BAD_REQUEST.value()));
    return CommonConstants.PAGE_ERROR;
  }

  private String getMessages(String prefix, Integer statusCode) {
    String msg = messageSource.getMessage(prefix + "." + statusCode, null, LocaleContextHolder.getLocale());
    if (StringUtils.isEmpty(msg)) {
      msg = messageSource
          .getMessage("com.sg.server.content.error.default", null, LocaleContextHolder.getLocale());
    }
    return msg;
  }

}
