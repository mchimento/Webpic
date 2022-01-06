package webpic;

import java.util.HashMap;

public class DivTemplate {
	
	private String title;
	private String tag;
	private String link;
	private String name;
    
	private String card_ws = "                ";
	private String img_ws  = "                      ";
	
	private HashMap <String, Object> map = new HashMap <String, Object> ();
	
	private void intialiseHash() {
		map.put("GOT",0);
		map.put("ForSale",1);
	}
	
	DivTemplate(String link,String title,String tag,String name){
		this.link = link;
		this.title = title;
		this.tag = tag;
		this.name = name;
		intialiseHash();
	}
	
	private String figure() { 
	 return img_ws + "<img class=\"img-fluid img-thumbnail\" \n" +
			img_ws + "     src=\"" + link + "\"\n" +
			img_ws + "     alt=\"" + tag + "\"\n" +
			img_ws + "     data-filename=\"" + name + "\">\n" +
			img_ws + " <div class=\"portfolio-img-overlay\">\n" +
			img_ws + "  <a href=\"" + link + "\"\n" +
			img_ws + "     class=\"cbox-gallary1 mfp-image\"\n" +
			img_ws + "     title=\"" + title + "\">\n" +
			img_ws + "  <span></span>\n" + 
			img_ws + "  </a>\n" +
			img_ws + " </div>\n";
	}
	
	private String mkCard() {	
		return card_ws + "<div class=\"col-lg-4 work-item portfolio-img mt-4\">\n" +
			   card_ws + "  <div class=\"portfolio-img-box\">\n" +
			   card_ws + "    <div class=\"position-relative\">\n" +
			   figure() +
			   card_ws + "    </div>\n" + 
			   card_ws + "  </div>\n" + 
			   card_ws + "</div>";
	}
	
	public String mkDiv () {
		return mkCard();
	}
}
