package br.com.caelum.spring.process;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.Assert;

public class EventRegistry implements Event {

	private List<DefaultEvent> events = new ArrayList<DefaultEvent>();

	private Executor executor;
	
	@PostConstruct
	public void init() {
		this.executor = new SimpleAsyncTaskExecutor("Async-Event-");
	}

	@Override
	public void fire(final Object event) {
		for (final DefaultEvent e : events) {
			if (!e.isSupported(event.getClass())) {
				continue;
			}
			execute(event, e);
		}

	}

	private void execute(final Object event, final DefaultEvent listener) {
		executor.execute(new Runnable() {
			public void run() {
				listener.doFire(event);
			}
		});
	}

	public void registerEvent(Object bean, Method method, Class<?> parameterType) {
		Assert.notNull(bean, "Não foi possível registrar o evento, pois o nome do bean é nullo");
		Assert.notNull(method, "Não foi possível registrar o evento, pois o seu método é nullo");
		Assert.notNull(parameterType, "Não foi possível registrar os parâmetros.");

		events.add(new DefaultEvent(bean, method, parameterType));
	}

	private class DefaultEvent {
		protected final Class<?> parameterType;
		private final Method method;
		private final Object bean;

		private DefaultEvent(Object bean, Method method, Class<?> parameterType) {
			this.bean = bean;
			this.method = method;
			this.parameterType = parameterType;
		}

		private boolean isSupported(Class<?> eventType) {
			return parameterType.isAssignableFrom(eventType);
		}

		void doFire(Object event) {
			try {
				method.invoke(bean, event);
			} catch (Throwable e) {
				throw new RuntimeException("Ocorreu uma falha no momento da execução" + event.getClass().getName(), e);
			}
		}

	}

}
