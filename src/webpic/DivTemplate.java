package webpic;

import java.util.HashMap;

public class DivTemplate {
	
	private String[] filters;
	private String title;
	private String tag;
	private String link;
	private String name;
    
	private String card_ws = "                ";
	private String figure_ws  = "                 ";
	
	private HashMap <String, Object> map = new HashMap <String, Object> ();
	
	private void intialiseHash() {
		map.put("GOT",0);
		map.put("ForSale",1);
	}
	
	DivTemplate(String link,String title,String tag,String name,String[] filters){
		this.link = link;
		this.title = title;
		this.tag = tag;
		this.filters = filters;
		this.name = name;
		intialiseHash();
	}
	
	private String figure() { 
	 return figure_ws + "<figure class=\"pp-effect\">\n" +
			figure_ws + "  <img data-enlargeable class=\"img-fluid img-thumbnail\" \n" +
			figure_ws + "  src=\"" + link + "\"\n" +
			figure_ws + "  title=\"" + title + "\"\n" +
			figure_ws + "  data-filename=\"" + name + "\"\n" +
			figure_ws + "  alt=\"" + tag + "\"\n" +
			figure_ws + "  style=\"cursor: pointer\">\n" +
	        figure_ws + "</figure>\n";
	}
	
	private String add(String ret, String s) {
		if (ret.equals(""))
		   return "&quot;"+s+"&quot;";
		else {
		   return ret + "," + "&quot;"+s+"&quot;";
		}
	}
	
	private String mkFilters() {
		if (filters==null)
			return "&quot;all&quot;";
		
		String ret = ""; 
		for(int i = 0; i < filters.length;i++) {
			String filter = filters[i];
			
			switch (filter) {
				case "GOT":
					ret = add(ret,"filter-got");
					break;
				case "ForSale":
					ret = add(ret,"filter-sale");
					break;
				default:
					if (!filter.equals("") && !map.containsKey(filter))
						if (ret.equals(""))
						    ret = "&quot;" + filter + "&quot;";
						else {
						    ret = ret + "," + "&quot;" + filter + "&quot;";	
						}
					break;
			}
		}
		return ret;
	}
	
	private String mkCard() {	
		return card_ws + "<div class=\"card\" data-groups=\"[" + mkFilters() + "]\">\n" +
			   figure() +
			   card_ws + "</div>";
	}
	
	public String mkDiv () {
		return mkCard();
	}
}
