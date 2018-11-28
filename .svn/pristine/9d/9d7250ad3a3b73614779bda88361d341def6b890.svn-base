package com.aotain.cu.serviceapi.dto;

import java.io.Serializable;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.aotain.cu.utils.MessageHelper;

public class AjaxError implements Serializable {
	public enum Mode {
		MODE1, MODE2
	}

	private static final long serialVersionUID = 1L;

	private String field;
	private String code;
	private String errorMessage;

	public AjaxError(ObjectError objectError) {
		if (objectError != null) {
			// Object[] arguments = objectError.getArguments();
			String[] codes = objectError.getCodes();
			// DefaultMessageSourceResolvable argument =
			// (DefaultMessageSourceResolvable) (arguments[0]);
			if (codes != null && codes.length >= 2) {
				this.field = codes[1];
			} else {
				this.field = "";
			}
			this.code = objectError.getDefaultMessage();
			this.errorMessage = MessageHelper.getHelper().getMessage(this.code, LocaleContextHolder.getLocale());
		}
	}

	public AjaxError(FieldError fieldError) {
		if (fieldError != null) {
			this.field = fieldError.getField();
			this.code = fieldError.getDefaultMessage();
			this.errorMessage = MessageHelper.getHelper().getMessage(this.code, LocaleContextHolder.getLocale());
		}
	}

	public AjaxError(FieldError fieldError, Object[] args) {
		if (fieldError != null) {
			this.field = fieldError.getField();
			this.code = fieldError.getDefaultMessage();
			this.errorMessage = MessageHelper.getHelper().getMessage(this.code, args, LocaleContextHolder.getLocale());
		}

	}

	public AjaxError(FieldError fieldError, Object[] args, Mode mode) {
		if (fieldError != null) {
			this.field = fieldError.getField();
			switch (mode) {
			case MODE1:
				this.code = fieldError.getDefaultMessage();
				this.errorMessage = MessageHelper.getHelper().getMessage(this.code, args, LocaleContextHolder.getLocale());
				break;
			case MODE2:
				this.code = fieldError.getCode();
				this.errorMessage = fieldError.getDefaultMessage();
				break;
			}
		}

	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
