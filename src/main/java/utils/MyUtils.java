package utils;

import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class MyUtils {

	public static Map formatWeekDay(Map response) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		JsonNode replaceNode = null;
		try {
			json = mapper.writeValueAsString(response);

			JsonNode node = mapper.readTree(json);
			JsonNode locationNode = node.at("/LocatorResponse/SearchResults/DropLocation");

			Iterator<JsonNode> locations = locationNode.elements();

			while (locations.hasNext()) {

				JsonNode accesspoint = locations.next();

				TreeNode operatingNode = accesspoint.at("/OperatingHours");

				ProcessHours[] temp = mapper.treeToValue(operatingNode, ProcessHours[].class);

				JsonNode o = mapper.valueToTree(temp);
				replaceNode = accesspoint.findPath("OperatingHours");
				((ArrayNode) replaceNode).removeAll(); // remove current node

				((ArrayNode) replaceNode).add(o); // add new one with new value
			}

		//	System.out.println("json after update-->" + node);
			response = mapper.convertValue(node, Map.class);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

}
