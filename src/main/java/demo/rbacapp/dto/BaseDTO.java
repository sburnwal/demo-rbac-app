package demo.rbacapp.dto;

/**
 * DTOs are good for not exposing all the model fields to the consumers.
 * In general, at the db layer, there would be lot of fields that you may 
 * not want to expose to the clients and also to reduce the network overhead.
 *  
 * @author sburnwal
 */
public class BaseDTO {
	private long id;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
