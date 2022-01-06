package webpic;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Webpic extends Shell {
	private Text txtUrl;
	private Text txtWidth;
	private Text txtHeight;
	private Text txtLink;
	private Text txtTitle;
	private Text txtTag;
    private Label lblNewLabel;
    private Label lblLink;
    private Label lblTitle;
    private Label lblTag;
    private Button btnClose;
    private Button btnMkDiv;
    private Button btnGenLink;
    private Label lblName;
    private Button btnCopy;
    private Button btnClear;
    private Text txtName;
    
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Webpic shell = new Webpic(display);
			
			Monitor primary = display.getPrimaryMonitor();
		    Rectangle bounds = primary.getBounds();
		    Rectangle rect = shell.getBounds();
		    
		    int x = bounds.x + (bounds.width - rect.width) / 2;
		    int y = bounds.y + (bounds.height - rect.height) / 2;
		    
		    shell.setLocation(x, y);            
			shell.open();
			shell.layout();

			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void enableAll() {
		txtLink.setEnabled(true);
    	txtTag.setEnabled(true);
    	txtTitle.setEnabled(true);
    	txtTag.setEnabled(true);
    	txtName.setEnabled(true);
    	lblLink.setEnabled(true);
    	lblTitle.setEnabled(true);
    	lblTag.setEnabled(true);
    	lblName.setEnabled(true);
    	btnMkDiv.setEnabled(true);
    	btnCopy.setEnabled(true);
    	btnClear.setEnabled(true);
	}
	
	private void disableAll() {
		txtLink.setEnabled(false);
    	txtTag.setEnabled(false);
    	txtTitle.setEnabled(false);
    	txtTag.setEnabled(false);
    	txtName.setEnabled(false);
    	lblLink.setEnabled(false);
    	lblTitle.setEnabled(false);
    	lblTag.setEnabled(false);
    	lblName.setEnabled(false);
    	btnMkDiv.setEnabled(false);
    	btnCopy.setEnabled(false);
    	btnClear.setEnabled(false);
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Webpic(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.TITLE);
		
		lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblNewLabel.setBounds(20, 26, 167, 27);
		lblNewLabel.setText("Google photos link:");
		
		txtUrl = new Text(this, SWT.BORDER);
		txtUrl.setToolTipText("For example,  https://photos.app.goo.gl/dfcTMUrC64oqEa8L9");
		txtUrl.setBounds(20, 59, 587, 30);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblNewLabel_1.setBounds(338, 23, 62, 27);
		lblNewLabel_1.setText("Width:");
		
		txtWidth = new Text(this, SWT.BORDER);
		txtWidth.setText("1400");
		txtWidth.setBounds(406, 23, 56, 27);
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblNewLabel_2.setBounds(475, 23, 70, 27);
		lblNewLabel_2.setText("Height:");
		
		txtHeight = new Text(this, SWT.BORDER);
		txtHeight.setText("950");
		txtHeight.setBounds(551, 23, 56, 27);
		
		txtLink = new Text(this, SWT.BORDER);
		txtLink.setEditable(false);
		txtLink.setEnabled(false);
		txtLink.setBounds(20, 186, 460, 30);
		
		lblLink = new Label(this, SWT.NONE);
		lblLink.setEnabled(false);
		lblLink.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblLink.setBounds(20, 153, 147, 27);
		lblLink.setText("Permanent Link:");
		
		btnGenLink = new Button(this, SWT.NONE);
		btnGenLink.setBounds(20, 104, 587, 34);
		btnGenLink.setText("Generate Permanent Link");
		
		lblTitle = new Label(this, SWT.NONE);
		lblTitle.setEnabled(false);
		lblTitle.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblTitle.setBounds(20, 231, 50, 27);
		lblTitle.setText("Title:");
		
		txtTitle = new Text(this, SWT.BORDER);
		txtTitle.setEnabled(false);
		txtTitle.setBounds(70, 228, 191, 30);
		
		lblTag = new Label(this, SWT.NONE);
		lblTag.setEnabled(false);
		lblTag.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblTag.setBounds(274, 231, 40, 27);
		lblTag.setText("Tag:");
		
		txtTag = new Text(this, SWT.BORDER);
		txtTag.setEnabled(false);
		txtTag.setBounds(314, 228, 113, 30);
		
		btnClose = new Button(this, SWT.NONE);
		btnClose.setBounds(537, 300, 70, 34);
		btnClose.setText("Close");
		
		btnMkDiv = new Button(this, SWT.NONE);
		btnMkDiv.setEnabled(false);
		btnMkDiv.setBounds(434, 300, 97, 34);
		btnMkDiv.setText("Make Div");
		
		btnCopy = new Button(this, SWT.NONE);
		btnCopy.setEnabled(false);
		btnCopy.setBounds(494, 186, 113, 34);
		btnCopy.setText("Copy Link");
		
		lblName = new Label(this, SWT.NONE);
		lblName.setEnabled(false);
		lblName.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblName.setBounds(433, 231, 62, 27);
		lblName.setText("Name:");
		
		txtName = new Text(this, SWT.BORDER);
		txtName.setEnabled(false);
		txtName.setBounds(494, 228, 113, 30);
		
		btnClear = new Button(this, SWT.NONE);
		btnClear.setEnabled(false);
		btnClear.setBounds(330, 300, 97, 34);
		btnClear.setText("Clear All");

		btnGenLink.addListener(SWT.Selection, new Listener()
		{
		    @Override
		    public void handleEvent(Event event)
		    {   
		    	String link = PermanentLink.run(txtUrl.getText(),
		    			                        Integer.parseInt(txtWidth.getText()),
		    			                        Integer.parseInt(txtHeight.getText()));
		    	if (txtUrl.getText().equals("")) {
		    		txtUrl.setFocus();
		    		return;
		    	}
		    		
		    	switch(link) {
		    	     case "Failure": 
		    	    	lblLink.setEnabled(true);
				    	txtLink.setEnabled(true);
				    	txtLink.setText("[Error] The computation of the permanent link has failed. :(");
				    	txtUrl.setFocus();
				    	break;
		    	     case "NoGP":
		    	    	lblLink.setEnabled(true);
				    	txtLink.setEnabled(true);
				    	txtLink.setText("[Error] The url provided is not from google photos.");
				    	txtUrl.setFocus();
				    	break;
				     default:
				    	 enableAll();
			    		 txtLink.setText(link);
			    		 txtTitle.setFocus();
			    		 break;
		    	}
		    }
		});
		
		btnMkDiv.addListener(SWT.Selection, new Listener()
		{
		    @Override
		    public void handleEvent(Event event)
		    {		    	
		    	DivTemplate div = new DivTemplate(txtLink.getText(),
		    			                          txtTitle.getText(),
		    			                          txtTag.getText(),
		    			                          txtName.getText());
		    	String web_div = div.mkDiv();		    	
		    	try {
		    		Display display = Display.getDefault();
					Output window = new Output(display);
					window.open(web_div);
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		});	

		btnClose.addListener(SWT.Selection, new Listener()
		{
		    @Override
		    public void handleEvent(Event event) {
		        close();
		    }
		});
		
		btnClear.addListener(SWT.Selection, new Listener() {
			@Override
		    public void handleEvent(Event event) {
				txtLink.setText("");
		    	txtTag.setText("");
		    	txtTitle.setText("");
		    	txtName.setText("");
		    	txtUrl.setText("");
		        disableAll();
		        
		    }
		});
		
		btnCopy.addListener(SWT.Selection, new Listener()
		{
		    @Override
		    public void handleEvent(Event e) {
		  		  Toolkit toolkit = Toolkit.getDefaultToolkit();
		  		  Clipboard clipboard = toolkit.getSystemClipboard();
		  		  StringSelection strSel = new StringSelection(txtLink.getText());
		  		  clipboard.setContents(strSel, null);
		    }
		});	
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Webpic");
		setSize(626, 384);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
