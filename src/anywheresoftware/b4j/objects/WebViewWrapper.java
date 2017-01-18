package anywheresoftware.b4j.objects;

import java.util.HashMap;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.scene.Node;
import javafx.scene.web.WebView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4j.objects.PaneWrapper.NativeAndWrapper;

/**
 * WebView is an embedded browser.
 *LocationChanged event is raised whenever the current location changes.
 *PageFinished event is raised after the page is completely loaded.
 */
@ShortName("WebView")
@Events(values={"LocationChanged (Location As String)", "PageFinished (Url As String)"})
public class WebViewWrapper extends NodeWrapper<WebView>{
	static {
		//This line ties the native WebView with this wrapper. It is required for the integration with Scene Builder (FXML layouts).
		PaneWrapper.nativeToWrapper.addFirst(new NativeAndWrapper(WebView.class, WebViewWrapper.class));
	}
	@Override
	@Hide
	public void innerInitialize(final BA ba, final String eventName, boolean keepOldObject) {
		if (!keepOldObject)
			setObject(new WebView());
		super.innerInitialize(ba, eventName, true);
		if (ba.subExists(eventName + "_locationchanged")) {
			getObject().getEngine().locationProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> arg0,
						String arg1, String arg2) {
					ba.raiseEventFromUI(getObject(), eventName + "_locationchanged", arg2);
				}
			});
		}
		if (ba.subExists(eventName + "_pagefinished")) {
			getObject().getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {

				@Override
				public void changed(ObservableValue<? extends State> arg0,
						State arg1, State arg2) {
					if (arg2 == State.SUCCEEDED) {
						ba.raiseEventFromUI(getObject(), eventName + "_pagefinished", getObject().getEngine().getLocation());
					}
				}
			});
		}
	}
	/**
	 * Asynchronously loads the given url.
	 */
	public void LoadUrl(String Url) {
		getObject().getEngine().load(Url);
	}
	/**
	 * Asynchronously loads the given html string.
	 */
	public void LoadHtml(String HtmlString) {
		getObject().getEngine().loadContent(HtmlString);
	}
	
	/**
	 * Gets or sets the control preferred height.
	 */
	public double getPrefHeight() {
		return getObject().getPrefHeight();
	}
	public void setPrefHeight(double d) {
		getObject().setPrefHeight(d);
	}
	/**
	 * Gets or sets the control preferred width.
	 */
	public double getPrefWidth() {
		return getObject().getPrefWidth();
	}
	public void setPrefWidth(double d) {
		getObject().setPrefWidth(d);
	}
	
	public static Node build(Object prev, HashMap<String, Object> props, boolean designer, Object tag) throws Exception{
		WebView vg = (WebView) prev;
		if (vg == null)  {
			vg = NodeWrapper.buildNativeView(WebView.class, props, designer);
			if (designer) {
				vg.getEngine().load("http://www.b4x.com");
			}
		}
		return NodeWrapper.build(vg, props, designer);
	}
	
}