package utils;

import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Day",
    "ClosedIndicator",
    "OpenHours",
    "CloseHours"
})
public class ProcessHours {

    @JsonProperty("Day")
    private String day;
    @JsonProperty("ClosedIndicator")
    private String closedIndicator;
    @JsonProperty("OpenHours")
    private String openHours;
    @JsonProperty("CloseHours")
    private String closeHours;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Day")
    public String getDay() {
        return day;
    }

    @JsonProperty("Day")
    public void setDay(String day) {
    	String setDate=formatDay(day);
        this.day = setDate;
    }

    @JsonProperty("ClosedIndicator")
    public String getClosedIndicator() {
        return closedIndicator;
    }

    @JsonProperty("ClosedIndicator")
    public void setClosedIndicator(String closedIndicator) {
        this.closedIndicator = closedIndicator;
    }

    @JsonProperty("OpenHours")
    public String getOpenHours() {
        return openHours;
    }

    @JsonProperty("OpenHours")
    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    @JsonProperty("CloseHours")
    public String getCloseHours() {
        return closeHours;
    }

    @JsonProperty("CloseHours")
    public void setCloseHours(String closeHours) {
        this.closeHours = closeHours;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    public  String formatDay(String day) {
		DateFormatSymbols dfs = new DateFormatSymbols();
		int modDay = Integer.parseInt(day);
	     return dfs.getWeekdays()[modDay]; 
		
	}
    

	
    

    

}
