package anywheresoftware.b4j.objects;

import java.util.HashMap;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.DontInheritEvents;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4j.objects.NodeWrapper.ControlWrapper;
import anywheresoftware.b4j.objects.PaneWrapper.NativeAndWrapper;
/**
 * A clickable field that opens a color picker dialog.
 */
@ShortName("ColorPicker")
@DontInheritEvents
@Events(values={"ValueChanged (Value As Paint)"})
public class ColorPickerWrapper extends ControlWrapper<ColorPicker>{
	static {
		PaneWrapper.nativeToWrapper.addFirst(new NativeAndWrapper(ColorPicker.class, ColorPickerWrapper.class));
	}
	@Override
	@Hide
	public void innerInitialize(final BA ba, final String eventName, boolean keepOldObject) {
		if (!keepOldObject)
			setObject(new ColorPicker());
		super.innerInitialize(ba, eventName, true);
		if (ba.subExists(eventName + "_valuechanged")) {
			getObject().valueProperty().addListener(new ChangeListener<Object>() {

				@Override
				public void changed(ObservableValue<? extends Object> arg0,
						Object arg1, Object arg2) {
					ba.raiseEventFromUI(getObject(), eventName + "_valuechanged", AbsObjectWrapper.ConvertToWrapper(new JFX.PaintWrapper(),arg2));
				}
			});
		}
	}
	/**
	 * Gets or sets the current value.
	 */
	public Paint getSelectedColor() {
		return getObject().getValue();
	}
	public void setSelectedColor(Paint s) {
		getObject().setValue((Color) s);
	}
	@Hide
	public static Node build(Object prev, HashMap<String, Object> props, boolean designer, Object tag) throws Exception{
		ColorPicker vg = (ColorPicker) prev;
		if (vg == null) 
			vg = NodeWrapper.buildNativeView(ColorPicker.class, props, designer);
		vg.setValue(NodeWrapper.ColorFromBytes(props.get("color")));
		return ControlWrapper.build(vg, props, designer);
	}
	
}
