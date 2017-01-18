package anywheresoftware.b4j.objects;

import java.io.File;

import javafx.stage.DirectoryChooser;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

/**
 * A dialog that allows the user to choose a directory.
 */
@ShortName("DirectoryChooser")
public class DirectoryChooserWrapper extends AbsObjectWrapper<DirectoryChooser>{
	/**
	 * Initializes the object.
	 */
	public void Initialize() {
		setObject(new DirectoryChooser());
	}
	/**
	 * Gets or sets the dialog title.
	 */
	public String getTitle() {
		return getObject().getTitle();
	}
	public void setTitle(String title) {
		getObject().setTitle(title);
	}
	/**
	 * Gets or sets the initial directory.
	 */
	public String getInitialDirectory() {
		return getObject().getInitialDirectory().toString();
	}
	
	public void setInitialDirectory(String s) {
		getObject().setInitialDirectory(new File(s));
	}
	/**
	 * Shows the modal dialog. Returns the selected directory or an empty string.
	 */
	public String Show(Form Owner) {
		File f = getObject().showDialog(Owner.stage);
		if (f == null)
			return "";
		setInitialDirectory(f.toString());
		return f.toString();
	}
}
