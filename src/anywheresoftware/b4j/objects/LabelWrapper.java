package anywheresoftware.b4j.objects;

import java.util.HashMap;

import javafx.scene.Node;
import javafx.scene.control.Label;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("Label")
public class LabelWrapper extends LabeledWrapper<Label>{
	@Override
	@Hide
	public void innerInitialize(final BA ba, final String eventName, boolean keepOldObject) {
		if (!keepOldObject)
			setObject(new Label());
		super.innerInitialize(ba, eventName, true);
	}
	@Hide
	public static Node build(Object prev, HashMap<String, Object> props, boolean designer, Object tag) throws Exception{
		Node vg = (Node) prev;
		if (vg == null) 
			vg = NodeWrapper.buildNativeView(Label.class, props, designer);
		return LabeledWrapper.build(vg, props, designer);
	}
}
