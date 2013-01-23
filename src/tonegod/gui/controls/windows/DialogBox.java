/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tonegod.gui.controls.windows;

import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import tonegod.gui.controls.buttons.Button;
import tonegod.gui.core.Screen;

/**
 *
 * @author t0neg0d
 */
public abstract class DialogBox extends AlertBox {
	private Button btnCancel;
	
	public DialogBox(Screen screen, String UID, Vector2f position) {
		this(screen, UID, position,
			screen.getStyle("Window").getVector2f("defaultSize"),
			screen.getStyle("Window").getVector4f("resizeBorders"),
			screen.getStyle("Window").getString("defaultImg")
		);
	}
	
	public DialogBox(Screen screen, String UID, Vector2f position, Vector2f dimensions) {
		this(screen, UID, position, dimensions,
			screen.getStyle("Window").getVector4f("resizeBorders"),
			screen.getStyle("Window").getString("defaultImg")
		);
	}
	
	public DialogBox(Screen screen, String UID, Vector2f position, Vector2f dimensions, Vector4f resizeBorders, String defaultImg) {
		super(screen, UID, position, dimensions, resizeBorders, defaultImg);
		
		Vector4f indents = screen.getStyle("Window").getVector4f("contentIndents");
		
		btnCancel = new Button(screen, UID + ":btnCancel",
			new Vector2f(
				indents.y,
				getHeight()-screen.getStyle("Button").getVector2f("defaultSize").y-indents.w
			)
		) {
			@Override
			public void onMouseLeftDown(MouseButtonEvent evt, boolean toggled) {
				onBtnCancelMouseLeftDown(evt, toggled);
			}
			@Override
			public void onMouseRightDown(MouseButtonEvent evt, boolean toggled) {
				onBtnCancelMouseRightDown(evt, toggled);
			}
			@Override
			public void onMouseLeftUp(MouseButtonEvent evt, boolean toggled) {
				onBtnCancelMouseLeftUp(evt, toggled);
			}
			@Override
			public void onMouseRightUp(MouseButtonEvent evt, boolean toggled) {
				onBtnCancelMouseRightUp(evt, toggled);
			}
			@Override
			public void onStillPressedInterval() { onBtnCancelInterval(); }
			@Override
			public void onButtonFocus(MouseMotionEvent evt) {  }
			@Override
			public void onButtonLostFocus(MouseMotionEvent evt) {  }
		};
		btnCancel.setText("Cancel");
		btnCancel.setDockS(true);
		btnCancel.setDockW(true);
		addChild(btnCancel);
		form.addFormElement(btnCancel);
	}
	
	public void setButtonCancelText(String text) {
		btnCancel.setText(text);
	}
	
	public abstract void onBtnCancelMouseLeftDown(MouseButtonEvent evt, boolean toggled);
	public abstract void onBtnCancelMouseLeftUp(MouseButtonEvent evt, boolean toggled);
	public abstract void onBtnCancelMouseRightDown(MouseButtonEvent evt, boolean toggled);
	public abstract void onBtnCancelMouseRightUp(MouseButtonEvent evt, boolean toggled);
	public abstract void onBtnCancelInterval();
}
