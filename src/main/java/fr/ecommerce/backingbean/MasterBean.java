package fr.ecommerce.backingbean;



public class MasterBean {

	

	private String promptStatus = null ;
	
//%%%%%%%%%%%%%%%%%%%%%%%%%% action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	

	public MasterBean() {
		// TODO Auto-generated constructor stub
	}

	public String getPromptStatus() {
		return promptStatus;
	}

	public void setPromptStatus(String promptStatus) {
		this.promptStatus = promptStatus;
	}
	public void setPromptStatus(String patern, Object... arguments) {
		this.setPromptStatus( String.format(patern, arguments));
		
	}
	
	public void cleanPromptStatus() {
		this.setPromptStatus(null);
	}
	
	public void clean() {
		this.setPromptStatus(null);
	}
}
