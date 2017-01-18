package anywheresoftware.b4j.objects;

import java.util.HashMap;

import javafx.scene.Node;
import javafx.scene.web.HTMLEditor;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4j.objects.NodeWrapper.ControlWrapper;
import anywheresoftware.b4j.objects.PaneWrapper.NativeAndWrapper;

/**
 * HTMLEditor is a built-in text editor that is based on a Html engine.
 *HTMLEditor makes it easy for the user to format their text.
 */
@ShortName("HTMLEditor")
public class HTMLEditorWrapper extends ControlWrapper<HTMLEditor>{
	static {
		PaneWrapper.nativeToWrapper.addFirst(new NativeAndWrapper(HTMLEditor.class, HTMLEditorWrapper.class));
	}
	@Override
	@Hide
	public void innerInitialize(final BA ba, final String eventName, boolean keepOldObject) {
		if (!keepOldObject)
			setObject(new HTMLEditor());
		super.innerInitialize(ba, eventName, true);
	}
	/**
	 * Gets or sets the Html formatted text.
	 */
	public void setHtmlText(String s) {
		getObject().setHtmlText(s);
	}
	public String getHtmlText() {
		return getObject().getHtmlText();
	}
	
	public static Node build(Object prev, HashMap<String, Object> props, boolean designer, Object tag) throws Exception{
		HTMLEditor vg = (HTMLEditor) prev;
		if (vg == null)  {
			vg = NodeWrapper.buildNativeView(HTMLEditor.class, props, designer);
			
		}
		vg.setHtmlText(((String)props.get("text")));
		return ControlWrapper.build(vg, props, designer);
	}
}
