package anywheresoftware.b4j.objects;

import javafx.application.Application;
import javafx.application.Platform;
import anywheresoftware.b4a.BA;


@anywheresoftware.b4a.BA.Hide
public class FxBA extends BA{
	public static Application application;
	public FxBA(String packageName, String className, Object eventsTarget) {
		super(packageName, className, eventsTarget);
	}

	@Override
	public void postRunnable(Runnable runnable) {
		Platform.runLater(runnable);
	}

	@Override
	public void startMessageLoop() throws InterruptedException {
		throw new RuntimeException("StartMessageLoop should only be called in non-UI applications.");
	}

	@Override
	public void stopMessageLoop() {
		throw new RuntimeException("StopMessageLoop should only be called in non-UI applications.");
	}

	@Override
	public Thread getOwnerThread() {
		return null;
	}

	@Override
	public void cleanMessageLoop() throws InterruptedException {
		throw new RuntimeException("not supported");
		
	}

}
