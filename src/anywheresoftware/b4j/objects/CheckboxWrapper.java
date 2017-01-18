package anywheresoftware.b4j.objects;

import java.util.HashMap;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.DontInheritEvents;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4j.objects.NodeWrapper.ButtonBaseWrapper;

/**
 * Checkbox control. The CheckedChange event will be raised when the Checkbox is checked or unchecked.
 */
@ShortName("CheckBox")
@DontInheritEvents
@Events(values={"CheckedChange(Checked As Boolean)"})
public class CheckboxWrapper extends ButtonBaseWrapper<CheckBox>{
	@Override
	@Hide
	public void innerInitialize(final BA ba, final String eventName, boolean keepOldObject) {
		if (!keepOldObject)
			setObject(new CheckBox());
		super.innerInitialize(ba, eventName, true);
		if (ba.subExists(eventName + "_checkedchange")) {
			getObject().selectedProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0,
						Boolean arg1, Boolean arg2) {
					ba.raiseEventFromUI(getObject(), eventName + "_checkedchange", arg2.booleanValue());
				}
			});
		}
	}
	/**
	 * Gets or sets the checked state.
	 */
	public boolean getChecked() {
		return getObject().isSelected();
	}
	public void setChecked(boolean b) {
		getObject().setSelected(b);
	}
	public static Node build(Object prev, HashMap<String, Object> props, boolean designer, Object tag) throws Exception{
		CheckBox vg = (CheckBox) prev;
		if (vg == null) 
			vg = NodeWrapper.buildNativeView(CheckBox.class, props, designer);
		vg.setSelected((Boolean)props.get("checked"));
		return LabeledWrapper.build(vg, props, designer);
	}
}
