package com.gdxx.service.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceResult<T> {
	private boolean success;
	private String message;
	private T result;

	public ServiceResult(boolean success) {
		this.success = success;
	}

	public ServiceResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public ServiceResult(boolean success, String message, T result) {
		this.success = success;
		this.message = message;
		this.result = result;
	}

	public static <T> ServiceResult<T> success() {
		return new ServiceResult<>(true);
	}

	public static <T> ServiceResult<T> of(T result) {
		ServiceResult<T> serviceResult = new ServiceResult<>(true);
		serviceResult.setResult(result);
		return serviceResult;
	}

	public static <T> ServiceResult<T> notFound() {
		return new ServiceResult<>(false, Message.NOT_FOUND.getValue());
	}

	@Getter
	@AllArgsConstructor
	public enum Message {
		NOT_FOUND("Not Found Resource!"), NOT_LOGIN("User not login!");
		private String value;

	}
}
