package webpic;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Output {	

	private Display display;
	private Shell shlOutput;
	private StyledText stxtOutput;

	Output(Display display) {
		shlOutput = new Shell(display, (SWT.CLOSE | SWT.MIN | SWT.TITLE) & (~SWT.RESIZE));
		shlOutput.setText("Output");
		shlOutput.setSize(732, 457);
		
		stxtOutput = new StyledText(shlOutput, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		stxtOutput.setEditable(false);
		stxtOutput.setBounds(10, 10, 706, 345);
		
		Button btnCopy = new Button(shlOutput, SWT.PUSH);
		btnCopy.setBounds(284, 372, 151, 34);
		btnCopy.setText("Copy Output");
		
		btnCopy.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		  		  Toolkit toolkit = Toolkit.getDefaultToolkit();
		  		  Clipboard clipboard = toolkit.getSystemClipboard();
		  		  StringSelection strSel = new StringSelection(stxtOutput.getText());
		  		  clipboard.setContents(strSel, null);
		  		  shlOutput.close();
		      }
		});
		
		this.display = display;
		
	}

	public void open(String web_div) {
		shlOutput.open();
		shlOutput.layout();
		stxtOutput.setText(web_div);
		
		while (!shlOutput.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
