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
    private Label lblFilters;
    private Button chbForSale;
    private Button chbGot;
    private Button btnClose;
    private Button btnMkDiv;
    private Button btnGenLink;
    private Label lblOthers;
    private Label lblName;
    private Text txtFilters;    
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
    	txtFilters.setEnabled(true);
    	txtName.setEnabled(true);
    	lblLink.setEnabled(true);
    	lblTitle.setEnabled(true);
    	lblTag.setEnabled(true);
    	lblFilters.setEnabled(true);
    	lblOthers.setEnabled(true);
    	lblName.setEnabled(true);
    	chbForSale.setEnabled(true);    
    	chbGot.setEnabled(true);
    	btnMkDiv.setEnabled(true);
    	btnCopy.setEnabled(true);
    	btnClear.setEnabled(true);
	}
	
	private void disableAll() {
		txtLink.setEnabled(false);
    	txtTag.setEnabled(false);
    	txtTitle.setEnabled(false);
    	txtTag.setEnabled(false);
    	txtFilters.setEnabled(false);
    	txtName.setEnabled(false);
    	lblLink.setEnabled(false);
    	lblTitle.setEnabled(false);
    	lblTag.setEnabled(false);
    	lblFilters.setEnabled(false);
    	lblOthers.setEnabled(false);
    	lblName.setEnabled(false);
    	chbForSale.setEnabled(false);    
    	chbGot.setEnabled(false);
    	btnMkDiv.setEnabled(false);
    	btnCopy.setEnabled(false);
    	btnClear.setEnabled(false);
	}
	
	private String prepareChb() {
		String xs = "";
		
		if (chbForSale.getSelection()) {
			xs = xs + "ForSale,";
	    }
		if (chbGot.getSelection()) {
		   xs = xs + "GOT,";
		}		
		return xs;
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
		
		lblFilters = new Label(this, SWT.NONE);
		lblFilters.setEnabled(false);
		lblFilters.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblFilters.setBounds(20, 280, 70, 27);
		lblFilters.setText("Filters:");
		
		chbForSale = new Button(this, SWT.CHECK);
		chbForSale.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		chbForSale.setEnabled(false);
		chbForSale.setBounds(20, 313, 113, 30);
		chbForSale.setText("For Sale");
		
		chbGot = new Button(this, SWT.CHECK);
		chbGot.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		chbGot.setEnabled(false);
		chbGot.setBounds(121, 313, 113, 30);
		chbGot.setText("Göteborg");
		
		btnClose = new Button(this, SWT.NONE);
		btnClose.setBounds(537, 379, 70, 34);
		btnClose.setText("Close");
		
		btnMkDiv = new Button(this, SWT.NONE);
		btnMkDiv.setEnabled(false);
		btnMkDiv.setBounds(434, 379, 97, 34);
		btnMkDiv.setText("Make Div");
		
		lblOthers = new Label(this, SWT.NONE);
		lblOthers.setToolTipText("");
		lblOthers.setEnabled(false);
		lblOthers.setFont(SWTResourceManager.getFont("Ubuntu", 14, SWT.NORMAL));
		lblOthers.setBounds(274, 280, 126, 27);
		lblOthers.setText("Other Filters:");
		
		txtFilters = new Text(this, SWT.BORDER);
		txtFilters.setToolTipText("Separate filters names with commas");
		txtFilters.setEnabled(false);
		txtFilters.setBounds(274, 313, 333, 30);
		
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
		btnClear.setBounds(330, 379, 97, 34);
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
		    	String filters_chb = prepareChb();
		    	String filters_txt = txtFilters.getText();
		    	String[] filters;
		    		
		    	if (filters_chb.equals(""))
		    		if (filters_txt.equals(""))
		    		    filters = null;
		    		else {
		    			filters = filters_txt.split(",");
		    		}
		    	else {
		    		if (filters_txt.equals("")) {
		    			filters = filters_chb.split(",");				 
		    		}
		    		else {
		    			System.out.println("What?");
		    			filters = (filters_chb+filters_txt).split(",");
		    		}
		    	}
		    	DivTemplate div = new DivTemplate(txtLink.getText(),
		    			                          txtTitle.getText(),
		    			                          txtTag.getText(),
		    			                          txtName.getText(),
		    			                          filters);
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
		    	txtFilters.setText("");
		    	txtUrl.setText("");
		    	chbForSale.setSelection(false);
		    	chbGot.setSelection(false);
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
		setSize(626, 468);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
